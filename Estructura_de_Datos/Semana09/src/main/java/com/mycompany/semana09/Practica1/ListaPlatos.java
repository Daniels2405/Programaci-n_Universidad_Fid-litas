/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana09.Practica1;

/**
 *
 * @author daniel-2405
 */
public class ListaPlatos {
    NodoPlatos cabeza, ultimo;

    public ListaPlatos() {
        cabeza = null;
        ultimo = null;
    }

    public void agregarPlato(String nombrePlato, int precio) {
        NodoPlatos nuevo = new NodoPlatos(nombrePlato, precio);
        if (cabeza == null) {
            cabeza = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public void mostrarMenu(){
        NodoPlatos actual = cabeza;
        while (actual != null) {
            System.out.println(actual.nombrePlato + " - $" + actual.precio);
            actual = actual.siguiente;
        }
    }

    public void siguientePlato(){
        NodoPlatos actual = cabeza;
        if (actual == null) {
            System.out.println("El menú está vacío.");
            return;
        }
        if (actual.siguiente != null) {
            System.out.println(actual.siguiente.nombrePlato + " - $" + actual.siguiente.precio);
        } else {
            System.out.println("No hay más platos en el menú.");
        }
    }
}
