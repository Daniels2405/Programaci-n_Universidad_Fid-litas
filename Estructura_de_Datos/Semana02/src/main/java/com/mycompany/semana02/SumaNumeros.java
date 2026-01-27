/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana02;

/**
 *
 * @author daniel-2405
 */
public class SumaNumeros {
    public int suma(int n){
        if (n > 1){
            return n + suma(n - 1);
        }
        return n;
    }
}
