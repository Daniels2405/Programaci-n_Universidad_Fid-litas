/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana09.Practica2;

/**
 *
 * @author daniel-2405
 */
public class NodoPagina {
    String url, titulo;
    NodoPagina siguiente, anterior;

    public NodoPagina(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
        this.siguiente = null;
        this.anterior = null;
    }
}
