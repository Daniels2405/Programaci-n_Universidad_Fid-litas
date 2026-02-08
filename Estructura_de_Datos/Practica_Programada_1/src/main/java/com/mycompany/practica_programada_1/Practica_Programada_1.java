/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica_programada_1;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel-2405
 */
public class Practica_Programada_1 {

    public static void main(String[] args) {
        int indice = 0;
        String expresion = JOptionPane.showInputDialog("Ingrese una expresion en notacion postfija:");

        if (expresion == null || expresion.isEmpty()){
            JOptionPane.showMessageDialog(null, "Expresion vacia", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pila pila = new Pila();

        pila.evaluarExpresion(expresion, indice);

        if (pila.isEmpty()){
            return;
        }

        int resultado = pila.pop();

        if (!pila.isEmpty()){
            JOptionPane.showMessageDialog(null, "Expresion invalida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Resultado: " + resultado, "Resultado de la expresion", JOptionPane.INFORMATION_MESSAGE);

    }
}
