package com.mycompany.practicaevaluada3;
import java.util.Scanner;
public class Matriz {
    private int columnas;
    private int filas;
    private int[][] matriz;
    private int suma;
    private int valorMin;
    private int contadorMayor50;

    protected Matriz(int columnas, int filas){
        this.columnas = columnas;
        this.filas = filas;
        this.matriz = new int[filas][columnas];
        this.suma = suma;
    }

    //Metodos
    public void llenarMatriz(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                //Llenar matriz
                System.out.print("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        this.matriz = matriz;
        OperacionesMatriz();
    }
    public void MostrarMatriz(){
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    //Metodo para realizar las operaciones de la matriz
    public void OperacionesMatriz(){
        SumarMatriz();
        ValorMin();
        Mayor50();
    }
    public void SumarMatriz(){
        //Sumar la matriz
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                suma += matriz[i][j];
            }
        }
    }
    public void ValorMin(){
        valorMin = matriz[0][0];
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                if (matriz[i][j] < valorMin){
                    valorMin = matriz[i][j];
                }
            }
        }
    }
    //Metodo para contar los valores mayores a 50
    public void Mayor50(){
        contadorMayor50 = 0;
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                if (matriz[i][j] > 50){
                    contadorMayor50++;
                }
            }
        }
    }



    //Getters and Setters
    public int getColumnas() {
        return columnas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    public int getFilas() {
        return filas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }
    public int[][] getMatriz() {
        return matriz;
    }
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    public int getSuma() {
        return suma;
    }
    public void setSuma(int suma) {
        this.suma = suma;
    }
    public int getValorMin() {
        return valorMin;
    }
    public void setValorMin(int valorMin) {
        this.valorMin = valorMin;
    }
    public int getContadorMayor50() {
        return contadorMayor50;
    }
    public void setContadorMayor50(int contadorMayor50) {
        this.contadorMayor50 = contadorMayor50;
    }
}
