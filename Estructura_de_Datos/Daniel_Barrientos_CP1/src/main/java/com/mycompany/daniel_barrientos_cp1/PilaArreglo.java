/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daniel_barrientos_cp1;

/**
 *
 * @author Administrator
 */
public class PilaArreglo {

    private int[] pila;    // Arreglo para almacenar elementos
    private int top;       // Puntero de la cima
    private int maxSize;   // Tamaño máximo de la pila

    // Constructor
    public PilaArreglo(int tamaño) {
        maxSize = tamaño;
        pila = new int[maxSize];
        top = -1; // Inicialmente la pila esta vacia
    }

    // Método para apilar un elemento
    public void push(int elemento) {
        if (top == maxSize - 1) {
            System.out.println("Error: Desbordamiento. La pila esta llena.");
        } else {
            pila[++top] = elemento; // Incrementa top y almacena el elemento
        }
    }

    // Método para desapilar un elemento
    public int pop() {
        if (top == -1) {
            System.out.println("Error: Subdesbordamiento. La pila esta vacia.");
            return -1; // Indica un error
        } else {
            return pila[top--]; // Devuelve el elemento y decrementa top
        }
    }

    // Método para consultar la cima
    public int peek() {
        if (top == -1) {
            System.out.println("La pila esta vacia.");
            return -1;
        } else {
            return pila[top];
        }
    }

    // Método para verificar si la pila está vacia
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Método para mostrar el contenido de la pila
    public void mostrar() {
        if (this.isEmpty()) {
            System.out.println("La pila esta vacia.");
        } else {
            System.out.println("Contenido de la pila:");
            for (int i = top; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
    }
    
    public int contarRecursivo() {
        return contar(this);
    }

    private int contar(PilaArreglo pila) {
        // EL CASO BASE NO ESTA DEFINIDO
        // TODO: EL ESTUDIANTE DEBE AGREGARLO
        if (top == -1){
            return 0;
        }
        int valor = pila.pop(); // Retira el elemento superior
        int total = 1 + contar(pila); // Llamada recursiva
        pila.push(valor); // Restaurar la pila al estado original
        return total;
    }
}
