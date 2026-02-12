/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasolar.Clases;

/**
 *
 * @author daniel-2405
 */
public class PlanetaGaseoso extends CuerpoCeleste implements Planeta{
    private CompocisionPlanetaGaseoso composicion;
    private boolean tormentaPermanente;

    public PlanetaGaseoso(String nombre, double diametro, double masa, double distanciaSol, double velocidadRotacion,
            double velocidadTraslacion, int cantLunas, boolean anillos, TipoPlaneta tipo,
            CompocisionPlanetaGaseoso composicion, boolean tormentaPermanente) {
        super(nombre, diametro, masa, distanciaSol, velocidadRotacion, velocidadTraslacion, cantLunas, anillos, tipo);
        this.tormentaPermanente = tormentaPermanente;
        this.composicion = composicion;
    }
    public PlanetaGaseoso() {}

    @Override
    public void calcularAtributos() {
        setRadio(calcularRadio());
        setCircunferencia(calcularCircunferencia());
        setDensidad(calcularDensidad());
        setDuracionAnio(calcularDuracionAnio());
        setDuracionDia(calcularDuracionDia());
        setGravedad(calcularGravedad());
        setVolumen(calcularVolumen());
    }

    @Override
    public double calcularCircunferencia() {
        return Math.PI * getDiametro();
    }
    @Override
    public double calcularRadio() {
        return getDiametro() / 2;
        
    }
    @Override
    public double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(calcularRadio(), 3);
    }
    @Override
    public double calcularDensidad() {
        return getMasa() / calcularVolumen();
    }
    @Override
    public double calcularDuracionAnio() {
        return getDistanciaSol() / getVelocidadTraslacion();
    }
    @Override
    public double calcularDuracionDia() {
        return calcularCircunferencia() / getVelocidadRotacion();
    }
    @Override
    public double calcularGravedad() {
        return (G * getMasa()) / Math.pow(calcularRadio(), 2);
    }
    public CompocisionPlanetaGaseoso getComposicion() {
        return composicion;
    }
    public void setComposicion(CompocisionPlanetaGaseoso composicion) {
        this.composicion = composicion;
    }
    public boolean isTormentaPermanente() {
        return tormentaPermanente;
    }
    public void setTormentaPermanente(boolean tormentaPermanente) {
        this.tormentaPermanente = tormentaPermanente;
    }
}
