/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana05;

/**
 *
 * @author daniel-2405
 */
public class PilaDinamica {
     private Nodo cima;
     
    
    public PilaDinamica(){
        cima = null;
    }
    
    public boolean isEmpty(){
        return cima == null;
    }
    
    
    public void push(int dato){
        Nodo nuevoDato = new Nodo(dato);
         if (isEmpty()){
             cima = nuevoDato;
         } else {
             nuevoDato.setSiguiente(cima);
             cima = nuevoDato;
         }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("La pila está vacía");
            return -1;
        } else {
            int dato = cima.getDato();
            cima = cima.getSiguiente();
            return dato;
        }
    }
    public int peek(){
        if (isEmpty()){
            System.out.println("La pila está vacía");
            return -1;
        } else {
            return cima.getDato();
        }
    }

    public void size(){
        if (isEmpty()){
            System.out.println("Esta vacia");
        }
        Nodo actual = cima;
        while (actual != null){
            actual = actual.getSiguiente();
        }
    }
    public void contieneE(){
        if (isEmpty()){
            System.out.println("Esta vacia");
        }
        StringBuilder sb = new StringBuilder();
        Nodo actual = cima;
        while (actual != null){
            sb.append(actual.getDato()).append(" ");
            actual = actual.getSiguiente();
        }
    }
}