/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana09.Practica1;

/**
 *
 * @author daniel-2405
 */
public class NodoPlatos {
    String nombrePlato;
    int precio;
    NodoPlatos siguiente;
    public NodoPlatos(String nombrePlato, int precio) {
        this.nombrePlato = nombrePlato;
        this.precio = precio;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "NodoPlatos{" + "nombrePlato=" + nombrePlato + ", precio=" + precio + ", siguiente=" + siguiente + '}';
    }
    
    
}
