/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1.Habitaciones;

import java.io.Serializable;

/**
 *
 * @author daniel-2405
 */
public abstract class Habitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tipo;
    private double tarifaBase;
    public Habitacion(String tipo, double tarifaBase) {
        this.tipo = tipo;
        this.tarifaBase = tarifaBase;
    }
    public abstract double calcularTarifa();

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    
}
