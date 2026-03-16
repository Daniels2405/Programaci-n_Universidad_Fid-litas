/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplohilos;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author daniel-2405
 */
public class hiloProgreso extends Thread {
    protected JProgressBar barra;
    protected JLabel etiqueta;
    protected String hilo;
    protected Color color;

    public hiloProgreso(JProgressBar barra, JLabel etiqueta, String hilo, Color color) {
        this.barra = barra;
        this.etiqueta = etiqueta;
        this.hilo = hilo;
        this.color = color;
        this.barra.setForeground(color);
    }
    
    @Override
    public void run(){
        // El bucle debe llegar a 100 para que la barra se llene completamente.
        for(int i = 0; i <= 100; i++){
            final int progreso = i;
            // Las actualizaciones de la UI de Swing deben hacerse en el Event Dispatch Thread (EDT).
            SwingUtilities.invokeLater(() -> {
                barra.setValue(progreso);
                etiqueta.setText(hilo + " avanzando... " + progreso + "%");
            });
            
            try{
                // Usamos long para el argumento de sleep.
                Thread.sleep((long)(Math.random() * 100));
            }catch(InterruptedException e){
                SwingUtilities.invokeLater(() -> etiqueta.setText(hilo + " interrumpido"));
                // Es una buena práctica restaurar el estado de interrupción y terminar el hilo.
                Thread.currentThread().interrupt();
                return;
            }
        }
        SwingUtilities.invokeLater(() -> etiqueta.setText(hilo + " Terminado"));
    }
}
