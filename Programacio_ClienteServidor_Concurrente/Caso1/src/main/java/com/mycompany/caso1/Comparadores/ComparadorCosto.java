/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1.Comparadores;
import com.mycompany.caso1.Reservas.*;
import java.util.Comparator;

/**
 *
 * @author daniel-2405
 */
public class ComparadorCosto implements Comparator<Reserva>{

    @Override
    public int compare(Reserva o1, Reserva o2) {
        return Double.compare(o1.getCostoTotal(), o2.getCostoTotal());
    }
    
}
