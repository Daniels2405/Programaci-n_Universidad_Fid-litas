/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Controlador;
import com.mycompany.proyecto_introduccion_java.Clases.*;
/**
 *
 * @author daniel
 */
public class SistemaLaboratorio {
    private String nombreEmpresa;
    private Laboratorio[] laboratorios; //Array de laboratorios en el sistema
    private Paciente[] pacientes; //Array de pacientes en el sistema
    private ParametroReferencia[] parametrosDeReferencia; //Objeto que contiene los parametros de referencia

    //Constructor
    public SistemaLaboratorio(String nombreEmpresa, Laboratorio[] laboratorios, Paciente[] pacientes, ParametroReferencia[] parametrosDeReferencia){
        this.nombreEmpresa = nombreEmpresa;
        this.laboratorios = laboratorios;
        this.pacientes = pacientes;
        this.parametrosDeReferencia = parametrosDeReferencia;
    }
    public SistemaLaboratorio(){}
    
    //Metodos del sistema
    public void mostrarLaboratorios(){ //Metodo para mostrar los laboratorios registrados en el sistema
        for (int i = 0; i < laboratorios.length; i++) {
        Laboratorio labActual = laboratorios[i];
        if (labActual != null) {
            System.out.println("Laboratorio " + (i + 1) + ":");
            System.out.println("Nombre: " + labActual.getNombre());
            System.out.println("Cédula Jurídica: " + labActual.getCedulaJuridica());
            System.out.println("Dirección: " + labActual.getDireccion());
            System.out.println("Teléfono: " + labActual.getTelefono());
            System.out.println("Correo: " + labActual.getCorreo());
            System.out.println();
        }
    } 
    }
    //Getters y setters
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public Laboratorio[] getLaboratorios() {
        return laboratorios;
    }
    public void setLaboratorios(Laboratorio laboratorio){ //Se modifica el setter para agregar laboratorios al array
        for(int i = 0; i < this.laboratorios.length; i++){
            if(this.laboratorios[i] == null){
                this.laboratorios[i] = laboratorio;
                break;
            }
        }
    }
    public Paciente[] getPacientes() {
        return pacientes;
    }
    public void setPacientes(Paciente[] pacientes) {
        this.pacientes = pacientes;
    }
    public ParametroReferencia[] getParametrosDeReferencia() {
        return parametrosDeReferencia;
    }
    public void setParametrosDeReferencia(ParametroReferencia[] parametrosDeReferencia) {
        this.parametrosDeReferencia = parametrosDeReferencia;
    }
    
}
