/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana09;

import java.util.Scanner;
import javax.swing.JOptionPane;

import com.mycompany.semana09.Ejemplos.*;
import com.mycompany.semana09.Practica1.*;
import com.mycompany.semana09.Practica2.*;

/**
 *
 * @author daniel-2405
 */
public class Semana09 {

    public static void main(String[] args) {
        /** pruebaListaCircular();
        pruebaListaDoble();
        pruebaListaDobleCircular();
        */ 
        Ejercicio2();
    }
    //Ejemplos en clases
    public static void pruebaListaCircular(){
        ListaCircular lista = new ListaCircular();
        lista.insertatOrdenado(10);
        lista.insertatOrdenado(20);
        lista.insertatOrdenado(30);
        lista.recorrer();
    }

    public static void pruebaListaDoble(){
        ListaDoble lista = new ListaDoble();
        lista.insertarOrdenado(10);
        lista.insertarOrdenado(20);
        lista.insertarOrdenado(30);
        lista.mostrarAdelante();
        lista.mostrarAtras();
    }

    public static void pruebaListaDobleCircular(){
        ListaDobleCircular lista = new ListaDobleCircular();
        lista.insertar(10);
        lista.insertar(20);
        lista.insertar(30);
        lista.mostrarAdelante();
        lista.insertarOrdenado(25);
        lista.mostrarAdelante();
    }

    //Practicas
    public static void Ejercicio1(){
        Scanner scan = new Scanner(System.in);
        boolean rep = true;
        ListaPlatos lista = new ListaPlatos();
        while (rep) {
            System.out.println("==== Menú ======");
            System.out.println("1. Agregar Plato");
            System.out.println("2. Mostrar Menu");
            System.out.println("3. Siguiente Plato");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scan.nextInt();
            System.out.println("---------");
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del plato: ");
                    String nombrePlato = scan.next();
                    System.out.print("Ingrese el precio del plato: ");
                    int precio = scan.nextInt();
                    lista.agregarPlato(nombrePlato, precio);
                    System.out.println("---------");
                    break;
                case 2:
                    lista.mostrarMenu();
                    System.out.println("---------");
                    break;
                case 3:
                    lista.siguientePlato();
                    System.out.println("---------");
                    break;
                case 4:
                    rep = false;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } 
    }

    public static void Ejercicio2(){
        Boolean rep = true;
        ListaPagina lista = new ListaPagina();
        while (rep) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "==== Menú ====\n"
                        + "1. Visitar página\n"
                        + "2. Mostrar historial\n"
                        + "3. Avanzar\n"
                        + "4. Retroceder\n"
                        + "5. Salir\n"
                        + "Ingrese una opción: ", "Menú", JOptionPane.PLAIN_MESSAGE));
                switch (opcion) {
                    case 1:
                        String url = JOptionPane.showInputDialog("Ingrese la URL de la página: ");
                        String titulo = JOptionPane.showInputDialog("Ingrese el título de la página: ");
                        lista.visitarPagina(url, titulo);
                        break;
                    case 2:
                        lista.mostrarHistorial();
                        break;
                    case 3:
                        lista.avanzar();
                        break;
                    case 4:
                        lista.retroceder();
                        break;
                    case 5:
                        rep = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
}
