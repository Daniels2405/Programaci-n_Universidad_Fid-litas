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

public class Persona {
    private String idPersona;
    private String nombreCompleto;
    private String genero;
    private Date fechaNacimiento;
    
    public Persona(String idPersona, String nombreCompleto, String genero, Date fechaNacimiento) {
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombreCompleto=" + nombreCompleto + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
}

