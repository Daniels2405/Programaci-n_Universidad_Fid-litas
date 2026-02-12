/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasolar.Clases;

/**
 *
 * @author daniel-2405
 */
public class PlanetaRocoso extends CuerpoCeleste implements Planeta{
    private TipoSuperficie tipoSuperficie;
    private boolean placasTectonicas;

    public PlanetaRocoso(String nombre, double diametro, double masa, double distanciaSol, double velocidadRotacion,
            double velocidadTraslacion, int cantLunas, boolean anillos, TipoPlaneta tipo,
            TipoSuperficie tipoSuperficie, boolean placasTectonicas) {
        super(nombre, diametro, masa, distanciaSol, velocidadRotacion, velocidadTraslacion, cantLunas, anillos, tipo);
        this.tipoSuperficie = tipoSuperficie;
        this.placasTectonicas = placasTectonicas;
    }
    public PlanetaRocoso() {}

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
    public TipoSuperficie getTipoSuperficie() {
        return tipoSuperficie;
    }
    public void setTipoSuperficie(TipoSuperficie tipoSuperficie) {
        this.tipoSuperficie = tipoSuperficie;
    }
    public boolean isPlacasTectonicas() {
        return placasTectonicas;
    }
    public void setPlacasTectonicas(boolean placasTectonicas) {
        this.placasTectonicas = placasTectonicas;
    }
}
