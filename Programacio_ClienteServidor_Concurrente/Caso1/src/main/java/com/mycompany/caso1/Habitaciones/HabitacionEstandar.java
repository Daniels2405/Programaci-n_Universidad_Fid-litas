/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1.Habitaciones;

/**
 *
 * @author daniel-2405
 */
public class HabitacionEstandar extends Habitacion {
    public HabitacionEstandar(String tipo, double tarifaBase) {
        super(tipo, tarifaBase);
    }
    @Override
    public double calcularTarifa() {
        return getTarifaBase();
    }
}
