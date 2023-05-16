/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

/**
 *
 * @author Kimberly Serrano 233023 & Carmen Hernández 240210
 */
import java.util.*;

public class Ciudad implements Comparable<Ciudad>{

    private String nombre;
    private List<Colindancia> colindancias;
    private int distancia;
    private boolean visitado;
    private Ciudad previa;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        colindancias = new ArrayList<>();
        distancia = Integer.MAX_VALUE;
        visitado = false;
        previa = null;
    }

    public String getNombre() {
        return nombre;
    }
    
     public boolean isVisitado() {
        return visitado;
    }

    public void agregarColindancia(Colindancia colindancia) {
        colindancias.add(colindancia);
    }

    public List<Colindancia> getColindancias() {
        return colindancias;
    }

    public void eliminarColindancia(Colindancia colindancia) {
        colindancias.remove(colindancia);
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Ciudad getPrevia() {
        return previa;
    }

    public void setPrevia(Ciudad previa) {
        this.previa = previa;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColindancias(List<Colindancia> colindancias) {
        this.colindancias = colindancias;
    }

   @Override
    public int compareTo(Ciudad otraCiudad) {
        return Integer.compare(distancia, otraCiudad.getDistancia());
    }
    

}
