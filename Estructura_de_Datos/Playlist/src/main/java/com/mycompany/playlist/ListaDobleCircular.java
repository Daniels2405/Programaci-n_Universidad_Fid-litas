/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlist;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel-2405
 */
public class ListaDobleCircular {
    NodoCancion cabeza;
    NodoCancion actual;

    public ListaDobleCircular(){
        this.cabeza = null;
        this.actual = null;
    }

    //Agregar Cancion
    public void agregarCancion(String nombre, String artista) {
        NodoCancion nuevo = new NodoCancion(nombre, artista);

        if (cabeza == null) {
            // Lista vacía: el nodo se enlaza a sí mismo
            cabeza = nuevo;
            actual = nuevo;
        } else {
            // Insertar antes de cabeza (al final, circular)
            NodoCancion ultimo = cabeza.anterior;
            nuevo.siguiente = cabeza;
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            cabeza.anterior = nuevo;
        }
    }

    // Mostrar Playlist
    public void mostrarPlaylist() {
    if (cabeza == null) {
        JOptionPane.showMessageDialog(null, 
            "La playlist esta vacia.", 
            "Playlist", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    String lista = "";
    NodoCancion temporal = cabeza;
    int numero = 1;

    do {
        if (temporal == actual) {
            lista = lista + numero + ". " + temporal.nombre + " - " + temporal.artista + " <- ACTUAL\n";
        } else {
            lista = lista + numero + ". " + temporal.nombre + " - " + temporal.artista + "\n";
        }
        temporal = temporal.siguiente;
        numero++;
    } while (temporal != cabeza);

    JOptionPane.showMessageDialog(null, 
        lista, 
        "Playlist", 
        JOptionPane.INFORMATION_MESSAGE);
}
    // Avanzar Cancion
    public void siguiente() {
        if (actual == null) {
            JOptionPane.showMessageDialog(null, 
                "La playlist está vacía.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        actual = actual.siguiente;
        JOptionPane.showMessageDialog(null, 
            "Canción siguiente:\n\n" +
            actual.nombre + "\n" +
            actual.artista, 
            "Avanzando...", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    // Retroceder Cancion
    public void anterior() {
        if (actual == null) {
            JOptionPane.showMessageDialog(null, 
                "La playlist está vacía.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        actual = actual.anterior;
        JOptionPane.showMessageDialog(null, 
            "Canción anterior:\n\n" +
            actual.nombre + "\n" +
            actual.artista, 
            "Retrocediendo...", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
