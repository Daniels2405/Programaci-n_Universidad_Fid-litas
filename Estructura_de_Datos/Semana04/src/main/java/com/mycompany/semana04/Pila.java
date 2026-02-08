/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana04;

/**
 *
 * @author daniel-2405
 */
public class Pila {
    private Dato cima;
    
    public Pila(){
        cima = null;
    }
    
    public boolean isEmpty(){
        return cima == null;
    }
    
    
    public void push(int valor){
        Dato nuevoDato = new Dato(valor);
        if (1 <= nuevoDato.getValor() && nuevoDato.getValor() <= 1000){
            if (isEmpty()){
                cima = nuevoDato;
            } else {
                nuevoDato.setAbajo(cima);
                cima = nuevoDato;
            }
        } else {
            System.out.println("El valor debe estar entre 1 y 1000");
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

    public String peek(){
        if (isEmpty()){
            return "La pila está vacia";
        }

        StringBuilder sb = new StringBuilder();
        Dato actual = cima;
        while (actual != null){
            sb.append(actual.getValor()).append(" ");
            actual = actual.getAbajo();
        }
        return sb.toString().trim();
    }

    public String mostrarInverso(){
        if (isEmpty()){
            return "La pila está vacia";
        }

        StringBuilder sb = new StringBuilder();
        Dato actual = cima;
        while (actual != null){
            sb.append(actual.getValor()).append(" ");
            actual = actual.getAbajo();
            //System.out.print(actual.getValor() + " ");
        }
        return sb.toString().trim();
    }
}
