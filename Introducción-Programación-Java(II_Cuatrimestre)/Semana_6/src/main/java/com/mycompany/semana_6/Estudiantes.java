package com.mycompany.semana_6;

public class Estudiantes {
    private int id;
    public String nombre;
    public String apellido;
    private int edad;
    public String correo;
    public String telefono;

    public Estudiantes(int id, int edad, String telefono){
        this.id = id;
        this.edad = edad;
        this.telefono = telefono;
    }
    public Estudiantes(){
        
    }
    public void mostrarInfo(String nombre, String apellido, String correo){
        System.out.println("Informacion del estudiante");
        System.out.println("Nombre de estudiante " + nombre);
        System.out.println("Apellido de estudiante " + apellido);
        System.out.println("Correo de estudiante " + correo);
    }
    
    public String obtenerInfo(){
        return "Nombre: " + nombre + ", Edad: " + edad + ", Telefono: " + telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    


}
