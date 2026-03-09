/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.daniel_barrientos_cp1;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel-2405
 */
public class Daniel_Barrientos_CP1 {

    public static void main(String[] args) {
        Cola colaMeseros = new Cola();
        PilaArreglo pilaPlatos = new PilaArreglo(10);
        int cantidad_Meseros;
        int cantidadPlatos;
        boolean salir = false;
        while(salir == false){
            try{
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("==== Menu principal ========== \n 1. Agregar plato limpio \n 2. Registrar llegada el mesero \n 3. Atender siguiente mesero \n 4. Mostrar estado del sistema \n 0. Salir"));
                switch (opcion){
                    case 1:
                        if (pilaPlatos.isEmpty()){
                            cantidadPlatos = 0;
                        } else{
                            cantidadPlatos = pilaPlatos.contarRecursivo();
                        }
                        pilaPlatos.push(cantidadPlatos + 1);
                        cantidadPlatos = pilaPlatos.contarRecursivo();
                        JOptionPane.showMessageDialog(null, "Se agrego correctamente el plato. \n Hay #" + cantidadPlatos + " platos en la cola", "Estado del sistema", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        cantidadPlatos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos platos necesita el mesero"));
                        colaMeseros.encolar(cantidadPlatos);
                        cantidad_Meseros = colaMeseros.contarRec(colaMeseros);
                        JOptionPane.showMessageDialog(null, "Se agrego correctamente el mesero. \n Hay #" + cantidad_Meseros + " de meseros en la fila", "Estado del sistema", JOptionPane.INFORMATION_MESSAGE);
                        cantidad_Meseros = 0;
                        cantidadPlatos = 0;
                        break;
                    case 3:
                        try{
                            cantidadPlatos = colaMeseros.desencolar();
                            if (cantidadPlatos <= pilaPlatos.contarRecursivo()){
                                int i = 0;
                                while (i <= cantidadPlatos){
                                    pilaPlatos.pop();
                                    i++;
                                }
                                cantidad_Meseros = colaMeseros.contarRec(colaMeseros);
                                cantidadPlatos = pilaPlatos.contarRecursivo();
                                JOptionPane.showMessageDialog(null, "Se Atendio correctamente el mesero. \n Hay #" + cantidad_Meseros + " de meseros en la fila \n Hay #" + cantidadPlatos + " platos en la cola", "Estado del sistema", JOptionPane.INFORMATION_MESSAGE);
                                cantidad_Meseros = 0;
                                cantidadPlatos = 0;
                                break;
                            }
                            colaMeseros.encolar(cantidadPlatos);
                            int esperar = Integer.parseInt(JOptionPane.showInputDialog(null, "No hay suficientes platos para el mesero, requiere #" + cantidadPlatos + "\n Desea esperar [1] o desea retirar mesero [2]", "Error", JOptionPane.ERROR_MESSAGE));
                            if (esperar == 1){
                                JOptionPane.showMessageDialog(null, "Esperar");
                                break;
                            }
                            colaMeseros.desencolar();
                            JOptionPane.showMessageDialog(null, "Se salio el mesero de la fila");
                        }catch (Exception e){
                            JOptionPane.showMessageDialog(null, e.getMessage(), "No hay meseros en espera", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        cantidadPlatos = pilaPlatos.contarRecursivo();
                        cantidad_Meseros = colaMeseros.contarRec(colaMeseros);
                        JOptionPane.showMessageDialog(null, "Hay #" + cantidad_Meseros + " de meseros en la fila \n Hay #" + cantidadPlatos + " platos en la cola", "Estado del sistema", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Numero incorrecto", "Numero incorrecto", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Dato Invalido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
