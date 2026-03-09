/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana08;

/**
 *
 * @author daniel-2405
 */
public class ListaEnlazada {
    Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }
    
    public void insertarInicio(int valor){
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    
    public void eliminarNodo(int valor){
        Nodo actual = cabeza, anterior = null;
        while (actual != null && actual.dato != valor){
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual == null) return;
        if (anterior == null) cabeza = actual.siguiente;
        else anterior.siguiente = actual.siguiente;
    }
    
    public boolean buscar(int valor){
        Nodo actual = cabeza;
        while (actual != null){
            if (actual.dato == valor) return true;
            actual = actual.siguiente;
        }
        return false;
    }
    
    public void recorrer(){
        Nodo actual = cabeza;
        while (actual != null){
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }
}
