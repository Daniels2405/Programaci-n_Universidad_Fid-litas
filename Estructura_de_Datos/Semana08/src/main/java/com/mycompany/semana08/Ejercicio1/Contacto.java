/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana08.Ejercicio1;

/**
 *
 * @author daniel-2405
 */
public class Contacto {
    String nombre;
    String numero;
    public Contacto(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contacto{");
        sb.append("nombre=").append(nombre);
        sb.append(", numero=").append(numero);
        sb.append('}');
        return sb.toString();
    }
    
    
}
