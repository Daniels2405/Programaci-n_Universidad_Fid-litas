/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Clases;

/**
 *
 * @author daniel-2405
 */

 //Esta clase de medico se utilizara para crear los usuarios que podran ingresar al sistema de laboratorios
public class Medico {
    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String userName;
    private String contrasena;
    private String telefono;
    private String correoElectronico;

    // Se crea un constructor para el medico
    public Medico(String cedula, String nombre, String apellido1, String apellido2, String userName, String contrasena, String telefono, String correoElectronico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.userName = userName;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    //Getters y Setters
    public Medico() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

}
