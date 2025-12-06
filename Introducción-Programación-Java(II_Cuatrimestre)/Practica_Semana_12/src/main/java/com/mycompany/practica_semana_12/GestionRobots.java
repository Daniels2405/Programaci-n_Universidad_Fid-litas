/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.practica_semana_12;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author daniel-2405
 */
public class GestionRobots {
    static Robot[] robots = new Robot[10];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        inicializarRobots();
        menu();
    }
    
    //-----------------Inicializar robots------------
    public static void inicializarRobots(){
        for (int i = 0; i < 10; i++){
            int id = (int)(Math.random() * 1000) + 1;
            char letra = (char) ('A' + (int)(Math.random() * 26));
            int numero = (int)(Math.random() * 9) + 1;
            String modelo = "Omega-" + letra + numero;

            int bateria = (int)(Math.random() * 86) + 5;

            TipoFuncion funcion = TipoFuncion.values()[(int)(Math.random() * 4)];
            
            robots[i] = new Robot(id, modelo, bateria, funcion);
        }
    }
    
    //---------Menu Principal----------
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean rep = true;
        
        while (rep == true && opcion != 5){
            System.out.println("\n===== SISTEMA CENTRAL DE CONTROL DE ROBOTS OMEGA =====");
            System.out.println("1. Editar robot");
            System.out.println("2. Mostrar robots");
            System.out.println("3. Recargar robots (< 50%)");
            System.out.println("4. Simular trabajo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1 -> editarRobot();
                case 2 -> mostrarRobots();
                case 3 -> recargarRobots();
                case 4 -> simularTrabajo();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        }
    }
    
    //-----------Editar---------------
    public static void editarRobot(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del robot: ");
        int id = scanner.nextInt();

        Robot r = buscarRobot(id);
        if (r == null) {
            System.out.println("El robot no existe.");
            return;
        }

        System.out.println("Editando robot: " + r.getModelo());

        System.out.print("Nuevo modelo: ");
        String modelo = scanner.next();
        r.setModelo(modelo);

        System.out.print("Nueva batería (0–100): ");
        int bateria = scanner.nextInt();
        if (bateria < 0 || bateria > 100) {
            System.out.println("Valor inválido. No se modificó la batería.");
        } else {
            r.setBateria(bateria);
        }

        System.out.println("Seleccione función:");
        System.out.println("1. CONSTRUCCION");
        System.out.println("2. VIGILANCIA");
        System.out.println("3. ASISTENCIA");
        System.out.println("4. EXPLORACION");
        int f = scanner.nextInt();

        if (f >= 1 && f <= 4) {
            r.setFuncion(TipoFuncion.values()[f - 1]);
        } else {
            System.out.println("Función inválida.");
        }

        System.out.println("Robot actualizado exitosamente.");
    }
    
    //----------------- Mostrar -------------
    public static void mostrarRobots() {
        System.out.println("===== LISTA DE ROBOTS =====");
        for (int i = 0; i < robots.length; i++) {
            System.out.println(robots[i].mostrarRobot());
        }
    }
    
    //---------------- Recargar ------------
    public static void recargarRobots() {
        System.out.println("Recargando robots con batería < 50%...");

        for (int i = 0; i < robots.length; i++) {
            Robot r = robots[i];

            if (r.getBateria() < 50) {
                int recarga = (int)(Math.random() * 21) + 10; // 10 a 30
                int nuevaBateria = Math.min(100, r.getBateria() + recarga);
                System.out.println("Robot " + r.getModelo() + " recargado " +
                recarga + "%. Batería actual: " + nuevaBateria + "%");

                r.setBateria(nuevaBateria);
            }
        }
    }
    
    // -----------Trabajo----------
    public static void simularTrabajo() {
        System.out.println("===== SIMULANDO TRABAJO =====");

        for (int i = 0; i < robots.length; i++) {
            Robot r = robots[i];
            int consumo = 0;

            switch (r.getFuncion()) {
                case CONSTRUCCION -> consumo = 50;
                case VIGILANCIA -> consumo = 10;
                case ASISTENCIA -> consumo = 20;
                case EXPLORACION -> consumo = 30;
            }

            if (r.getBateria() >= consumo) {
                r.setBateria(r.getBateria() - consumo);
                System.out.println("Robot " + r.getModelo() +
                        " está realizando " + r.getFuncion().toString().toLowerCase() +
                        ". Se restará " + consumo + "% de su batería.");
            } else {
                System.out.println("Robot " + r.getModelo() +
                        " NO tiene suficiente batería para realizar " +
                        r.getFuncion() + ". Requiere recarga.");
            }
        }
    }
    
    // ------------------------- BUSCAR ROBOT -------------------------
    public static Robot buscarRobot(int id) {
    for (int i = 0; i < robots.length; i++) {
        if (robots[i].getId() == id) {
            return robots[i];
            }
        }
    return null;
    }

}
