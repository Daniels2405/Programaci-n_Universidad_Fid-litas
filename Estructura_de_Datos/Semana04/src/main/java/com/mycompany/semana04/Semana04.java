/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana04;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel-2405
 */
public class Semana04 {

    public static void main(String[] args) {
        /**  
         * * ------Demostracion de la pila-------
        Pila pila = new Pila();
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);

        System.out.println("Pila despues de aplicar 10, 20, 30, 40: "
                            + pila.peek());
        
        System.out.println("Elemento desapilado: " + pila.pop());
        System.out.println("Despues de desapilar: " + pila.peek());

        System.out.println("Elemento desapilado: " + pila.pop());
        System.out.println("Despues de desapilar: " + pila.peek());
         * * ------------------------------------
        //! -----Navegador------
        PilaN historial = new PilaN();
        boolean rep = true;
        
        while (rep) {
            String respuesta = JOptionPane.showInputDialog("Seleccione 1 para agregar una url, 2 para ver el historial, 3 para eliminar la ultima url, 4 para salir");

            switch (respuesta) {
                case "1":
                    String url = JOptionPane.showInputDialog("Busque una url");
                    historial.push(url);
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Historial de navegacion: " + historial.peek());
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Ultima url eliminada: " + historial.pop());
                    break;
                case "4":
                    rep = false;
                    break;
                default:
                    break;
            }
        } 
        * !----------------------------
        */ 

        Pila pila = new Pila();
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);

        System.out.println("Pila en orden inverso: " + pila.mostrarInverso());

    }
}
