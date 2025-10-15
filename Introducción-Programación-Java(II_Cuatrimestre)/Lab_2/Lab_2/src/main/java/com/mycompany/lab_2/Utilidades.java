/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;

/**
 *
 * @author daniel
 */
public class Utilidades {
    private int id;

    public int gererarID(){
        id = (int) (Math.random() * 1000) + 1;
        return id;
    }

    public int getId() {
        return id;
    }
}
