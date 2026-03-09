/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1.Reservas;

import com.mycompany.caso1.Comparadores.ComparadorCosto;
import com.mycompany.caso1.Comparadores.ComparadorFechas;
import com.mycompany.caso1.Comparadores.ComparadorHuespedes;
import java.util.*;
import java.io.*;
/**
 *
 * @author daniel-2405
 */
public class AdministradorReservas {
    public ArrayList<Reserva> listaReservas = new ArrayList<>();
    public AdministradorReservas() {}

    /**
     * Guarda la lista de reservas en un archivo binario.
     */
    public void guardarReservas(String nombreArchivo) throws IOException{
        try (ObjectOutputStream reserva = new ObjectOutputStream(new FileOutputStream(nombreArchivo))){
            reserva.writeObject(listaReservas);
        }
    }

    /**
     * Carga las reservas desde un archivo binario. Si no existe, deja la lista vacía.
     */
    @SuppressWarnings("unchecked")
    public void cargarReservas(String nombreArchivo) throws IOException, ClassNotFoundException{
        File file = new File(nombreArchivo);
        if(!file.exists()) return; // nada que cargar
        try (ObjectInputStream carga = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            Object ob = carga.readObject();
            if(ob instanceof ArrayList){
                listaReservas = (ArrayList<Reserva>) ob;
            }
        }
    }

    public void agregarReserva(Reserva reserva){
        if(reserva!=null) {
            listaReservas.add(reserva);
        }
    }
    
    public boolean eliminarReserva(int id){
        for (int i = 0; i < listaReservas.size(); i++) {
            if (listaReservas.get(i).getID() == id) {
                listaReservas.remove(i);
                return true;
            }
        }
        return false;
    }

    public Reserva buscarPorId(int id){
        for(Reserva reserva : listaReservas){
            if(reserva.getID() == id) return reserva;
        }
        return null;
    }

    public List<Reserva> getReservas(){
        return listaReservas;
    }

    public void ordenarPorCosto(){
        Collections.sort(listaReservas, new ComparadorCosto());
    }

    public void ordenarPorFechas(){
        Collections.sort(listaReservas, new ComparadorFechas());
    }

    public void ordenarPorHuespedes(){
        Collections.sort(listaReservas, new ComparadorHuespedes());
    }

    public int generarID(){
        int max = 0;
        for(Reserva reserva : listaReservas){
            if(reserva.getID() > max) {
                max = reserva.getID();
            }
        }
        return max + 1;
    }
}
