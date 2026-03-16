/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlist;

/**
 *
 * @author daniel-2405
 */
public class NodoCancion {
    String nombre, artista;
    NodoCancion siguiente;
    NodoCancion anterior;
    
    public NodoCancion(String nombre, String artista){
        this.nombre = nombre;
        this.artista = artista;
        this.siguiente = this;
        this.anterior = this;
    }
}
