/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana02;

/**
 *
 * @author daniel-2405
 */
public class Practica1 {
    public void imprime(int n){
        if (n == 1){
            System.out.println(n);
        } else {
            System.out.println(n);
            imprime(n - 1);
        }
    }
}
