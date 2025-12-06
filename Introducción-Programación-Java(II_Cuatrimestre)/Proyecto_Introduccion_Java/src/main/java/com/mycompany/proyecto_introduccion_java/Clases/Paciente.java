/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Clases;

/**
 *
 * @author daniel
 */
public class Paciente {
    //Atributos del paciente
    private int cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private String fechaNacimento;
    private char sexo;
    private String Telefono;
    private String correoElectronico;
    private String direccion;
    private OrdenDePrueba orden;
    private PruebaHematologia[] pruebasHematologia; //Array de pruebas de hematologia asociadas al paciente

    //Constructor
    public Paciente(int cedula, String nombre, String apellido1, String apellido2, 
                    int edad, char sexo, String Telefono, 
                    String correoElectronico, String direccion) { //No se colocan las pruebas y orden en el constructor
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.sexo = sexo;
        this.Telefono = Telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }
    public Paciente(){}
    
    //Getters y Setters
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getFechaNacimento() {
        return fechaNacimento;
    }
    public void setFechaNacimento(String fechaNacimento) {
        this.fechaNacimento = fechaNacimento;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public OrdenDePrueba getOrden() {
        return orden;
    }
    public void setOrden(OrdenDePrueba orden) {
        this.orden = orden;
    }
    public PruebaHematologia[] getPruebasHematologia() {
        return pruebasHematologia;
    }
    public void setPruebasHematologia(PruebaHematologia[] pruebasHematologia) {
        this.pruebasHematologia = pruebasHematologia;
    }
}