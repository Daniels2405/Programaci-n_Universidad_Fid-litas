/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase06;

/**
 *
 * @author daniel-2405
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public void Enqueue(int dato){
        Nodo nuevo = new Nodo(dato);
        if (fin != null) {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        if (frente == null) {
            frente = nuevo;
        }
    }

    public int Dequeue() throws Exception{
        if (frente == null) {
            throw new Exception("La cola esta Vacia");
        }
        int dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return dato;
    }

    public int front() throws Exception{
        if (frente == null) {
            throw new Exception("La cola esta Vacia");
        }
        return frente.dato;
    }

    public boolean isEmpty(){
        return frente == null;
    }
}
