/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana03;

import java.util.List;

/**
 *
 * @author daniel-2405
 */
public class Semana03 {
    public static void main(String[] args) {
        int[] numeros = {1,2,1,1,1,10};
        int index = 0;
        int max = 0;
        int n = 5;
        int rs = SumaLista(numeros, index);
        System.out.println("La suma es: " + rs);
        System.out.println("El maximo es: " + MaxLista(numeros, index, max));
        System.out.println("La lista tiene: " + 
            ContarLista(numeros, index) + " elementos");
        System.out.println("El factorial de " + n + " es: " + factorial(n));
        n = 945940;
        invertirNumero(n);
    }

    public static int SumaLista(int[] lista, int index){
        if (index >= lista.length){
            return 0;
        } else {
            return lista[index] + SumaLista(lista, index +1);
        }
    }

    public static int MaxLista(int[] lista, int index, int max){
        if (index == lista.length){
            return max;
        } else {
            if (lista[index] > max){
                max = lista[index];
                return MaxLista(lista, index + 1, max);
            } else {
                return MaxLista(lista, index + 1, max);
            }
        }
    }

    public static int ContarLista(int[] lista, int index){
        if (index >= lista.length){
            return 0;
        } else {
            return 1 + ContarLista(lista, index + 1);
        }
    }

    public static int factorial (int n){
        if (n == 1){
            return n;
        } else {
            return n * factorial(n-1);
        }
    }

    public static int invertirNumero(int n){
        if (n == 0){
            return n;
        } else {
            int digito = n % 10;
            n = n / 10;
            System.out.println(digito);
            return digito + invertirNumero(n);
        }
    }
}
