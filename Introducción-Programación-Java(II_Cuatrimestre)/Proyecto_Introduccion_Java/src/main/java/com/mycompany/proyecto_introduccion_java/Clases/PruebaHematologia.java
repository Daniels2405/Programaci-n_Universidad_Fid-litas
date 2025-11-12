/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Clases;
import java.time.LocalDateTime;

/**
 *
 * @author daniel
 */
public class PruebaHematologia {
    private OrdenDePrueba orden; //Orden de prueba asociada
    private ResultadoParametro[] resultados; //Array de parametros de referencia
    private String observaciones;
    private LocalDateTime fechaRealizacion;

    public PruebaHematologia(OrdenDePrueba orden, ResultadoParametro[] resultados, String observaciones, LocalDateTime fechaRealizacion) {
        this.orden = orden;
        this.resultados = resultados;
        this.observaciones = observaciones;
        this.fechaRealizacion = fechaRealizacion;
    }
    public PruebaHematologia(){}
    
    // Getters y Setters
    public OrdenDePrueba getOrden() {
        return orden;
    }
    public void setOrden(OrdenDePrueba orden) {
        this.orden = orden;
    }
    public ResultadoParametro[] getResultados() {
        return resultados;
    }
    public void setResultados(ResultadoParametro[] resultados) {
        this.resultados = resultados;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public LocalDateTime getFechaRealizacion() {
        return fechaRealizacion;
    }
    public void setFechaRealizacion(LocalDateTime fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
    
}
