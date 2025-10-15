/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;
/**
 *
 * @author daniel
 */
public class HistoriaClinica {
    //Atributos del la historia clinica
    private String antecedentes;
    private String sintomas;
    private String diagnostico;

    public HistoriaClinica(String antecedentes, String sintomas, String diagnostico){
        this.antecedentes = antecedentes;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
    }
    
    //get de la historia clinica, por cada variable
    public String getAntecedentes(){
        return antecedentes;
    }
    public String getSintomas(){
        return sintomas;
    }
    public String getDiagnostico(){
        return diagnostico;
    }

}
