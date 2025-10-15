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
public class Practica_profe {
    public static void main(String[] args) {
        byte nota = Byte.parseByte(JOptionPane.showInputDialog("Coloque la nota de su examen"));
        if (nota < 12){
        JOptionPane.showMessageDialog(null, "No aprobo el examen");
        }
    }
}