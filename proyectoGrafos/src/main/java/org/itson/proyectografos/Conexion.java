/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.proyectografos;

/**
 *
 * @author Kimberly Serrano pon tú id aquí & Carmen Hernández 240210
 */
public class Conexion {
    private Ciudad origen;
    private Ciudad destino;
    private int distancia;
    private int costo;

    public Conexion(Ciudad origen, Ciudad destino, int distancia, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.costo = costo;
    }

    

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }
    
}
