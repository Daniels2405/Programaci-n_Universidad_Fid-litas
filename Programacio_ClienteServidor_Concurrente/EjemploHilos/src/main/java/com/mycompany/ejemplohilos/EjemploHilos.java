/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplohilos;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author daniel-2405
 */
public class EjemploHilos extends JFrame{
    private JProgressBar barra1, barra2, barra3;
    private JLabel etiqueta1, etiqueta2, etiqueta3;
    private JButton btnIniciar;
    
    public EjemploHilos(){
        setTitle("Hilos con swing");
        setSize(500,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout (4,2,10,10));
        
        barra1 = new JProgressBar (0,100);
        barra2 = new JProgressBar (0,100);
        barra3 = new JProgressBar (0,100);
        
        etiqueta1 = new JLabel("Hilo 1 esperando... ");
        etiqueta2 = new JLabel("Hilo 2 esperando... ");
        etiqueta3 = new JLabel("Hilo 3 esperando... ");
        
        btnIniciar = new JButton("Iniciar Hilos");
        
        add(barra1); add(etiqueta1);
        add(barra2); add(etiqueta2);
        add(barra3); add(etiqueta3);
        add(btnIniciar); add(new JLabel(""));
        
        btnIniciar.addActionListener(e -> {
            // Deshabilitamos el botón para evitar que se inicien más hilos.
            btnIniciar.setEnabled(false);

            hiloProgreso hilo1 = new hiloProgreso(barra1, etiqueta1, "Hilo1", Color.BLUE);
            hiloProgreso hilo2 = new hiloProgreso(barra2, etiqueta2, "Hilo2", Color.RED);
            hiloProgreso hilo3 = new hiloProgreso(barra3, etiqueta3, "Hilo3", new Color(0, 128, 0)); // Verde oscuro

            // Es necesario llamar al método start() para que los hilos comiencen su ejecución.
            hilo1.start();
            hilo2.start();
            hilo3.start();

            // Creamos un hilo "monitor" que esperará a que los otros terminen para reactivar el botón.
            new Thread(() -> {
                try {
                    hilo1.join(); // Espera a que hilo1 termine.
                    hilo2.join(); // Espera a que hilo2 termine.
                    hilo3.join(); // Espera a que hilo3 termine.
                    // Cuando todos terminan, reactivamos el botón en el Event Dispatch Thread.
                    SwingUtilities.invokeLater(() -> btnIniciar.setEnabled(true));
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        });
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EjemploHilos::new);
    }
}
