/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase_06_estructuras;

/**
 *
 * @author Administrator
 */
public class Cola {
    private NodoCola frente; // Apunta al primer elemento de la cola
    private NodoCola fin; // Apunta al último elemento de la cola

    public Cola() {
        this.frente = null; // Inicializa la cola vacía
        this.fin = null;
    }

    // Operación para insertar un elemento (Enqueue)
    public void encolar(int dato) {
        NodoCola nuevo = new NodoCola(dato); // Crea un nuevo nodo con el dato
        if (fin != null) { // Si la cola no está vacía
            fin.siguiente = nuevo; // Apunta el último nodo al nuevo nodo
        }
        fin = nuevo; // Actualiza el puntero al último nodo
        if (frente == null) { // Si la cola estaba vacía
            frente = nuevo; // El nuevo nodo es también el primer nodo
        }
    }
    
    // Operación para eliminar un elemento (Dequeue)
    public int desencolar() throws Exception {
        if (frente == null) { // Verifica si la cola está vacía
            throw new Exception("La cola esta vacia"); // Lanza una excepción si no hay elementos
        }
        int dato = frente.dato; // Guarda el dato del primer elemento
        frente = frente.siguiente; // Mueve el puntero al siguiente nodo
        if (frente == null) { // Si la cola queda vacía después de eliminar
            fin = null; // El puntero al final también se actualiza
        }
        return dato; // Devuelve el dato eliminado
    }

    // Operación para ver el elemento al frente
    public int frente() throws Exception {
        if (frente == null) { // Verifica si la cola está vacía
            throw new Exception("La cola está vacia");
        }
        return frente.dato; // Devuelve el dato al frente sin eliminarlo
    }

    // Verificar si la cola está vacía
    public boolean estaVacia() {
        return frente == null; // Devuelve true si no hay elementos
    }
    
    public int contarRec(Cola cola) throws Exception {
        // EL CASO BASE NO ESTA DEFINIDO
        // TODO: EL ESTUDIANTE DEBE AGREGARLO

        int valor = cola.desencolar();

        int cantidad = 1 + contarRec(cola);

        cola.encolar(valor); // restaurar la estructura original

        return cantidad;
    }
}
