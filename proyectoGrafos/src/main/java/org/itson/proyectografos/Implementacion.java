/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
/**
 *
 * @author Kimberly Serrano pon tú id aquí & Carmen Hernández 240210
 */
public class Implementacion {
    
    private List<Ciudad> ciudades;

    public Implementacion(List<Ciudad> ciudades) {
        ciudades = new ArrayList<>();
    }

    public void agregarCiudad(String nombreCiudad) {
        Ciudad ciudad = new Ciudad(nombreCiudad);
        ciudades.add(ciudad);
    }

    public Ciudad buscarCiudad(String nombreCiudad) {
        for (Ciudad ciudad : ciudades) {
            if (ciudad.getNombre().equals(nombreCiudad)) {
                return ciudad;
            }
        }
        return null;
    }
    
    private Colindancia buscarColindancia(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        List<Colindancia> colindancias = ciudadOrigen.getColindancias();
        for (Colindancia colindancia : colindancias) {
            if (colindancia.getCiudadDestino().equals(ciudadDestino)) {
                return colindancia;
            }
        }
        return null;
    }
    
    public void agregarColindancia(String nombreCiudadOrigen, String nombreCiudadDestino, int distancia, int costoPeaje) {
        Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
        Ciudad ciudadDestino = buscarCiudad(nombreCiudadOrigen);
        if (ciudadOrigen != null && ciudadDestino != null) {
            Colindancia colindancia = new Colindancia(ciudadOrigen, ciudadDestino, distancia, costoPeaje);
            ciudadOrigen.agregarColindancia(colindancia);
        }
    }
    
    public void registrarDistanciaYCostoPeaje(String nombreCiudadOrigen, String nombreCiudadDestino, int distancia, int costoPeaje) {
        Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
        Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);

