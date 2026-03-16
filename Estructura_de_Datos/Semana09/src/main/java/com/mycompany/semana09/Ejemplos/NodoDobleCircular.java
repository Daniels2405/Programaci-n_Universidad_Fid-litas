package com.mycompany.semana09.Ejemplos;

public class NodoDobleCircular {
    int dato;
    NodoDobleCircular siguiente, anterior;

    public NodoDobleCircular(int dato) {
        this.dato = dato;
        this.siguiente = this;
        this.anterior = this;
    }
}
