/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1.Comparadores;

import com.mycompany.caso1.Reservas.Reserva;
import java.util.Comparator;
import java.sql.Date;

/**
 *
 * @author daniel-2405
 */
public class ComparadorFechas implements Comparator<Reserva>{
    @Override
    public int compare(Reserva o1, Reserva o2){
        Date fecha1 = o1.getFechaIngreso();
        Date fecha2 = o2.getFechaIngreso();
        if(fecha1 == null || fecha2 == null) {
            return 0;
        }
        return fecha1.compareTo(fecha2);
    }
}

