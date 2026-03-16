/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana09.Ejemplos;

/**
 *
 * @author daniel-2405
 */
public class ListaCircular {
    Nodo cabeza;
    Nodo ultimo;
    
    public ListaCircular() {
        cabeza = null;
        ultimo = null;
    }
    
    public void insertar(int valor){
        Nodo nuevo = new Nodo(valor);
        if(cabeza == null){
            cabeza = nuevo;
            ultimo = nuevo;
            nuevo.siguiente = cabeza;
        }else{
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            ultimo = nuevo;
        }
    }

    public void insertatOrdenado(int valor){
        Nodo nuevo = new Nodo(valor);
        if(cabeza == null){
            cabeza = nuevo;
            ultimo = nuevo;
            nuevo.siguiente = cabeza;
        }else if(valor < cabeza.dato){
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            ultimo.siguiente = cabeza;
        }else {
            Nodo actual = cabeza;
            while(actual.siguiente != cabeza && actual.siguiente.dato < valor){
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
            if(actual == ultimo){
                ultimo = nuevo;
            }
        }

    }

    public void recorrer(){
        if (cabeza == null){
            System.out.println("La lista esta vacia");
            return;
        }
        Nodo actual = cabeza;
        do{
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(cabeza)");
    }
}
