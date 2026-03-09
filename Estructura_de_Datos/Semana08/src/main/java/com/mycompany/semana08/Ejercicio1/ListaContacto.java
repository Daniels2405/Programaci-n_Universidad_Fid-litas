/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana08.Ejercicio1;

import com.mycompany.semana08.Nodo;

/**
 *
 * @author daniel-2405
 */
public class ListaContacto {
    NodoContacto cabeza;

    public ListaContacto() {
        this.cabeza = null;
    }
    
    public void insertarInicio(String nombre, String numero){
        Contacto nuevoContacto = new Contacto(nombre, numero);
        NodoContacto nuevo = new NodoContacto(nuevoContacto);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    
    public void eliminarNodo(String nombre){
        NodoContacto actual = cabeza, anterior = null;
        while (actual != null && !actual.dato.nombre.equals(nombre)){
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual == null) return;
        if (anterior == null) cabeza = actual.siguiente;
        else anterior.siguiente = actual.siguiente;
    }
    
    public boolean buscar(String nombre){
        NodoContacto actual = cabeza;
        while (actual != null){
            if (actual.dato.nombre.equals(nombre)) return true;
            actual = actual.siguiente;
        }
        return false;
    }
    
    public void recorrer(){
        NodoContacto actual = cabeza;
        while (actual != null){
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("NULL");
    }
}
