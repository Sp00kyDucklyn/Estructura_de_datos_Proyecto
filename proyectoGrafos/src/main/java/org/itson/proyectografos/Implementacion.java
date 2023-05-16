/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 *
 * @author Kimberly Serrano 233023 & Carmen Hernández 240210
 */
public class Implementacion {

    private List<Ciudad> ciudades = new ArrayList<>();

    private Colindancia buscarColindancia(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        List<Colindancia> colindancias = ciudadOrigen.getColindancias();
        for (Colindancia colindancia : colindancias) {
            if (colindancia.getCiudadDestino().equals(ciudadDestino)) {
                return colindancia;
            }
        }
        return null;
    }

    public Ciudad buscarCiudad(String nombreCiudad) {
        for (Ciudad ciudad : ciudades) {
            if (ciudad.getNombre().equals(nombreCiudad)) {
                return ciudad;
            }
        }
        return null;
    }

    public void imprimirCiudades() {
        for (Ciudad ciudad : ciudades) {
            System.out.println(ciudad.getNombre());
        }
    }

    // 1) Agregar una ciudad
    public void agregarCiudad(String nombreCiudad) {
        if (buscarCiudad(nombreCiudad) == null) {
            Ciudad ciudad = new Ciudad(nombreCiudad);
            ciudades.add(ciudad);
            System.out.println("Ciudad '" + nombreCiudad + "' agregada correctamente.");
        } else {
            System.out.println("Esta ciudad ya esta registrada.");
        }
    }

