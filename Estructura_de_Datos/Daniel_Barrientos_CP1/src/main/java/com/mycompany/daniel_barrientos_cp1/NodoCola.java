/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daniel_barrientos_cp1;

/**
 *
 * @author Administrator
 */
public class NodoCola {
    int dato; // Dato almacenado en el nodo
    NodoCola siguiente; // Referencia al siguiente nodo

    public NodoCola(int dato) {
        this.dato = dato; // Asigna el dato al nodo
        this.siguiente = null; // Inicialmente, no hay siguiente nodo
    }
}
