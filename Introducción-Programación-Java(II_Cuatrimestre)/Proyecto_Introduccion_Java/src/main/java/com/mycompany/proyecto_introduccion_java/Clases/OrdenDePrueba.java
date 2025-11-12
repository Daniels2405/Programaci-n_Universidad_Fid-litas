/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Clases;
import java.time.LocalDateTime;
/**
 *
 * @author daniel
 */
public class OrdenDePrueba {
    //Atributos
    private int nOrden;
    private LocalDateTime fecha;

    //Constructor
    public OrdenDePrueba(int nOrden, LocalDateTime fecha){
        this.nOrden = nOrden;
        this.fecha = fecha;
    }
    public OrdenDePrueba(){}

    //Getters y Setters
    public int getnOrden() {
        return nOrden;
    }
    public void setnOrden(int nOrden) {
        this.nOrden = nOrden;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
