package com.mycompany.clase02cs;

public class Hotel extends Propiedad{
    private String nombre;
    private int estrellas;

    public Hotel(String idPropiedad, String direccion, int areaM2, Tipo_Construccion tipoConstruccion, String nombre,
            int estrellas) {
        super(idPropiedad, direccion, areaM2, tipoConstruccion);
        this.nombre = nombre;
        this.estrellas = estrellas;
    }

    public Hotel() {
    }

    public void InfoHotel(){
        System.out.println("Hotel: " + this.nombre + "Dirección: " + this.getDireccion()+", Estrellas: " + this.estrellas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        return super.toString() + "Hotel [nombre=" + nombre + ", estrellas=" + estrellas +"]";
    }

    
}