        if (ciudadOrigen != null && ciudadDestino != null) {
            Colindancia colindancia = new Colindancia(ciudadOrigen, ciudadDestino, distancia, costoPeaje);
            ciudadOrigen.agregarColindancia(colindancia);
            // También agregamos la colindancia inversa para mantener la simetría
            Colindancia colindanciaInversa = new Colindancia(ciudadDestino, ciudadOrigen, distancia, costoPeaje);
            ciudadDestino.agregarColindancia(colindanciaInversa);
        }
    }

    public void modificarDistanciaYCostoPeaje(String nombreCiudadOrigen, String nombreCiudadDestino, int distancia, int costoPeaje) {
        Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
        Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);

        if (ciudadOrigen != null && ciudadDestino != null) {
            // Buscamos la colindancia en ambas direcciones para actualizarla
            Colindancia colindancia1 = buscarColindancia(ciudadOrigen, ciudadDestino);
            Colindancia colindancia2 = buscarColindancia(ciudadDestino, ciudadOrigen);

            if (colindancia1 != null && colindancia2 != null) {
                colindancia1.setDistancia(distancia);
                colindancia1.setCostoPeaje(costoPeaje);
                colindancia2.setDistancia(distancia);
                colindancia2.setCostoPeaje(costoPeaje);
            }
        }
    }
    
    public void consultarRutaMasCorta(String nombreCiudadOrigen, String nombreCiudadDestino) {
        Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
        Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);

        if (ciudadOrigen == null || ciudadDestino == null) {
            System.out.println("Ciudad origen o destino no encontrada");
            return;
        }

        // Mapa de distancias desde el origen a cada ciudad
        Map<Ciudad, Integer> distancias = new HashMap<>();

        // Mapa de predecesores para reconstruir el camino
        Map<Ciudad, Ciudad> predecesores = new HashMap<>();

        // Conjunto de ciudades visitadas
        Set<Ciudad> visitados = new HashSet<>();

        // Inicialización de las distancias
        for (Ciudad ciudad : ciudades) {
            if (ciudad.equals(ciudadOrigen)) {
                distancias.put(ciudad, 0);
            } else {
                distancias.put(ciudad, Integer.MAX_VALUE);
            }
        }

        // Bucle principal
        while (!visitados.contains(ciudadDestino)) {
            // Buscar la ciudad con la distancia mínima
            Ciudad ciudadActual = null;
            int distanciaMinima = Integer.MAX_VALUE;
            for (Ciudad ciudad : ciudades) {
                if (!visitados.contains(ciudad) && distancias.get(ciudad) < distanciaMinima) {
                    ciudadActual = ciudad;
                    distanciaMinima = distancias.get(ciudad);
                }
            }

            if (ciudadActual == null) {
                // No se encontró ninguna ciudad no visitada
                break;
            }

            // Marcar la ciudad actual como visitada
            visitados.add(ciudadActual);

            // Actualizar las distancias de los vecinos de la ciudad actual
            for (Colindancia colindancia : ciudadActual.getColindancias()) {
                Ciudad ciudadVecina = colindancia.getCiudadDestino();
                if (!visitados.contains(ciudadVecina)) {
                    int nuevaDistancia = distancias.get(ciudadActual) + colindancia.getDistancia();
                    if (nuevaDistancia < distancias.get(ciudadVecina)) {
                        distancias.put(ciudadVecina, nuevaDistancia);
                        predecesores.put(ciudadVecina, ciudadActual);
                    }
                }
            }
        }

        // Reconstruir el camino si se encontró una ruta
        if (predecesores.containsKey(ciudadDestino)) {
            List<Ciudad> ruta = new ArrayList<>();
            Ciudad ciudadActual = ciudadDestino;
            while (!ciudadActual.equals(ciudadOrigen)) {
                ruta.add(0, ciudadActual);
                ciudadActual = predecesores.get(ciudadActual);
            }
            ruta.add(0, ciudadOrigen);

            // Imprimir la ruta y la distancia total
            // Imprimir la ruta y la distancia total
            if (ruta.isEmpty()) {
                System.out.println("No se encontró ruta entre " + ciudadOrigen.getNombre() + " y " + ciudadDestino.getNombre());
            } else {
                System.out.print("Ruta más corta de " + ciudadOrigen.getNombre() + " a " + ciudadDestino.getNombre() + ": ");
                for (int i = 0; i < ruta.size(); i++) {
                    System.out.print(ruta.get(i).getNombre());
                    if (i < ruta.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println("\nDistancia total: " + distancias.get(ciudadDestino));
            }
        }
    }

 }
    //List<Colindancia> conex = new ArrayList<>();
    //Graph<String, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
//    
//    public boolean buscarCiudad(String ciudad) {
//    return grafo.containsVertex(ciudad);
//    }
//    
//    public boolean buscarColindancia(String ciudad, Ciudad[] colindancias){
//       for (Ciudad colindancia : colindancias) {
//                 if(!grafo.containsEdge(ciudad, colindancia.getNombre())){
//                     return false;
//                 }
//                }
//       return true;
//    }
//    
//    public void agregarCiudad(Ciudad ciudad){
//        grafo.addVertex(ciudad.getNombre());
//    }
//    
//    public void registrarColindancia(Ciudad ciudad, Ciudad[] colindancias){
//        if(this.buscarCiudad(ciudad.getNombre())){
//             for (Ciudad colindancia : colindancias) {
//                 if(!this.buscarCiudad(ciudad.getNombre())){
//                     grafo.addVertex(colindancia.getNombre());
//                 }
//                    grafo.addEdge(ciudad.getNombre(), colindancia.getNombre());
//                }
//        }
//    }
//    
//    public void registrarDistancia(Ciudad ciudad, Ciudad[] colindancias, 
//            int distancia, int costo){
//        if(this.buscarColindancia(ciudad.getNombre(), colindancias)){
//            for(Ciudad colindancia: colindancias){
//                Colindancia conexion = new Colindancia(ciudad, colindancia, distancia, costo);
//                conex.add(conexion);
//            }
//        }
//    }
   
    

