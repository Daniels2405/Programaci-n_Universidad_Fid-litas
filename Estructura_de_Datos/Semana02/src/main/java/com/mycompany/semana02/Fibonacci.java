/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana02;

/**
 *
 * @author daniel-2405
 */
public class Fibonacci {
    public int fibonacci (int n){
        if (n == 0){
            return 0;
        }else if (n == 1){
                return 1;
        } else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
