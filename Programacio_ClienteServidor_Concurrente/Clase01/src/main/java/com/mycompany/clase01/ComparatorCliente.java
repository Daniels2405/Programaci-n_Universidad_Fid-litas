/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase01;

import java.util.Comparator;
/**
 *
 * @author daniel-2405
 */
public class ComparatorCliente {
    public static class ComparadorPorNombre implements Comparator<Cliente>{
        //Ordenamiento por nombre
        @Override
        public int compare(Cliente c1, Cliente c2){
            return c1.getNombreCompleto().compareTo(c2.getNombreCompleto());
        }
    }

    public static class ComparadorPorPuntos implements Comparator<Cliente>{
        //Ordenamiento por puntos (desendentes)
        @Override
        public int compare(Cliente c1, Cliente c2){
            return Integer.compare(c2.getPuntos(), c1.getPuntos());
        }
    }

    public static class ComparadorPorLimite implements Comparator<Cliente>{
        //Ordenamiento por nombre
        @Override
        public int compare(Cliente c1, Cliente c2){
            return Double.compare(c1.getLimiteCredito(), c2.getLimiteCredito());
        }
    }
}
