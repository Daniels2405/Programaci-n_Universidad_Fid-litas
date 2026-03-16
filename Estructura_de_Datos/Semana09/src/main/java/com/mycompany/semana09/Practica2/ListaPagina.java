/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana09.Practica2;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel-2405
 */
public class ListaPagina {
    NodoPagina cabeza; // El inicio del historial
    NodoPagina actual; // La página que se está viendo actualmente

    public ListaPagina() {
        this.cabeza = null;
        this.actual = null;
    }

    public void visitarPagina(String url, String titulo) { // Agrega una pagina al historial
        NodoPagina nuevo = new NodoPagina(url, titulo);
        if (cabeza == null) {
            cabeza = nuevo;
            actual = nuevo;
        } else {
            // Inserta la nueva página después de la página actual,
            // eliminando el historial "hacia adelante" que pudiera existir.
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
            actual = nuevo; // La nueva página es ahora la actual.
        }
        JOptionPane.showMessageDialog(null, "Visitando página: " + actual.titulo);
    }

    public void mostrarHistorial() { // Orden de vista
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "El historial está vacío.");
            return;
        }
        StringBuilder historialStr = new StringBuilder("Historial completo:\n");
        NodoPagina temp = cabeza;
        while (temp != null) {
            historialStr.append("- ").append(temp.titulo).append(" (").append(temp.url).append(")\n");
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, historialStr.toString());
    }

    public void avanzar() { // Avanza a la siguiente pagina
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
            JOptionPane.showMessageDialog(null, "Página actual: " + actual.titulo);
        } else {
            JOptionPane.showMessageDialog(null, "No hay páginas siguientes a las que avanzar.");
        }
    }

    public void retroceder() { // Retrocede a la pagina anterior en el historial
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
            JOptionPane.showMessageDialog(null, "Página actual: " + actual.titulo);
        } else {
            JOptionPane.showMessageDialog(null, "No hay páginas anteriores en el historial.");
        }
    }
}
