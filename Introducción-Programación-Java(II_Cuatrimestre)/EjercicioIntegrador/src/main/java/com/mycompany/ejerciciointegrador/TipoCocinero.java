/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciointegrador;

/**
 *
 * @author daniel
 */
public enum TipoCocinero {
    Novato,
    Amateur,
    Profesional,
    Experto;

    public double bono(){
        switch(this){
            case Novato:
                return 1.0;
            case Amateur:
                return 1.1;
            case Profesional:
                return 1.25;
            case Experto:
                return 1.4;
            default:
                return 1.0;
        }
    }
}
