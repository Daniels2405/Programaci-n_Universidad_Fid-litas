/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Clases;

/**
 *
 * @author daniel
 */
public class ResultadoParametro {
    private ParametroReferencia parametro; //Parametro al que pertenece el resultado
    private double valor; //Valor del resultado
    private String Alarma; //Indica si el resultado esta fuera de rango

    //Constructor
    public ResultadoParametro(ParametroReferencia parametro, double valor){
        this.parametro = parametro;
        this.valor = valor;
    }

    //Getters y Setters
    public ParametroReferencia getParametro() {
        return parametro;
    }

    public void setParametro(ParametroReferencia parametro) {
        this.parametro = parametro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getAlarma() {
        return Alarma;
    }

    public void setAlarma(String alarma) {
        if (valor < parametro.getRangoLow()) {
            Alarma = "El resultado esta por debajo del rango saludable.";
        } else if (valor > parametro.getRangoHigh()) {
            Alarma = "El resultado esta por encima del rango saludable.";
        } else {
            Alarma = null;
        }
    }
}
