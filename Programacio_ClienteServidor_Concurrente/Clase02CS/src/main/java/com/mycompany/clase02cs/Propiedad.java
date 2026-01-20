package com.mycompany.clase02cs;

public class Propiedad {
    private String idPropiedad;
    private String direccion;
    private int areaM2;
    private double costoOperativo;
    private Tipo_Construccion tipoConstruccion;
    
    public Propiedad(String idPropiedad, String direccion, int areaM2,
            Tipo_Construccion tipoConstruccion) {
        this.idPropiedad = idPropiedad;
        this.direccion = direccion;
        this.areaM2 = areaM2;
        this.tipoConstruccion = tipoConstruccion;
    }
    public Propiedad(){}

    public void cCalcularCostoOperativo(){
        switch (this.tipoConstruccion) {
            case RESIDENCIAL:
                this.costoOperativo = this.areaM2 * 2.5;
                break;
            case COMERCIAL:
                this.costoOperativo = this.areaM2 * 4.0;
                break;
            case INDUSTRIAL:
                this.costoOperativo = this.areaM2 * 5.0;
                break;
            case MIXTO:
                this.costoOperativo = this.areaM2 * 3.5;
                break;
            default:
                this.costoOperativo = 0;
                break;
        }
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(int areaM2) {
        this.areaM2 = areaM2;
    }

    public double getCostoOperativo() {
        return costoOperativo;
    }

    public void setCostoOperativo(double costoOperativo) {
        this.costoOperativo = costoOperativo;
    }

    public Tipo_Construccion getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(Tipo_Construccion tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    @Override
    public String toString() {
        return "Propiedad [idPropiedad=" + idPropiedad + ", direccion=" + direccion + ", areaM2=" + areaM2
                + ", costoOperativo=" + costoOperativo + ", tipoConstruccion=" + tipoConstruccion + "]";
    }
}
