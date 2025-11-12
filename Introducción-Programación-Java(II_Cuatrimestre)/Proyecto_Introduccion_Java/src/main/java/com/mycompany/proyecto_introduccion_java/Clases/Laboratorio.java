/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Clases;

/**
 *
 * @author daniel
 */
public class Laboratorio {
    //Atributos para el laboratorio
    private String nombre;
    private String cedulaJuridica;
    private String direccion;
    private String telefono;
    private String correo;

    //Constructor, se inicialra el laboratorio en el main con datos ya predefinidos
    public Laboratorio(String nombre, String cedulaJuridica, String direccion, String telefono, String correo){
        this.nombre = nombre;
        this.cedulaJuridica = cedulaJuridica;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Laboratorio(){}
    //Getters
    public String getNombre() {
        return nombre;
    }
    public String getCedulaJuridica() {
        return cedulaJuridica;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
}
