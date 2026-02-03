/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase01;

import java.sql.Date;

/**
 *
 * @author daniel-2405
 */
public class EmpleadoTiempoCompleto extends Empleado implements Bonificacion {
    double porcentajeBono;
    int cantidadHorasExtra;
    private static final double PORCENTAJE_CARGAS = 0.1089;
    private static final int HORAS_BASE = 48;

    public EmpleadoTiempoCompleto() {}
    public EmpleadoTiempoCompleto(int cantidadHorasExtra, double porcentajeBono, String idPersona, String nombreCompleto, String genero, Date fechaNacimiento, int numEmpleado, String departamento, double salarioBase) {
        super(idPersona, nombreCompleto, genero, fechaNacimiento, numEmpleado, departamento, salarioBase);
        this.cantidadHorasExtra = cantidadHorasExtra;
        this.porcentajeBono = porcentajeBono;
    }
    
    public double getPorcentajeBono() {
        return porcentajeBono;
    }
    public void setPorcentajeBono(double porcentajeBono) {
        this.porcentajeBono = porcentajeBono;
    }
    public int getCantidadHorasExtra() {
        return cantidadHorasExtra;
    }
    public void setCantidadHorasExtra(int cantidadHorasExtra) {
        this.cantidadHorasExtra = cantidadHorasExtra;
    }
    public static double getPorcentajeCargas() {
        return PORCENTAJE_CARGAS;
    }
    public static int getHorasBase() {
        return HORAS_BASE;
    }

    @Override
    public String toString() {
        return "EmpleadoTiempoCompleto{" + "porcentajeBono=" + porcentajeBono + ", cantidadHorasExtra=" + cantidadHorasExtra + '}';
    }
    
    @Override
    public double calcularSalario() {
        double valorHora = 0;
        double salarioNeto = 0;
        double cargasSociales = 0;
        double bono = 0;
        double salarioExtra = 0;
        double salarioMes = 0;

        if (this.cantidadHorasExtra > 0) {
            valorHora = this.salarioBase / HORAS_BASE;
            salarioExtra = valorHora * this.cantidadHorasExtra;
        }
        salarioMes = super.getSalarioBase() + salarioExtra;
        bono = calcularBono(salarioMes);
        salarioMes += bono; 
        cargasSociales = salarioMes * PORCENTAJE_CARGAS;
        salarioNeto = salarioMes - cargasSociales;
        return salarioNeto;
    }

    @Override
    public double calcularBono(double salarioBase) {
        return salarioBase * this.porcentajeBono;
    }

}
