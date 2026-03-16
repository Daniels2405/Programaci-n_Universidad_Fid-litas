package com.mycompany.semana09.Ejemplos;

public class ListaDoble {
    NodoDoble cabeza;

    public void insertar(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoDoble actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
    }
    //Crea el metodo
    public void insertarOrdenado(int valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        if (cabeza == null) {
            cabeza = nuevo;
        } else if (valor < cabeza.dato) {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        } else {
            NodoDoble actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.dato < valor) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            nuevo.anterior = actual;
            actual.siguiente = nuevo;
            if (nuevo.siguiente != null) {
                nuevo.siguiente.anterior = nuevo;
            }
        }
        
    }
    public void mostrarAdelante(){
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void mostrarAtras(){
        NodoDoble actual = cabeza;
        if (actual == null) return;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }


}
