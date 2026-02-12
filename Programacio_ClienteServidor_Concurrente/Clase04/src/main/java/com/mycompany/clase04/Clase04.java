/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase04;
import java.util.*;
/**
 *
 * @author daniel-2405
 */
public class Clase04 {

    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        // Agregar a lista
        nombres.add("Daniel");
        nombres.add("Edgar");
        nombres.add("Maria");
        nombres.add("Jose");
        // Imprimir lista
        System.out.println("Lista: " + nombres);
        
        //Borrar Dato
        nombres.remove("Maria");
        System.out.println("Lista: " + nombres);
        
        List<Integer> edades = new ArrayList<>();
        edades.add(20);
        edades.add(17);
        edades.add(70);
        
        List<String> clasificacion = new ArrayList<>();
        for (int edad : edades){
            if(edad < 18){
                clasificacion.add("niño");
            } else if(edad >= 65 ){
                clasificacion.add("Adulto Mayor");
            } else {
                clasificacion.add("Adulto");
            }
         }
        System.out.println("Clasificacion: " + clasificacion);
        
        //Lista personas
        List<Persona> personas = new ArrayList<>();
        
        //Saca el minimo de cada lista para crear objetos completos
        int tamanioMin = Math.min(nombres.size(), edades.size());
        for ( int i = 0; i < tamanioMin; i++ ){
            personas.add(new Persona(nombres.get(i), edades.get(i)));
        }
        System.out.println("******************* Personas *****************");
        System.out.println(" Personas: " + personas);
        
        //Ordenar por edad
        Collections.sort(personas);
        
        System.out.println(" Personas: " + personas);
        
        //Orden por nombre
        Collections.sort(personas, new ComparadorPorNombre());
        System.out.println(" Personas: " + personas);
        
    }
}
