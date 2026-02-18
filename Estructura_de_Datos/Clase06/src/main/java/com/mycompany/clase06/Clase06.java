/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase06;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel-2405
 */
public class Clase06 {
public static Cola cola = new Cola();
    public static void main(String[] args) {
        ejercicio01();
    }

    public static void ejemplo(){
        try {
            cola.Enqueue(10);
            cola.Enqueue(20);
            cola.Enqueue(30);

            System.out.println("Elemento al frente: " + cola.front());

            System.out.println("Elemento eliminado: " + cola.Dequeue());

            System.out.println("Elemento al frente: " + cola.front());

            cola.Enqueue(40);

            while (!cola.isEmpty()) {
                System.out.println("Elemento eliminado: " + cola.Dequeue());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void ejercicio01(){
        boolean repetir = true;
        int contadorDeTurnos = 1;
        while (repetir) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("\n 1) Solicitar un turno \n 2) Atender turno \n 3) Mostrar turno Actual \n 4) Verificar si hay pacientes esperando \n 5) Salir del programa"));
                switch (opcion) {
                case 1:
                    cola.Enqueue(contadorDeTurnos);
                    JOptionPane.showMessageDialog(null, "Se agrego el turno #" + contadorDeTurnos);
                    contadorDeTurnos++;
                    if (contadorDeTurnos == 100) {
                        contadorDeTurnos = 1;
                    }
                    break;
                case 2: 
                try {
                        JOptionPane.showMessageDialog(null, "Se atendio el turno #" + cola.Dequeue());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                    case 3:
                        try {
                            JOptionPane.showMessageDialog(null, "Esta esperando el turno #" + cola.front());
                        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, cola.isEmpty());
                    break;
                    case 5:
                        repetir = false;
                        default:
                            break;
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
    }
    public static void ejercicio02(){
        
    }
}
