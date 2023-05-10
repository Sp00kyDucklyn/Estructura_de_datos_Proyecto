/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.proyectografos;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hoshi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int op = -1;
        Scanner tec = new Scanner(System.in);
        
        while (op != 0) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar una ciudad");
            System.out.println("2. Registrar una colindancia entre dos ciudades");
            System.out.println("3. Registrar distancia y costo de peaje entre dos ciudades colindantes");
            System.out.println("4. Modificar distancia y costo de peaje entre dos ciudades colindantes");
            System.out.println("5. Consultar ruta más corta entre dos ciudades");
            System.out.println("6. Consultar ruta más barata entre dos ciudades");
            System.out.println("7. Lista las ciudades registradas y sus colindancias");
            System.out.println("8. Eliminar colindancia");
            System.out.println("9. Eliminar una ciudad del mapa");
            System.out.println("10. Salir");
            System.out.print("--> ");
            op = tec.nextInt();
            switch (op) {
//                case 1:
//                    System.out.println("");
//                    Grafo.imprimir(graph);
//                    ventana.setVisible(true);
//                    break;
//                case 2:
//                    System.out.println("");
//                    List<Arista> e = MST.algortimoKruskal(aristas, 20);
//                    MST.imprimir(e);
//                    break;
//                case 3:
//                    tec.nextLine();
//                    while (ciclo) {
//                        System.out.print("Ingrese la localidad origen: ");
//                        localidad1 = tec.nextLine();
//                        System.out.print("Ingrese la localidad destino: ");
//                        localidad2 = tec.nextLine();
//                        if (graph.encontrarLocalidad(localidad1) < 0 || graph.encontrarLocalidad(localidad2) < 0) {
//                            System.out.println("Error: Localidad no encontrada, revise los nombres en el grafo");
//                        } else {
//                            ciclo = false;
//                        }
//                    }
//                    ciclo = true;
//                    Ruta.rutaMasCorta(Grafo.getTotalAristas(), Grafo.getLocalidades().length, graph.encontrarLocalidad(localidad1), graph.encontrarLocalidad(localidad2));
//                    break;
//                case 0:
//                    System.out.println("Adiós...");
//                    ventana.dispose();
//                    break;
            }
            System.out.println("");
        }
    }
    
}
