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
        Implementacion implementacion = new Implementacion();
        int op = -1;
        Scanner tec = new Scanner(System.in);
        
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
                    System.out.print("Ingrese el nombre de la ciudad: ");
                    String nombreCiudad = tec.nextLine();
                    Ciudad ciudad = new Ciudad(nombreCiudad);
                    implementacion.agregarCiudad(ciudad);
                    System.out.println("Ciudad agregada exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la ciudad: ");
                    String nombreCiudadOrigen = tec.nextLine();
                    System.out.print("Ingrese el número de colindancias: ");
                    int numColindancias = tec.nextInt();
                    tec.nextLine(); // Limpiar el buffer de entrada
                    Ciudad[] colindancias = new Ciudad[numColindancias];
                    for (int i = 0; i < numColindancias; i++) {
                        System.out.print("Ingrese el nombre de la colindancia #" + (i+1) + ": ");
                        String nombreColindancia = tec.nextLine();
                        Ciudad colindancia = new Ciudad(nombreColindancia);
                        colindancias[i] = colindancia;
                    }
                    Ciudad ciudadOrigen = new Ciudad(nombreCiudadOrigen);
                    implementacion.registrarColindancia(ciudadOrigen, colindancias);
                    System.out.println("Colindancias registradas exitosamente.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la ciudad origen: ");
                    String nombreCiudadOrigen2 = tec.nextLine();
                    System.out.print("Ingrese el número de ciudades destino: ");
                    int numCiudadesDestino = tec.nextInt();
                    tec.nextLine(); // Limpiar el buffer de entrada
                    Ciudad[] ciudadesDestino = new Ciudad[numCiudadesDestino];
                    for (int i = 0; i < numCiudadesDestino; i++) {
                        System.out.print("Ingrese el nombre de la ciudad destino #" + (i+1) + ": ");
                        String nombreCiudadDestino = tec.nextLine();
                        Ciudad ciudadDestino = new Ciudad(nombreCiudadDestino);
                        ciudadesDestino[i] = ciudadDestino;
                    }
                    System.out.print("Ingrese la distancia: ");
                    int distancia = tec.nextInt();
                    System.out.print("Ingrese el costo: ");
                    int costo = tec.nextInt();
                    tec.nextLine(); // Limpiar el buffer de entrada
                    Ciudad ciudadOrigen2 = new Ciudad(nombreCiudadOrigen2);
                    implementacion.registrarDistancia(ciudadOrigen2, ciudadesDestino, distancia, costo);
                    System.out.println("Distancias registradas exitosamente.");
                    break;
            }
            System.out.println("");
        }
    }
    
}
