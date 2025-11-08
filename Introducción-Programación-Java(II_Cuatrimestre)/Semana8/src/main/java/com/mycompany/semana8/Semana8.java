/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana8;
import java.util.Scanner;

import com.mycompany.semana8.ArreglosU.ArreglosU;

/**
 *
 * @author daniel
 */
public class Semana8 {

    public static void main(String[] args) {
        var nombres = new ArreglosU();
        nombres.llenar(new Scanner(System.in));
        nombres.mostrar();
    }
}
