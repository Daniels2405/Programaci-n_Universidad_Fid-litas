/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica_semana_12;

/**
 *
 * @author daniel-2405
 */
public class Robot {
    private int id;
    private String modelo;
    private int bateria;
    private TipoFuncion funcion;
    
    public Robot(int id, String modelo, int bateria, TipoFuncion funcion){
        this.id = id;
        this.modelo = modelo;
        this.bateria = bateria;
        this.funcion = funcion;
    }
    
    //Metodo para mostrar todos los atributos del robod
    public String mostrarRobot() {
        return "Robot ID: " + id +
               " | Modelo: " + modelo +
               " | Batería: " + bateria + "%" +
               " | Función: " + funcion;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getBateria() {
        return bateria;
    }
    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
    public TipoFuncion getFuncion() {
        return funcion;
    }
    public void setFuncion(TipoFuncion funcion) {
        this.funcion = funcion;
    }
    
    
}
