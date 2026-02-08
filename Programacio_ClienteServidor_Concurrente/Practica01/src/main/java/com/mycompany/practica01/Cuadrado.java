/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica01;

/**
 *
 * @author daniel-2405
 */
public class Cuadrado extends Forma{
    private double lado;
    private double area;
    private double perimetro;

    public Cuadrado(double lado, double area, double perimetro) {
        this.lado = lado;
        this.area = area;
        this.perimetro = perimetro;
    }

    public Cuadrado() {}

    @Override
    public double CalcularArea() {
        double area = lado * lado;
        this.area = area;
        return area;
    }
    @Override
    public double CalcularPerimetro() {
        double perimetro = 4 * lado;
        this.perimetro = perimetro;
        return perimetro;
    }

    public double getLado() {
        return lado;
    }
    public void setLado(double lado) {
        this.lado = lado;
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