    // 2) Registrar una colindancia entre dos ciudades
    public void agregarColindancia(String nombreCiudadOrigen, String nombreCiudadDestino) {
        Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
        Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);
        if (ciudadOrigen == null) {
            System.out.println("La ciudad de origen " + nombreCiudadOrigen + " no está registrada");
        } else if (ciudadDestino == null) {
            System.out.println("La ciudad de destino " + nombreCiudadDestino + " no está registrada");
        } else if (buscarColindancia(ciudadOrigen, ciudadDestino) == null || buscarColindancia(ciudadDestino, ciudadOrigen) == null) {
            Colindancia colindancia = new Colindancia(ciudadOrigen, ciudadDestino);
            Colindancia colindanciaInversa = new Colindancia(ciudadDestino, ciudadOrigen);
            ciudadOrigen.agregarColindancia(colindancia);
            ciudadDestino.agregarColindancia(colindanciaInversa);
            System.out.println("Colindancia agregada correctamente.");
        } else {
            System.out.println("Esta colindancia ya fue registrada anteriormente.");
        }
    }

    //3) Registrar distancia y costo de peaje entre dos ciudades colindantes
    public void agregarColindancia(String nombreCiudadOrigen, String nombreCiudadDestino, Integer distancia, Integer costoPeaje) {
        Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
        Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);
        if (ciudadOrigen == null) {
            System.out.println("La ciudad de origen " + nombreCiudadOrigen + " no está registrada");
        } else if (ciudadDestino == null) {
            System.out.println("La ciudad de destino " + nombreCiudadDestino + " no está registrada");
        } else if (buscarColindancia(ciudadOrigen, ciudadDestino) != null && (buscarColindancia(ciudadDestino, ciudadOrigen) != null)) {
            Colindancia colindanciaObtenida = buscarColindancia(ciudadOrigen, ciudadDestino);
            Colindancia colindanciaObtenidaInversa = buscarColindancia(ciudadDestino, ciudadOrigen);
            if (colindanciaObtenida.getCostoPeaje() == null && colindanciaObtenida.getDistancia() == null
                    && colindanciaObtenidaInversa.getCostoPeaje() == null && colindanciaObtenidaInversa.getDistancia() == null) {
                colindanciaObtenida.setCostoPeaje(costoPeaje);
                colindanciaObtenida.setDistancia(distancia);
                colindanciaObtenidaInversa.setCostoPeaje(costoPeaje);
                colindanciaObtenidaInversa.setDistancia(distancia);
                System.out.println("Distancia y costo de peaje registrados correctamente.");
            } else {
                System.out.println("Esta colindancia ya tiene peaje y distancia, si desea editarlos vaya a la opción 4.");
            }

        } else {
            System.out.println("No hay colindancia entre estas dos ciudades.");
        }
    }

    //4) Modificar distancia y costo de peaje entre dos ciudades colindantes
    public void modificarDistanciaYCostoPeaje(String nombreCiudadOrigen, String nombreCiudadDestino, Integer distancia, Integer costoPeaje) {
        Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
        Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);

        if (ciudadOrigen != null && ciudadDestino != null) {
            // Buscamos la colindancia en ambas direcciones para actualizarla
            Colindancia colindancia1 = buscarColindancia(ciudadOrigen, ciudadDestino);
            Colindancia colindancia2 = buscarColindancia(ciudadDestino, ciudadOrigen);

            if (colindancia1 != null && colindancia2 != null) {
                if (colindancia1.getCostoPeaje() != null && colindancia1.getDistancia() != null
                        && colindancia2.getCostoPeaje() != null && colindancia2.getDistancia() != null) {
                    colindancia1.setDistancia(distancia);
                    colindancia1.setCostoPeaje(costoPeaje);
                    colindancia2.setDistancia(distancia);
                    colindancia2.setCostoPeaje(costoPeaje);
                    System.out.println("Distancia y costo de peaje modificados correctamente.");
                } else {
                    System.out.println("No hay datos para modificar, si desea agregarlos vaya a la opción 3.");
                }

            } else {
                System.out.println("No hay colindancia entre estas dos ciudades.");
            }
        } else {
            System.out.println("Alguna de las ciudades no existe, por favor revisa si esta bien escrita o ya fue agregada.");
        }
    }
    
    // 5) Consultar ruta más corta entre dos ciudades

    //7) Listar las ciudades registradas y sus colindancias
    public void listarCiudadesConColidancias() {
        for (Ciudad ciudad : ciudades) {
            System.out.println("Ciudad: " + ciudad.getNombre());
            for (int i = 0; i < ciudad.getColindancias().size(); i++) {
                System.out.println("Colinda con " + ciudad.getColindancias().get(i).getCiudadDestino().getNombre());
            }
            System.out.println(" ");
        }
    }

    //8) Eliminar colindancia
    public void eliminarColindancia(String nombreCiudadOrigen, String nombreCiudadDestino) {
        Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
        Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);
        if (ciudadOrigen == null) {
            System.out.println("La ciudad de origen " + nombreCiudadOrigen + " no está registrada");
        } else if (ciudadDestino == null) {
            System.out.println("La ciudad de destino " + nombreCiudadDestino + " no está registrada");
        } else if (buscarColindancia(ciudadOrigen, ciudadDestino) != null || buscarColindancia(ciudadDestino, ciudadOrigen) != null) {
            Colindancia colindancia = buscarColindancia(ciudadOrigen, ciudadDestino);
            Colindancia colindanciaInversa = buscarColindancia(ciudadDestino, ciudadOrigen);
            ciudadOrigen.eliminarColindancia(colindancia);
            ciudadDestino.eliminarColindancia(colindanciaInversa);
            System.out.println("Colindancia eliminada correctamente.");
        } else {
            System.out.println("Esta colindancia no existe.");
        }
    }

    //9) Eliminar una ciudad del mapa
    public void eliminarCiudad(String ciudadEliminar) {
        if (buscarCiudad(ciudadEliminar) != null) {
            Ciudad ciudad = buscarCiudad(ciudadEliminar);
            ciudad.getColindancias().clear();
            ciudades.remove(ciudad);

            for (Ciudad ciudadInterar : ciudades) {
                for (int i = 0; i < ciudadInterar.getColindancias().size(); i++) {
                    if (ciudadInterar.getColindancias().get(i).getCiudadDestino().getNombre().equals(ciudadEliminar)) {
                        Colindancia colindancia = ciudadInterar.getColindancias().get(i);
                        ciudadInterar.eliminarColindancia(colindancia);
                    }
                }
            }

            System.out.println(ciudad.getNombre() + " <- Eliminada correctamente.");
        } else {
            System.out.println("No hay registro de esta ciudad.");
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
    //////////////////////////////////////////////////
     public void calcularRutaMasCorta(String nomOrigen, String nomDestino) {
        Ciudad origen = buscarCiudad(nomOrigen);
        Ciudad destino = buscarCiudad(nomDestino);
        //Aqui esta el problema
        origen.setDistancia(0);
        PriorityQueue<Ciudad> cola = new PriorityQueue<>();
        cola.add(origen);

        while (!cola.isEmpty()) {
            Ciudad actual = cola.poll();
            actual.setVisitado(true);

            for (Colindancia colindancia : actual.getColindancias()) {
                Ciudad vecino = colindancia.getCiudadDestino();
                //Aqui otro problema
                int distancia = colindancia.getDistancia();
                int nuevaDistancia = actual.getDistancia() + distancia;

                if (!vecino.isVisitado() && nuevaDistancia < vecino.getDistancia()) {
                    cola.remove(vecino);
                    vecino.setDistancia(nuevaDistancia);
                    vecino.setPrevia(actual);
                    cola.add(vecino);
                }
            }
        }

        // Imprimir la ruta más corta
        Ciudad ciudad = destino;
         System.out.println("La ruta mas corta es");
        while (ciudad != null) {
            System.out.print(ciudad.getNombre() + " -> ");
            ciudad = ciudad.getPrevia();
        }
    }
     
     public void calcularRutaMasBarata(String nombreCiudadOrigen, String nombreCiudadDestino) {
    Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
    Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);
    if (ciudadOrigen == null) {
        System.out.println("La ciudad de origen " + nombreCiudadOrigen + " no está registrada");
    } else if (ciudadDestino == null) {
        System.out.println("La ciudad de destino " + nombreCiudadDestino + " no está registrada");
    } else {
        // Establecemos la distancia de la ciudad de origen a 0
        ciudadOrigen.setDistancia(0);

        // Ejecutamos el algoritmo de Bellman-Ford para encontrar la ruta más barata
        for (int i = 1; i < ciudades.size(); i++) {
            for (Ciudad ciudad : ciudades) {
                for (Colindancia colindancia : ciudad.getColindancias()) {
                    Ciudad ciudadOrigenColindancia = colindancia.getCiudadOrigen();
                    Ciudad ciudadDestinoColindancia = colindancia.getCiudadDestino();
                    if (ciudadOrigenColindancia == ciudad) {
                        int distanciaAcumulada = ciudad.getDistancia() + colindancia.getCostoPeaje();
                        if (distanciaAcumulada < ciudadDestinoColindancia.getDistancia()) {
                            ciudadDestinoColindancia.setDistancia(distanciaAcumulada);
                            ciudadDestinoColindancia.setPrevia(ciudad);
                        }
                    }
                }
            }
        }

        // Verificamos si hay ciclos negativos
        for (Ciudad ciudad : ciudades) {
            for (Colindancia colindancia : ciudad.getColindancias()) {
                Ciudad ciudadOrigenColindancia = colindancia.getCiudadOrigen();
                Ciudad ciudadDestinoColindancia = colindancia.getCiudadDestino();
                int distanciaAcumulada = ciudadOrigenColindancia.getDistancia() + colindancia.getCostoPeaje();
                if (distanciaAcumulada < ciudadDestinoColindancia.getDistancia()) {
                    System.out.println("Hay ciclos negativos en el grafo");
                    return;
                }
            }
        }

        // Construimos la ruta más barata
        List<Ciudad> ruta = new ArrayList<>();
        for (Ciudad ciudad = ciudadDestino; ciudad != null; ciudad = ciudad.getPrevia()) {
            ruta.add(ciudad);
        }
        Collections.reverse(ruta);
        System.out.print("Ruta más barata de " + nombreCiudadOrigen + " a " + nombreCiudadDestino + ": ");
        for (Ciudad ciudad : ruta) {
            System.out.print(ciudad.getNombre() + " ");
        }
        System.out.println("Distancia total: " + ciudadDestino.getDistancia());
    }
}


//    public List<Ciudad> encontrarRutaMasBarata(String nombreCiudadOrigen, String nombreCiudadDestino) {
//    // Buscar las ciudades de origen y destino
//    Ciudad ciudadOrigen = buscarCiudad(nombreCiudadOrigen);
//    Ciudad ciudadDestino = buscarCiudad(nombreCiudadDestino);
//
//    // Verificar que las ciudades existan
//        if (ciudadOrigen == null) {
//            System.out.println("La ciudad de origen " + nombreCiudadOrigen + " no está registrada");
//            return null;
//        }
//
//        if (ciudadDestino == null) {
//            System.out.println("La ciudad de destino " + nombreCiudadDestino + " no está registrada");
//            return null;
//        }
//
//
//    // Inicializar la tabla de distancias y padres
//    Map<Ciudad, Integer> distancias = new HashMap<>();
//    Map<Ciudad, Ciudad> padres = new HashMap<>();
//    for (Ciudad ciudad : ciudades) {
//        distancias.put(ciudad, Integer.MAX_VALUE);
//        padres.put(ciudad, null);
//    }
//    distancias.put(ciudadOrigen, 0);
//
//    // Crear el conjunto de ciudades no visitadas
//    Set<Ciudad> noVisitadas = new HashSet<>(ciudades);
//
//    // Aplicar el algoritmo de Dijkstra
//    while (!noVisitadas.isEmpty()) {
//        // Buscar la ciudad no visitada con la distancia más corta
//        Ciudad ciudadActual = null;
//        int distanciaMinima = Integer.MAX_VALUE;
//        for (Ciudad ciudad : noVisitadas) {
//            int distancia = distancias.get(ciudad);
//            if (distancia < distanciaMinima) {
//                ciudadActual = ciudad;
//                distanciaMinima = distancia;
//            }
//        }
//
//        // Si no hay ciudad actual, terminar el algoritmo
//        if (ciudadActual == null) {
//            break;
//        }
//
//        // Marcar la ciudad actual como visitada
//        noVisitadas.remove(ciudadActual);
//
//        // Actualizar las distancias de las ciudades vecinas no visitadas
//        List<Colindancia> colindancias = ciudadActual.getColindancias();
//        for (Colindancia colindancia : colindancias) {
//            Ciudad ciudadVecina = colindancia.getCiudadDestino();
//            if (noVisitadas.contains(ciudadVecina)) {
//                int distanciaNueva = distancias.get(ciudadActual) + colindancia.getDistancia();
//                if (distanciaNueva < distancias.get(ciudadVecina)) {
//                    distancias.put(ciudadVecina, distanciaNueva);
//                    padres.put(ciudadVecina, ciudadActual);
//                }
//            }
//        }
//    }
//
//    // Reconstruir la ruta más corta
//    List<Ciudad> ruta = new ArrayList<>();
//    Ciudad ciudadActual = ciudadDestino;
//    while (ciudadActual != null) {
//        ruta.add(0, ciudadActual);
//        ciudadActual = padres.get(ciudadActual);
//    }
//
//    // Verificar que se encontró una ruta
//    if (ruta.size() <= 1) {
//        System.out.println("No se encontró una ruta entre " + nombreCiudadOrigen + " y " + nombreCiudadDestino);
//        return null;
//    }
//
//    // Imprimir la ruta y la distancia total
//    int distanciaTotal = distancias.get(ciudadDestino);
//        System.out.println("Ruta más barata entre " + nombreCiudadOrigen + " y " + nombreCiudadDestino + ": ");
//
//        for (int i = 0; i < ruta.size() - 1; i++) {
//            Ciudad ciudadOrigen1 = ruta.get(i);
//            Ciudad ciudadDestino1 = ruta.get(i + 1);
//            Colindancia colindancia = ciudadOrigen1.getColindancias(ciudadDestino1);
//            System.out.println("- " + ciudadOrigen1.getNombre() + " a " + ciudadDestino1.getNombre() + " (" + colindancia.getDistancia() + " km)");
//        }
//
//    System.out.println("Distancia total: " + distanciaTotal + " km");
//
//    return ruta;
//}



    public void calcularRutaMasBarata() {
        
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

