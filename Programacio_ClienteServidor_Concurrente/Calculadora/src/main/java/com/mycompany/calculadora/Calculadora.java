/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadora;

import javax.swing.SwingUtilities;

/**
 *
 * @author daniel-2405
 */
public class Calculadora {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { new CalculadoraGUI().setVisible(true); });
    }
}
