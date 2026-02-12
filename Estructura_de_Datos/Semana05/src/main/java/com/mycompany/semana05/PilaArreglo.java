/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana05;

/**
 *
 * @author daniel-2405
 */
public class PilaArreglo {
    private int[] pila;
    private int top;
    private int maxSize;

    public PilaArreglo(int tamaño) {
        pila = new int[tamaño];
        top = -1;
        maxSize = tamaño;
    }
    
    public void push (int elemento){
        if (top == maxSize -1){
            System.out.println("La pila esta llena");
        } else{
            pila[++top] = elemento;
        }
    }
    
    public int pop(){
        if (top == -1){
            System.out.println("La pila esta vacia");
            return -1;
        }else {
            return pila[top--];
        }
    }
    
    public int peek(){
        if (top == -1){
            System.out.println("La pila esta vacia");
            return -1;
        }else {
            return pila[top];
        }
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public void mostrar(){
        if (this.isEmpty()){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("Contenido de la pila:");
            for (int i = top; i >= 0; i--){
                System.out.println(pila[i]);
            }
        }
    }
    
}
