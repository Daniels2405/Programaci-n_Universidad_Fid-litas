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
public class Salarios {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Indique su nombre");
        byte años_antiguedad = Byte.parseByte(JOptionPane.showInputDialog("Indique sus años trabajando para la empresa"));
        byte horas_trabajadas = Byte.parseByte(JOptionPane.showInputDialog("Indique cuantas horas semanales trabaja"));
        int paga_por_hora = Integer.parseInt(JOptionPane.showInputDialog("Indique en $ cuanto le pagan por hora"));
        double salario_bruto = horas_trabajadas * paga_por_hora;
        if (años_antiguedad>=12){
            salario_bruto = salario_bruto + (salario_bruto * 0.055);
        }
        if (salario_bruto > 2500){
            if(salario_bruto > 3500){
                salario_bruto = salario_bruto - (salario_bruto * 0.038);
            }
            else{
                salario_bruto = salario_bruto - (salario_bruto * 0.027);
            }    
        }
        JOptionPane.showMessageDialog(null, "El salario bruto de " + nombre + " es de $" + salario_bruto);
    }
}
