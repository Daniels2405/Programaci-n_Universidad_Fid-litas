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
public class Cliente extends Persona{
    private int idCliente;
    private String membresia;
    private int puntos;
    private double limiteCredito;
    private Direccion direccion;

    public Cliente(String idPersona, String nombreCompleto, String genero, Date fechaNacimiento, int idCliente,
            String membresia, int puntos, double limiteCredito, Direccion direccion) {
        super(idPersona, nombreCompleto, genero, fechaNacimiento);
        this.idCliente = idCliente;
        this.membresia = membresia;
        this.puntos = puntos;
        this.limiteCredito = limiteCredito;
        this.direccion = direccion;
    }
    public Cliente(){}

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() + ", idCliente=" + idCliente + 
        ", membresia=" + membresia + ", puntos=" + puntos + 
        ", limiteCredito=" + limiteCredito + ", direccion= " + direccion +'}';
    }
}
