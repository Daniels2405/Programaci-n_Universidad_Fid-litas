/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase04;
import java.util.Comparator;
/**
 *
 * @author daniel-2405
 */
public class ComparadorPorNombre implements Comparator<Persona>{
    
    @Override
    public int compare(Persona p1, Persona p2){
        return p1.getNombre().compareTo(p2.getNombre());
    }
    
}
