/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

/**
 *
 * @author Kimberly Serrano 233023 aquí & Carmen Hernández 240210
 */
class Colindancia {

    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private Integer distancia;
    private Integer costoPeaje;

    public Colindancia(Ciudad ciudadOrigen, Ciudad ciudadDestino, Integer distancia, Integer costoPeaje) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.distancia = distancia;
        this.costoPeaje = costoPeaje;
    }

    public Colindancia(Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    public Colindancia(Integer distancia, Integer costoPeaje) {
        this.distancia = distancia;
        this.costoPeaje = costoPeaje;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer getCostoPeaje() {
        return costoPeaje;
    }

    public void setCostoPeaje(Integer costoPeaje) {
        this.costoPeaje = costoPeaje;
    }

}
