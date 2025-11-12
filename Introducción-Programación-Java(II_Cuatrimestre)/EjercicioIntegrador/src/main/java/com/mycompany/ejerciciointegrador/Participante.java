/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciointegrador;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
public class Participante {
    private String nombre;
    private int edad;
    private TipoCocinero tipoCocinero;
    private int[][] puntajes = new int[3][3]; // Matriz para almacenar puntajes

    public Participante(String nombre, int edad, TipoCocinero tipoCocinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoCocinero = tipoCocinero;
    }
    public Participante(){}

    //Metodos
    public void generarPuntajes(){
        for (int i = 0; i < puntajes.length; i++){
            for (int j = 0; j < puntajes[i].length; j++){
                puntajes[i][j] = (int)(Math.random() * 10) + 1; // Genera un puntaje aleatorio entre 1 y 10
            }
        }
    }

    public int calcularTotalPuntos(){
        int total = 0;
        for (int i = 0; i < puntajes.length; i++){
            for (int j = 0; j < puntajes[i].length; j++){
                total += puntajes[i][j];
            }
        }
        return total;
    }

    public double calcularPuntosFinales(){
        return calcularTotalPuntos() * tipoCocinero.bono();
    }

    public void mostrarPuntajes(){
        System.out.println("Puntajes de " + nombre + ":");
        for (int i = 0; i < puntajes.length; i++){
            System.out.print("Ronda " + (i + 1) + ": ");
            for (int j = 0; j < puntajes[i].length; j++){
                System.out.print(puntajes[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mostrarParticipante(int numero) {
        System.out.println("*************** Participante #" + numero + " ***************");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Tipo de cocinero: " + tipoCocinero);
        System.out.println("Puntos:");
        mostrarPuntajes();
        System.out.println();
    }
    
        //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public TipoCocinero getTipoCocinero() {
        return tipoCocinero;
    }
    public void setTipoCocinero(TipoCocinero tipoCocinero) {
        this.tipoCocinero = tipoCocinero;
    }
    public int[][] getPuntajes() {
        return puntajes;
    }
    public void setPuntajes(int[][] puntajes) {
        this.puntajes = puntajes;
    }

    



}
