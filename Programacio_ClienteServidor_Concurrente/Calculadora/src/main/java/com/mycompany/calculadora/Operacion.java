/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

import java.io.Serializable;

/**
 *
 * @author daniel-2405
 */
public class Operacion implements Serializable {
    private static final long serialVersionUID = 1L;
    private String expresion;
    private Double resultado;
    
    public Operacion(String expresion, Double resultado) {
        this.expresion = expresion;
        this.resultado = resultado;
    }

    public String getExpresion() {
        return expresion;
    }
    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
    public Double getResultado() {
        return resultado;
    }
    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}
