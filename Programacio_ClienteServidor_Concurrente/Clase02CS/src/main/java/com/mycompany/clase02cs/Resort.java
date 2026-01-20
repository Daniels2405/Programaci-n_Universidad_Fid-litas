package com.mycompany.clase02cs;

import java.util.Arrays;

public class Resort extends Hotel{
    private int numeroPicinas;
    private String[] actividadesRecreativas = new String[5];
    public Resort(String idPropiedad, String direccion, int areaM2, Tipo_Construccion tipoConstruccion, String nombre,
            int estrellas) {
        super(idPropiedad, direccion, areaM2, tipoConstruccion, nombre, estrellas);
    }
    public Resort() {
    }
    public int getNumeroPicinas() {
        return numeroPicinas;
    }
    public void setNumeroPicinas(int numeroPicinas) {
        this.numeroPicinas = numeroPicinas;
    }
    public String[] getActividadesRecreativas() {
        return actividadesRecreativas;
    }
    public void setActividadesRecreativas(String[] actividadesRecreativas) {
        this.actividadesRecreativas = actividadesRecreativas;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Resort [numeroPicinas=" + numeroPicinas + ", actividadesRecreativas="
                + Arrays.toString(actividadesRecreativas) + "]";
    }

    

}
