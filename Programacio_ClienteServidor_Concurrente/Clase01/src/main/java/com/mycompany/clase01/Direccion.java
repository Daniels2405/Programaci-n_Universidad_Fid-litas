package com.mycompany.clase01;

public class Direccion {
    private String provincia;
    private String canton;
    private String distrito;
    private String otraSeñas;

    public Direccion(String provincia, String canton, String distrito, String otraSeñas) {
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.otraSeñas = otraSeñas;
    }
    public Direccion() {
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getOtraSeñas() {
        return otraSeñas;
    }

    public void setOtraSeñas(String otraSeñas) {
        this.otraSeñas = otraSeñas;
    }

    @Override
    public String toString() {
        return "Direccion{" + "provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + ", otraSe\u00f1as=" + otraSeñas + '}';
    }
}