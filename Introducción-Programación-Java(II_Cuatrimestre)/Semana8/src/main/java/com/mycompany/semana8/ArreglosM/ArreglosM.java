package com.mycompany.semana8.ArreglosM;
import java.util.Scanner;

public class ArreglosM {
    public static void main(String[] args) {
        int matriz[][];
        //Ejercicio de matriz
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dijite el numero de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Dijite el numero de columnas: ");
        int columnas = scanner.nextInt();
        matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            matriz[i] = new int[columnas];
            for (int j = 0; j < columnas; j++){
                matriz[i][j] = (i + 1) * (j + 1);
            }
        }
        //System.out.println(matriz[0][2]);
        //Suma de las 4 esquinas
        int sumaEsquinas= matriz[0][0] + matriz[0][columnas-1] + matriz[filas-1][0] + matriz[filas-1][columnas-1];
        System.out.println("La sumatoria de las 4 esquinas de la matriz es: " + sumaEsquinas);
        int numeroMayor = matriz[0][0];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                if (matriz[i][j] > numeroMayor){
                    numeroMayor = matriz[i][j];
                }
            }
        }
        System.out.println("El numero mayor de la matriz es: " + numeroMayor);
    }
}
