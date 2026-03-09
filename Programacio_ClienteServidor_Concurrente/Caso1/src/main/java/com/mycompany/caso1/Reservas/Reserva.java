/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1.Reservas;

import java.sql.Date;
import java.io.Serializable;

import com.mycompany.caso1.Habitaciones.Habitacion;

/**
 *
 * @author daniel-2405
 */
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ID;
    private String nombreCompleto;
    private Habitacion habitacion;
    private Date fechaIngreso;
    private Date fechaSalida;
    private int cantidadHuespedes;
    private double costoTotal;
    public Reserva(int iD, String nombreCompleto, Habitacion habitacion, Date fechaIngreso, Date fechaSalida,
            int cantidadHuespedes, double costoTotal) {
        ID = iD;
        this.nombreCompleto = nombreCompleto;
        this.habitacion = habitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.cantidadHuespedes = cantidadHuespedes;
        this.costoTotal = costoTotal;
    }
    public Reserva() {}

    public double calcularCosto(){
        if(habitacion == null || fechaIngreso == null || fechaSalida == null) {
            return 0;
        }
        long milisegundos = fechaSalida.getTime() - fechaIngreso.getTime();
        long dias = milisegundos / (1000L * 60 * 60 * 24);
        if(dias <= 0) {
            dias = 1;
        }
        double tarifaDiaria = habitacion.calcularTarifa();
        double total = tarifaDiaria * dias;
        this.costoTotal = total;
        return total;
    }
    public boolean validarFechas(){
        if(fechaIngreso == null || fechaSalida == null) return false;
        return fechaSalida.after(fechaIngreso);
    }
    public boolean validarHuespedes(){
        if(habitacion == null) return false;
        if(cantidadHuespedes <= 0) return false;
        return true;
    }
    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public Date getFechaSalida() {
        return fechaSalida;
    }
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public int getCantidadHuespedes() {
        return cantidadHuespedes;
    }
    public void setCantidadHuespedes(int cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }
    public double getCostoTotal() {
        return costoTotal;
    }
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
