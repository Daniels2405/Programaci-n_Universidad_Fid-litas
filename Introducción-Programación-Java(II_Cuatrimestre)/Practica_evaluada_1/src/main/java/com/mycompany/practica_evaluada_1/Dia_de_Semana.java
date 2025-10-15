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
public class Dia_de_Semana {
    
    public static void main(String[] args){
        byte dia = Byte.parseByte(JOptionPane.showInputDialog("Coloque el día que desea"));
        if (dia == 1){
            JOptionPane.showMessageDialog(null, "Lunes");
        } else if(dia == 2){
            JOptionPane.showMessageDialog(null, "Martes");
        }else if(dia == 3){
            JOptionPane.showMessageDialog(null, "Miercoles");
        }else if(dia == 4){
            JOptionPane.showMessageDialog(null, "Jueves");
        }else if(dia == 5){
            JOptionPane.showMessageDialog(null, "Viernes");
        }else if(dia == 6){
            JOptionPane.showMessageDialog(null, "Sabado");
        }else if(dia == 7){
            JOptionPane.showMessageDialog(null, "Domingo");
        }else{
            JOptionPane.showMessageDialog(null, "Numero incorrecto");
        }
    }
}
