/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_evaluada_1;
import javax.swing.JOptionPane;
/**
 *
 * @author daniel
 */
public class Practica_swich {
    public static void main(String[] args) {
        byte mes = Byte.parseByte(JOptionPane.showInputDialog("Coloque el mes que desea saber su cantidad de días"));
        switch (mes){
            case 2:
                JOptionPane.showMessageDialog(null, "Este mes tiene 28 / 29 Dias");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                JOptionPane.showMessageDialog(null, "Este mes tiene 30 Dias");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Este mes tiene 31 Dias");
                break;
        }
    }
}
