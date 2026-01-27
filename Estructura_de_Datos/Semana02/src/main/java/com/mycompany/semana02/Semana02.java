/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana02;
import java.util.Scanner;

/**
 *
 * @author daniel-2405
 */
public class Semana02 {

    public static void main(String[] args) {
        Practica1 p1 = new Practica1();
        SumaNumeros s1 = new SumaNumeros();
        Scanner sc = new Scanner(System.in);
        /** 
        
        
        System.out.print("Dijite el numero que desea iniciar la cuenta regresiva: ");
        int n = sc.nextInt();
        p1.imprime(n);
        
        System.out.println("-----------------");
        System.out.print("Dijite el numero hasta donde desea sumar: ");
        int n2 = sc.nextInt();
        System.out.println(s1.suma(n2));
        */
        Fibonacci fibonacci1 = new Fibonacci();
        System.out.print("Digite el numero de la posicion de la serie Fibonacci que desea conocer: ");
        int n = sc.nextInt(); 
        if (0 <= n && n <= 30){
            System.out.println("El numero en la posicion " + n + " de la serie Fibonacci es: " + fibonacci1.fibonacci(n));
        } else {
            System.out.println("Por favor ingrese un numero entre 0 y 30.");
        }

    }
}
