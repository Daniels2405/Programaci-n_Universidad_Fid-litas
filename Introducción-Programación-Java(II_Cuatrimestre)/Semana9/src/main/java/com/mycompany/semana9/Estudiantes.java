package com.mycompany.semana9;

public class Estudiantes {
    private int cedula;
    private String nombre;
    private String apellidos;

    public Estudiantes(int cedula, String nombre, String apellidos){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
}
