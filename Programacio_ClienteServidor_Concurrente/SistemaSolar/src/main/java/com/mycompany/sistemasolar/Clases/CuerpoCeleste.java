/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasolar.Clases;
/**
 *
 * @author daniel-2405
 */
public abstract class CuerpoCeleste{
    private String nombre;
    private double diametro; //km
    private double radio; // km
    private double circunferencia; // distancia de la superficie
    private double masa; // kg
    private double volumen; //Tamaño del planeta
    private double densidad;
    private double distanciaSol; //km
    private double velocidadRotacion; // km/h
    private double velocidadTraslacion; // km/h
    private double gravedad; 
    private double duracionDia;
    private double duracionAnio;
    private int cantLunas;
    private boolean anillos;
    private TipoPlaneta tipo;

    protected static final double G = 6.674e-11;

    public CuerpoCeleste(String nombre, double diametro, double masa, double distanciaSol, double velocidadRotacion,
            double velocidadTraslacion, int cantLunas, boolean anillos, TipoPlaneta tipo) {
        this.nombre = nombre;
        this.diametro = diametro;
        this.masa = masa;
        this.distanciaSol = distanciaSol;
        this.velocidadRotacion = velocidadRotacion;
        this.velocidadTraslacion = velocidadTraslacion;
        this.cantLunas = cantLunas;
        this.anillos = anillos;
        this.tipo = tipo;
    }
    public CuerpoCeleste() {}

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getCircunferencia() {
        return circunferencia;
    }

    public void setCircunferencia(double circunferencia) {
        this.circunferencia = circunferencia;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getDensidad() {
        return densidad;
    }

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public void setDistanciaSol(double distanciaSol) {
        this.distanciaSol = distanciaSol;
    }

    public double getVelocidadRotacion() {
        return velocidadRotacion;
    }

    public void setVelocidadRotacion(double velocidadRotacion) {
        this.velocidadRotacion = velocidadRotacion;
    }

    public double getVelocidadTraslacion() {
        return velocidadTraslacion;
    }

    public void setVelocidadTraslacion(double velocidadTraslacion) {
        this.velocidadTraslacion = velocidadTraslacion;
    }

    public double getGravedad() {
        return gravedad;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    public double getDuracionDia() {
        return duracionDia;
    }

    public void setDuracionDia(double duracionDia) {
        this.duracionDia = duracionDia;
    }

    public double getDuracionAnio() {
        return duracionAnio;
    }

    public void setDuracionAnio(double duracionAnio) {
        this.duracionAnio = duracionAnio;
    }

    public int getCantLunas() {
        return cantLunas;
    }

    public void setCantLunas(int cantLunas) {
        this.cantLunas = cantLunas;
    }

    public boolean getAnillos() {
        return anillos;
    }

    public void setAnillos(boolean anillos) {
        this.anillos = anillos;
    }

    public static double getG() {
        return G;
    }
    public TipoPlaneta getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlaneta tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{" + "nombre=" + nombre + ", diametro=" + diametro + ", radio=" + radio + ", circunferencia=" + circunferencia + ", masa=" + masa + ", volumen=" + volumen + ", densidad=" + densidad + ", distanciaSol=" + distanciaSol + ", velocidadRotacion=" + velocidadRotacion + ", velocidadTraslacion=" + velocidadTraslacion + ", gravedad=" + gravedad + ", duracionDia=" + duracionDia + ", duracionAnio=" + duracionAnio + ", cantLunas=" + cantLunas + ", anillos=" + anillos + ", tipo=" + tipo + '}';
    }
}
