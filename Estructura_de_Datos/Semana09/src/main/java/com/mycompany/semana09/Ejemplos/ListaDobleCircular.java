package com.mycompany.semana09.Ejemplos;

public class ListaDobleCircular {
    NodoDobleCircular cabeza;

    public void insertar(int valor) {
        NodoDobleCircular nuevo = new NodoDobleCircular(valor);

        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDobleCircular ultimo = cabeza.anterior;

            nuevo.siguiente = cabeza;
            nuevo.anterior = ultimo;

            cabeza.anterior = nuevo;
            ultimo.siguiente = nuevo;
        }
    }

    public void insertarOrdenado(int valor) {
        NodoDobleCircular nuevo = new NodoDobleCircular(valor);

        if (cabeza == null) {
            // Si la lista está vacía, el nuevo nodo es la cabeza y se enlaza a sí mismo
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;

        } else if (cabeza.dato >= valor) {
            // Insertar al inicio si el valor es menor o igual al primer nodo
            NodoDobleCircular ultimo = cabeza.anterior;

            nuevo.siguiente = cabeza;
            nuevo.anterior = ultimo;

            cabeza.anterior = nuevo;
            ultimo.siguiente = nuevo;

            cabeza = nuevo; // Actualizamos la cabeza

        } else {
            // Insertar en la posición correcta dentro de la lista
            NodoDobleCircular actual = cabeza;

            while (actual.siguiente != cabeza && actual.siguiente.dato < valor) {
                actual = actual.siguiente;
            }

            // Insertar después de 'actual'
            nuevo.siguiente = actual.siguiente;
            nuevo.anterior = actual;

            actual.siguiente.anterior = nuevo;
            actual.siguiente = nuevo;
        }
    }

    public void mostrarAdelante() {
        if (cabeza == null) return;

        NodoDobleCircular actual = cabeza;

        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("(circular)");
    }
}