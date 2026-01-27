package com.mycompany.semana01;

public class Persona {
    String nombre;
    private int edad;

    public void saludar(){
        System.out.println("Hola, mi nombre es " + this.nombre + " y mi edad es " + this.edad + " años ");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
}
