/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Clases;

/**
 *
 * @author daniel
 */
public class ParametroReferencia {
    //Atributos para los parametros
    private String nombre;
    private String unidad;  //Unidad de medida
    private double rangoHigh;
    private double rangoLow;

    //Constructor
    public ParametroReferencia(String nombre, String unidad, double rangoHigh, double rangoLow){
        this.nombre = nombre;
        this.unidad = unidad;
        this.rangoHigh = rangoHigh;
        this.rangoLow = rangoLow;
    }
    public ParametroReferencia(){}
    
    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getUnidad() {
        return unidad;
    }
    public double getRangoHigh() {
        return rangoHigh;
    }
    public double getRangoLow() {
        return rangoLow;
    }
}
