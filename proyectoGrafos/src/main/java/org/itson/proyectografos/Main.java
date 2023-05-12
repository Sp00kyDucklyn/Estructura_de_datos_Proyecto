/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.proyectografos;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Kimberly Serrano pon tú id aquí & Carmen Hernández 240210
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Implementacion implementacion = new Implementacion(null);
        Scanner tec = new Scanner(System.in);
        int op = -1;
        
        
        while (op != 0) {
            System.out.println("---- Menú ----");
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
            tec.nextLine();
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
                  case 1:
                    System.out.println("Nombre de la ciudad:");
                    String nombreCiudad = tec.nextLine();
                    implementacion.agregarCiudad(nombreCiudad);
                    System.out.println("Ciudad agregada correctamente.");
                    break;
                case 2:
                    System.out.println("Nombre de la ciudad origen:");
                    String nombreCiudadOrigen = tec.nextLine();
                    System.out.println("Nombre de la ciudad destino:");
                    String nombreCiudadDestino = tec.nextLine();
                    System.out.println("Distancia:");
                    int distancia = tec.nextInt();
                    System.out.println("Costo de peaje:");
                    int costoPeaje = tec.nextInt();
                    implementacion.agregarColindancia(nombreCiudadOrigen, nombreCiudadDestino, distancia, costoPeaje);
                    System.out.println("Colindancia agregada correctamente.");
                    break;
                case 3:
                    System.out.println("Nombre de la ciudad origen:");
                    nombreCiudadOrigen = tec.nextLine();
                    System.out.println("Nombre de la ciudad destino:");
                    nombreCiudadDestino = tec.nextLine();
                    System.out.println("Distancia:");
                    distancia = tec.nextInt();
                    System.out.println("Costo de peaje:");
                    costoPeaje = tec.nextInt();
                    implementacion.registrarDistanciaYCostoPeaje(nombreCiudadOrigen, nombreCiudadDestino, distancia, costoPeaje);
                    System.out.println("Distancia y costo de peaje registrados correctamente.");
                    break;
                case 4:
                    System.out.println("Nombre de la ciudad origen:");
                    nombreCiudadOrigen = tec.nextLine();
                    System.out.println("Nombre de la ciudad destino:");
                    nombreCiudadDestino = tec.nextLine();
                    System.out.println("Nueva distancia:");
                    distancia = tec.nextInt();
                    System.out.println("Nuevo costo de peaje:");
                    costoPeaje = tec.nextInt();
                    implementacion.modificarDistanciaYCostoPeaje(nombreCiudadOrigen, nombreCiudadDestino, distancia, costoPeaje);
                    System.out.println("Distancia y costo de peaje modificados correctamente.");
                    break;
                case 5:
                    System.out.println("Nombre de la ciudad origen:");
                    nombreCiudadOrigen = tec.nextLine();
                    System.out.println("Nombre de la ciudad destino:");
                    nombreCiudadDestino = tec.nextLine();
                    implementacion.consultarRutaMasCorta(nombreCiudadOrigen, nombreCiudadDestino);
                    break;
                case 0:
                    System.out.println("Adiós.");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
   


}
