/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1.Habitaciones;

/**
 *
 * @author daniel-2405
 */
public class HabitacionEjecutiva extends Habitacion {
    private final double EXTRATARIFA = 0.2;
    public HabitacionEjecutiva(String tipo, double tarifaBase) {
        super(tipo, tarifaBase);
    }
    @Override
    public double calcularTarifa() {
        double tarifa = getTarifaBase() * EXTRATARIFA;
        return tarifa;
    }
}
