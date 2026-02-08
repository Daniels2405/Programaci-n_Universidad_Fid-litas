/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_programada_1;

/**
 *
 * @author daniel-2405
 */
public class Dato {
    private int valor;
    private Dato abajo;

    public Dato(int valor) {
        this.valor = valor;
        this.abajo = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Dato getAbajo() {
        return abajo;
    }

    public void setAbajo(Dato abajo) {
        this.abajo = abajo;
    }
}
