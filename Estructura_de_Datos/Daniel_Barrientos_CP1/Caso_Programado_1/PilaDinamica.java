/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase05_estructuras;

/**
 *
 * @author Administrator
 */
public class PilaDinamica {

    private NodoPila cima; // Referencia al último nodo apilado (cima)

    public PilaDinamica() {
        this.cima = null; // Inicialmente la pila está vacía
    }

    // Método para apilar un elemento
    public void push(int dato) {
        NodoPila nuevoNodo = new NodoPila(dato);
        nuevoNodo.siguiente = cima; // El nuevo nodo apunta a la antigua cima
        cima = nuevoNodo;           // La cima ahora es el nuevo nodo
    }

    // Método para desapilar un elemento
    public int pop() {
        if (cima == null) {
            System.out.println("Error: La pila esta vacia.");
            return -1; // Valor indicador de error
        }
        int dato = cima.dato;       // Guardar el dato de la cima
        cima = cima.siguiente;      // Mover la cima al siguiente nodo
        return dato;
    }

    // Método para mostrar el contenido actual de la pila
    public void mostrar() {
        if (cima == null) {
            System.out.println("La pila está vacia.");
            return;
        }

        NodoPila actual = cima;
        System.out.println("Contenido de la pila:");
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
    
    // Método para verificar si un elemento está en la pila
    public boolean contieneElem(int elemento) {
        NodoPila actual = cima;

        while (actual != null) {
            if (actual.dato == elemento) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }
    
    public int contarRecursivo() {
        return contar(this);
    }

    private int contar(PilaDinamica pila) {
        // EL CASO BASE NO ESTA DEFINIDO
        // TODO: EL ESTUDIANTE DEBE AGREGARLO

        int valor = pila.pop(); // Retira el elemento superior

        int total = 1 + contar(pila); // Llamada recursiva

        pila.push(valor); // Restaurar la pila

        return total;
    }

}
