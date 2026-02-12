/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana05;

/**
 *
 * @author daniel-2405
 */
import java.util.Random;
public class Semana05 {

    public static void main(String[] args) {
        ejecutarComparacionPila(10);
    }
    
    private static long memoriaUsada(){
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
    public static void ejecutarComparacionPila(int N){
        Random random = new Random(); 
        int[] datos = new int[N];
        for (int i = 0; i < N; i++){
            datos[i] = random.nextInt();
        }
        
        System.gc();
        
        
        long memoriaAntesArreglo = memoriaUsada();
        
        long inicioArreglo = System.nanoTime();
        
        PilaArreglo pilaA = new PilaArreglo(N);
        
        for (int i = 0; i < N; i++){
            pilaA.push(datos[i]);
        }
        for (int i = 0; i < N; i++){
            pilaA.pop();
        }
        
        long finArreglo = System.nanoTime();
        long memoriaDespuesArreglo = memoriaUsada();
        
        long tiempoArreglo = finArreglo - inicioArreglo;
        long memoriaArreglo = memoriaDespuesArreglo - memoriaAntesArreglo;
        
        System.gc();
        long memoriaAntesDinamica = memoriaUsada();
        
        long inicioDinamica = System.nanoTime();
        
        PilaDinamica pilaD = new PilaDinamica();
        for (int i = 0; i < N; i++){
            pilaD.push(datos[i]);
        }
        for (int i = 0; i < N; i++){
            pilaD.pop();
        }
        
        long finDinamica = System.nanoTime();
        long memoriaDespuesDinamica = memoriaUsada();
        
        long tiempoDinamica = finDinamica - inicioDinamica;
        long memoriaDinamica = memoriaDespuesDinamica - memoriaAntesDinamica;
        
        System.out.println("---------Pila Arreglo--------");
        System.out.println("Tiempo: " + (tiempoArreglo / N) + "ms");
        System.out.println(memoriaArreglo);
        
        System.out.println("----------Pila Dinamica---------");
        System.out.println("Tiempo: " + (tiempoDinamica / N) + "ms");
        System.out.println(memoriaDinamica);
    }
    
    private static double bytesAMegas(long bytes) {
    return bytes / (1024.0 * 1024.0);
}

}
