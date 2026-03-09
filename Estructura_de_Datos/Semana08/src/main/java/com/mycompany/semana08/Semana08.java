/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana08;

import com.mycompany.semana08.Ejercicio1.ListaContacto;

/**
 *
 * @author daniel-2405
 */
public class Semana08 {

    public static void main(String[] args) {
        // prueba1();
        Ejercicio1();
    }
    
    public static void prueba1(){
        ListaEnlazada lista = new ListaEnlazada();
        
        lista.insertarInicio(10);
        lista.insertarInicio(20);
        lista.insertarInicio(30);
        
        System.out.println("Lista despues de incerciones:");
        lista.recorrer();
        
        lista.eliminarNodo(20);
        System.out.println("Lista despues de eliminar 20:");
        lista.recorrer();
        
        System.out.println("Buscar 10 en la lista: " + lista.buscar(10));
        System.out.println("Buscar 40 en la lista: " + lista.buscar(40));
    }

    public static void Ejercicio1(){
        ListaContacto listaContacto = new ListaContacto();


        listaContacto.insertarInicio("Daniel", "8714-9157");
        listaContacto.insertarInicio("Fabiola", "8611-2006");

        System.out.println("Lista despues de incerciones:");
        listaContacto.recorrer();


        listaContacto.eliminarNodo("Daniel");
        System.out.println("Lista despues de eliminar Daniel:");
        listaContacto.recorrer();

        System.out.println("Buscar Daniel en la lista: " + listaContacto.buscar("Daniel"));
        System.out.println("Buscar Fabiola en la lista: " + listaContacto.buscar("Fabiola"));
    }
}
