/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana8.ArreglosU;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class ArreglosU {
    String[] nombres = new String [6]; 
    
    public void llenar(Scanner scanner){
        for(int i = 0; i < nombres.length; i++){
            System.out.print("Ingrese un nombre: ");
            nombres[i] = scanner.nextLine();
            System.out.print("¿Desea ingresar más nombres? (s/n): ");
            String respuesta = new Scanner(System.in).next();
            respuesta = respuesta.toLowerCase();
            if (respuesta.equals("n")){
                break;
            }
        }
    }
    
    public void mostrar(){
        for (int i = 0; i < nombres.length; i++){
            if (nombres[i] != null){
            System.out.println(nombres[i]);   
            }
        }
    }
}
