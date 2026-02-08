/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica01;

/**
 *
 * @author daniel-2405
 */
public class Circulo extends Forma{
    private double radio;
    private double area;
    private double perimetro;

    public Circulo(double radio, double area, double perimetro) {
        this.radio = radio;
        this.area = area;
        this.perimetro = perimetro;
    }
    
    public Circulo() {}

    @Override
    public double CalcularArea() {
        double area = 3.14159 * radio * radio;
        this.area = area;
        return area;
    }

    @Override
    public double CalcularPerimetro() {
        double perimetro = 2 * 3.14159 * radio;
        this.perimetro = perimetro;
        return perimetro;
    }

    public double getRadio() {
        return radio;
    }
    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    
}
