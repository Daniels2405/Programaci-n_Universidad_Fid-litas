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
public class Practica_edad_Votacion {

    public static void main(String[] args) {
        byte edad = Byte.parseByte(JOptionPane.showInputDialog("Coloque su edad"));
        if (edad >= 18){
            JOptionPane.showMessageDialog(null, "Si puede votar"); 
        }else{
            JOptionPane.showMessageDialog(null, "No puede votar");
        }
        
    }
}
