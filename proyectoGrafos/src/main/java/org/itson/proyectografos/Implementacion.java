/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
/**
 *
 * @author hoshi
 */
public class Implementacion {
    
    Graph<String, DefaultEdge> grafo = new SimpleGraph<>(DefaultEdge.class);
    
    public boolean buscarCiudad(String ciudad) {
    return grafo.containsVertex(ciudad);
    }
    
    public void agregarCiudad(String ciudad){
        grafo.addVertex(ciudad);
    }
    
    public void registrarColindancia(String ciudad, String[] colindancias){
        if(this.buscarCiudad(ciudad)){
             for (String colindancia : colindancias) {
                 if(!this.buscarCiudad(ciudad)){
                     grafo.addVertex(colindancia);
                 }
                    grafo.addEdge(ciudad, colindancia);
                }
        }
    }
    
    public void costoPeaje(){
        
        
    }
    
    public void registrarDistancia(){
        
    }
    
    public void modificarDistancia(){
        
    }
    
    public void rutaMasCorta(){
        
    }
    
    
}
