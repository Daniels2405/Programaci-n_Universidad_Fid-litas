/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso_practico_2;

/**
 *
 * @author daniel-2405
 */
public class Empleado {
    private int idEmpleado; // Identificador de la empresa
    private String nombre;
    private String[] apellidos = new String[2];
    private String cedula; // Identificador personal
    private int edad;
    private String puesto;
    private String departamentoTrabajo;
    private double salario;
    private String telefono;
    private String email;
    private String direccion;
    private String nacionalidad;

    // Constructor
    public Empleado(int idEmpleado, String nombre, String[] apellidos, String cedula, int edad,
            String puesto, String departamentoTrabajo, double salario, String telefono, String email, String direccion,
            String nacionalidad) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.edad = edad;
        this.puesto = puesto;
        this.departamentoTrabajo = departamentoTrabajo;
        this.salario = salario;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
    }
    public Empleado(){}

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellidos[0];
    }
    public String getApellido2() {
        return apellidos[1];
    }
    public void setApellidos(String[] apellidos) {
        this.apellidos = apellidos;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getDepartamentoTrabajo() {
        return departamentoTrabajo;
    }
    public void setDepartamentoTrabajo(String departamentoTrabajo) {
        this.departamentoTrabajo = departamentoTrabajo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
