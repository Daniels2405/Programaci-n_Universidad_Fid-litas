package com.mycompany.practicaevaluada3;

public class Temperatura {
    //Atributos de la clase temperatura
    private String ciudad;
    private String día;
    private String mes;
    private int año;
    private double tempMax;
    private double temMin;
    private double temProm;
    private double sensacionTermica;
    private int humedad;
    private int probabilidadLluvia;
    private int velViento;
    private String condicionClima;

    //Se define el constructor vacio
    protected Temperatura(){}

    //Se definen los getters y setters de la clase
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDía() {
        return día;
    }

    public void setDía(String día) {
        this.día = día;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTemMin() {
        return temMin;
    }

    public void setTemMin(double temMin) {
        this.temMin = temMin;
    }

    public double getTemProm() {
        return temProm;
    }

    public void setTemProm(double temProm) {
        this.temProm = temProm;
    }

    public double getSensacionTermica() {
        return sensacionTermica;
    }

    public void setSensacionTermica(double sensacionTermica) {
        this.sensacionTermica = sensacionTermica;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getProbabilidadLluvia() {
        return probabilidadLluvia;
    }

    public void setProbabilidadLluvia(int probabilidadLluvia) {
        this.probabilidadLluvia = probabilidadLluvia;
    }

    public int getVelViento() {
        return velViento;
    }

    public void setVelViento(int velViente) {
        this.velViento = velViente;
    }

    public String getCondicionClima() {
        return condicionClima;
    }

    public void setCondicionClima(String condicionClima) {
        this.condicionClima = condicionClima;
    }
}
