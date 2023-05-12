/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

/**
 *
 * @author Kimberly Serrano pon tú id aquí & Carmen Hernández 240210
 */
import java.util.*;

public class Ciudad {
    private String nombre;
    private List<Colindancia> colindancias;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        colindancias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n");
        for (Colindancia colindancia : colindancias) {
            sb.append("colinda con ").append(colindancia.getCiudadDestino().getNombre());
            sb.append(" (distancia: ").append(colindancia.getDistancia());
            sb.append(", peaje: ").append(colindancia.getCostoPeaje()).append(")\n");
        }
        return sb.toString();
    }
}
    

