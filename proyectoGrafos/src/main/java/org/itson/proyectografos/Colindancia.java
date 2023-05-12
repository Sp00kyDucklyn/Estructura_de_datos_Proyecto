/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

/**
 *
 * @author Kimberly Serrano pon tú id aquí & Carmen Hernández 240210
 */
class Colindancia {
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private int distancia;
    private int costoPeaje;

    public Colindancia(Ciudad ciudadOrigen, Ciudad ciudadDestino, int distancia, int costoPeaje) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.distancia = distancia;
        this.costoPeaje = costoPeaje;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getCostoPeaje() {
        return costoPeaje;
    }

    public void setCostoPeaje(int costoPeaje) {
        this.costoPeaje = costoPeaje;
    }
}
    

