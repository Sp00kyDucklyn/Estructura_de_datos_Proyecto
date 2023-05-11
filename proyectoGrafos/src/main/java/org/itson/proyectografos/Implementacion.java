/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

import java.util.ArrayList;
import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
/**
 *
 * @author Kimberly Serrano pon tú id aquí & Carmen Hernández 240210
 */
public class Implementacion {
    List<Conexion> conex = new ArrayList<>();
    Graph<String, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
    
    public boolean buscarCiudad(String ciudad) {
    return grafo.containsVertex(ciudad);
    }
    
    public boolean buscarColindancia(String ciudad, Ciudad[] colindancias){
       for (Ciudad colindancia : colindancias) {
                 if(!grafo.containsEdge(ciudad, colindancia.getNombre())){
                     return false;
                 }
                }
       return true;
    }
    
    public void agregarCiudad(Ciudad ciudad){
        grafo.addVertex(ciudad.getNombre());
    }
    
    public void registrarColindancia(Ciudad ciudad, Ciudad[] colindancias){
        if(this.buscarCiudad(ciudad.getNombre())){
             for (Ciudad colindancia : colindancias) {
                 if(!this.buscarCiudad(ciudad.getNombre())){
                     grafo.addVertex(colindancia.getNombre());
                 }
                    grafo.addEdge(ciudad.getNombre(), colindancia.getNombre());
                }
        }
    }
    
    public void registrarDistancia(Ciudad ciudad, Ciudad[] colindancias, 
            int distancia, int costo){
        if(this.buscarColindancia(ciudad.getNombre(), colindancias)){
            for(Ciudad colindancia: colindancias){
                Conexion conexion = new Conexion(ciudad, colindancia, distancia, costo);
                conex.add(conexion);
            }
        }
    }
    
    public void modificarDistancia(){
        
    }
    
    public void rutaMasCorta(){
        
    }
    
    public void imprimirCiudades(){
        
    }
    
    
}
