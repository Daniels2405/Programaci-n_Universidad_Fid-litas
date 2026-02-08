/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_programada_1;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel-2405
 */
public class Pila {
    private Dato cima;

    public Pila() {
        this.cima = null;
    }

    public boolean isEmpty(){
        return cima == null;
    }

    public void push(int valor){
        Dato nuevoDato = new Dato(valor);
        if (isEmpty()){
                cima = nuevoDato;
        } else {
            nuevoDato.setAbajo(cima);
            cima = nuevoDato;
        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("La pila está vacía");
            return -1;
        } else {
            int valorCima = cima.getValor();
            cima = cima.getAbajo();
            return valorCima;
        }
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("La pila está vacía");
            return -1;
        } else {
            return cima.getValor();
        }
    }

    public int size(){
        Dato actual = cima;
        int i = 0;
        while (actual != null){
            actual = actual.getAbajo();
            i ++;
        }
        return i;
    }

    public void evaluarExpresion(String exprecion, int indice){
        //Caso base cuando el indice sea del tamaño de la exprecion
        if (indice >= exprecion.length()){
            return;
        }

        char caracter = exprecion.charAt(indice);
        int numero = -1;
        if (caracter == '0' || caracter == '1' || caracter == '2' || caracter == '3' || 
            caracter == '4' || caracter == '5' || caracter == '6' || caracter == '7' || 
            caracter == '8' || caracter == '9'){
                numero = Integer.parseInt(String.valueOf(caracter));
        }

        if (caracter == ' '){
            evaluarExpresion(exprecion, indice + 1);
            return;
        }

        try {
            if (0 <= numero && numero <= 9){
                push(numero);
            } else if (esOperador(caracter)) {
                int valor2 = pop();
                int valor1 = pop();
                push(aplicarOperador(valor1, valor2, caracter));
            }else {
                JOptionPane.showMessageDialog(null, "Error, caracter invalido", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            return;
        }

        evaluarExpresion(exprecion, indice + 1);
    }

    private boolean esOperador(char caracter) {
        return caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/';
    }

    private int aplicarOperador(int valor1, int valor2, char operador){
        switch (operador) {
            case '+': 
                return valor1 + valor2;
            case '-': 
                return valor1 - valor2;
            case '*': 
                return valor1 * valor2;
            case '/':
                if (valor2 == 0) {
                    JOptionPane.showMessageDialog(null, "Error: división entre cero", 
                                            "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
                return valor1 / valor2;
            default:
                JOptionPane.showMessageDialog(null, "Error", "Operador no encontrado", JOptionPane.ERROR_MESSAGE);
                return -1;
        }
    }
}
