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
public abstract class Empleado extends Persona{
    int numEmpleado;
    String departamento;
    double salarioBase;

    public Empleado(String idPersona, String nombreCompleto, String genero, Date fechaNacimiento, int numEmpleado,
            String departamento, double salarioBase) {
        super(idPersona, nombreCompleto, genero, fechaNacimiento);
        this.numEmpleado = numEmpleado;
        this.departamento = departamento;
        this.salarioBase = salarioBase;
    }
    public Empleado() {}
    
    public int getNumEmpleado() {
        return numEmpleado;
    }
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numEmpleado=" + numEmpleado + ", departamento=" + departamento + ", salarioBase=" + salarioBase + '}';
    }

    
    public abstract double calcularSalario();

    
}
