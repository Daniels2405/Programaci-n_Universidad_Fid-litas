/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciointegrador;
import com.mycompany.ejerciciointegrador.Participante;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
public class EjercicioIntegrador{

    public static void main(String[] args) {
        Participante[] participantes = new Participante[5];
        //Inicio del programa
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);
        while(opcion != 5){
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Agregar Participantes");
            System.out.println("2. Mostrar Participantes");
            System.out.println("3. Editar Participante");
            System.out.println("4. Final de la Competencia");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch(opcion){
                case 1:
                    agregarParticipantes(participantes);
                    break;
                case 2:
                    mostrarParticipantes(participantes);
                    break;
                case 3:
                    editarParticipante(participantes);
                    break;
                case 4:
                    finalCompetencia(participantes);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }
    public static void agregarParticipantes(Participante participantes[]){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < participantes.length; i++){
            System.out.println("Ingrese el nombre del participante #" + (i + 1) + ": ");
            String nombre = scanner.next();
            System.out.println("Ingrese la edad del participante #" + (i + 1) + ": ");
            int edad = scanner.nextInt();
            System.out.println("Seleccione el tipo de cocinero del participante #" + (i + 1) + ": ");
            System.out.println("1. Novato");
            System.out.println("2. Amateur");
            System.out.println("3. Profesional");
            System.out.println("4. Experto");
            int tipo = scanner.nextInt();
            TipoCocinero tipoCocinero;
            switch(tipo){
                case 1:
                tipoCocinero = TipoCocinero.Novato;
                break;
                case 2:
                tipoCocinero = TipoCocinero.Amateur;
                break;
                case 3:
                tipoCocinero = TipoCocinero.Profesional;
                break;
                case 4:
                tipoCocinero = TipoCocinero.Experto;
                break;
                default:
                tipoCocinero = TipoCocinero.Novato;
            }
        participantes[i] = new Participante(nombre, edad, tipoCocinero);
        participantes[i].generarPuntajes();
        }
    }

public static void mostrarParticipantes(Participante participantes[]){
        for (int i = 0; i < participantes.length; i++){
            if (participantes[i] == null) {
                System.out.println("Participante #" + (i + 1) + " - (vacío)");
            } else {
                participantes[i].mostrarParticipante(i + 1);
            }
        }
    }

    public static void editarParticipante(Participante participantes[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del participante a editar: ");
        String nombre = scanner.next().toLowerCase();
        boolean encontradoFlag = false;
        for (int i = 0; i < participantes.length; i++){
            if (participantes[i] == null) continue;
            if (participantes[i].getNombre().toLowerCase().equals(nombre)){
                encontradoFlag = true;
                int encontrado = i;
                System.out.println("¿Qué desea editar?");
                System.out.println("1. Nombre");
                System.out.println("2. Edad");
                System.out.println("3. Tipo de cocinero");
                int opcion = scanner.nextInt();
                switch(opcion){
                    case 1:
                        System.out.println("Ingrese el nuevo nombre: ");
                        String nuevoNombre = scanner.next();
                        participantes[encontrado].setNombre(nuevoNombre);
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva edad: ");
                        int nuevaEdad = scanner.nextInt();
                        participantes[encontrado].setEdad(nuevaEdad);
                        break;
                    case 3:
                        System.out.println("Seleccione el nuevo tipo de cocinero: ");
                        System.out.println("1. Novato");
                        System.out.println("2. Amateur");
                        System.out.println("3. Profesional");
                        System.out.println("4. Experto");
                        int tipo = scanner.nextInt();
                        TipoCocinero tipoCocinero;
                        switch(tipo){
                            case 1:
                                tipoCocinero = TipoCocinero.Novato;
                                break;
                            case 2:
                                tipoCocinero = TipoCocinero.Amateur;
                                break;
                            case 3:
                                tipoCocinero = TipoCocinero.Profesional;
                                break;
                            case 4:
                                tipoCocinero = TipoCocinero.Experto;
                                break;
                            default:
                                tipoCocinero = TipoCocinero.Novato;
                        }
                        participantes[encontrado].setTipoCocinero(tipoCocinero);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
                break; // salir del for una vez editado
            }
        }
        if (!encontradoFlag) {
            System.out.println("No se encontró un participante con ese nombre.");
        }
    }
    public static void finalCompetencia(Participante participantes[]){
        System.out.println("===== RESULTADOS FINALES =====");
        System.out.printf("%-20s %-15s %-10s %-15s\n", "Participante", "Puntos Totales", "Bono", "Puntos Finales");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < participantes.length; i++){
            if (participantes[i] == null) continue;
            int totalPuntos = participantes[i].calcularTotalPuntos();
            double bono = participantes[i].getTipoCocinero().bono();
            double puntosFinales = participantes[i].calcularPuntosFinales();
            System.out.printf("%-20s %-15d %-10.2f %-15.2f\n", participantes[i].getNombre(), totalPuntos, bono, puntosFinales);
        }
    }

}