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

}
