/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_1;
import javax.swing.JOptionPane;
/**
 *
 * @author daniel
 */
public class Semana_1 {

    public static void main(String[] args) {
        String nombre = "Daniel";
        System.out.println("Mi nimbre es: "+nombre);
        
        byte numero1 = Byte.parseByte(JOptionPane.showInputDialog("Digite el número 1"));
        byte numero2 = Byte.parseByte(JOptionPane.showInputDialog("Digite el número 2"));
        byte numero3 = Byte.parseByte(JOptionPane.showInputDialog("Digite el número 3"));
        byte numero4 = Byte.parseByte(JOptionPane.showInputDialog("Digite el número 4"));
        long resultadoSuma = 0;
        double resultadoPromedio = 0;
        
        resultadoSuma = numero1 + numero2 + numero3 + numero4;
        resultadoPromedio = resultadoSuma / 4;
        
        JOptionPane.showMessageDialog(null,"El resultado de la suma de los 4 numeros es " + resultadoSuma);
        System.out.println("El resultado de la suma de los 4 numeros es " + resultadoSuma);
        System.out.println("El resultado del promedio de los 4 numeros es " + resultadoPromedio);
    }
}
