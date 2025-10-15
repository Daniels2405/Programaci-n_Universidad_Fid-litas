/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Receta {
    //Atributos de la receta
    private Paciente paciente; //Se coloca cada variable con la clase correspondiente
    private Medico medico;
    private Medicamentos medicamento;
    // final private String id;

    //Set para Receta
    public void setReceta(){
        setPaciencte();
        setMedicamento();
        setMedico();
    }

    //Set para las variables
    public void setPaciencte(){
        System.out.println("--------Información del Paciente--------");
        Scanner pacienteScanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del paciente: ");
        var namePaciente = pacienteScanner.next();
        //Scaner para el age
        Scanner pacienteageScanner = new Scanner(System.in);
        System.out.print("Ingrese la edad del paciente: ");
        var agePaciente = pacienteageScanner.nextInt();
        //Scaner para el id
        Scanner pacienteidScanner = new Scanner(System.in);
        System.out.print("Ingrese el id: ");
        String idPaciente = pacienteidScanner.next();
        //Creacion de la variable paciente
        paciente = new Paciente(namePaciente, agePaciente, idPaciente);
        paciente.setHistoriaClinica();
    }
    public void setMedico(){
        //Nombre del medico
        System.out.println("--------Informacion del Medico--------");
        Scanner mediconameScanner = new Scanner(System.in);
        System.out.print("Nombre del medico encargado: ");
        var nameMedico = mediconameScanner.next();

        //Especialidad
        Especialidad especialidadMedico = null;
        //Se crea un while, en caso que sea numero incorrecto se queda como nulo para que se repita
        while (especialidadMedico == null){
        Scanner medicoEspecialidadScanner = new Scanner(System.in);
        //Se escribe las opciones de especialidades que hay que se selecciona con un swtch
        System.out.println("[1] Medicina General");
        System.out.println("[2] Neurología");
        System.out.println("[3] Cardiología");
        System.out.println("[4] Dermatología");
        System.out.println("[5] Pediatría");
        System.out.println("[6] Ginecología y Obstetricia");
        System.out.print("Ingrese la Especialidad del medico encargado: ");
        var i = medicoEspecialidadScanner.nextInt();
            switch (i) {
                case 1:
                    especialidadMedico = Especialidad.Medicina_General;
                    break;
                case 2:
                    especialidadMedico = Especialidad.Neurología;
                    break;
                case 3:
                    especialidadMedico = Especialidad.Cardiología;
                    break;
                case 4:
                    especialidadMedico = Especialidad.Dermatología;
                    break;
                case 5:
                    especialidadMedico = Especialidad.Pediatría;
                    break;
                case 6:
                    especialidadMedico = Especialidad.Ginecología_y_Obstetricia;
                    break;
                default:
                    System.err.println("Especialidad no encontrada");
                    especialidadMedico = null;
                    break;
            }
        }
        //Creacion de la variable
        this.medico = new Medico(nameMedico, especialidadMedico);
        
    }
    public void setMedicamento(){
        medicamento = new Medicamentos();
        this.medicamento.setMedicamento();
    }

    //Get de Receta
    //get Paciente
    public Paciente getPaciente(){
        return paciente;
    }
    public Medico getMedico(){
        return medico;
    }
    public Medicamentos getMedicamentos(){
        return medicamento;
    }
}
