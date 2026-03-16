/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.playlist;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel-2405
 */
public class Playlist {

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        ListaDobleCircular lista = new ListaDobleCircular();
        String cancionesPrueba = JOptionPane.showInputDialog(null, "Desea colocar canciones de prueba al playlist? y/n", "Playlist", JOptionPane.PLAIN_MESSAGE);
        if (cancionesPrueba.equals("y")) {
            try {
                // Agregar canciones de prueba a la lista
                lista.agregarCancion("Blinding Lights", "The Weeknd");
                lista.agregarCancion("Save Your Tears", "The Weeknd");
                lista.agregarCancion("Starboy", "The Weeknd");
                lista.agregarCancion("The Hills", "The Weeknd");
                lista.agregarCancion("Die For You", "The Weeknd");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear la lista de prueba: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "==== Menú ====\n"
                    + "1. Agregar canción\n"
                    + "2. Mostrar Playlist\n"
                    + "3. Siguiente Cancion\n"
                    + "4. Anterior Cancion\n"
                    + "5. Salir\n"
                    + "Ingrese una opción: ", "Menú", JOptionPane.PLAIN_MESSAGE));
                switch (opcion) {
                    case 1:
                        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la canción: ");
                        String artista = JOptionPane.showInputDialog(null, "Ingrese el nombre del artista: ");
                        lista.agregarCancion(nombre, artista);
                        break;
                    case 2:
                        lista.mostrarPlaylist();
                        break;
                    case 3:
                        lista.siguiente();
                        break;
                    case 4:
                        lista.anterior();
                        break;
                    case 5:
                        salir = true;
                        JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!salir);
    }
}
