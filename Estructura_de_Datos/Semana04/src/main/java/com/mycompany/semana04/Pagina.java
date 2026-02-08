/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana04;

/**
 *
 * @author daniel-2405
 */
public class Pagina {
    private String url;
    private Pagina abajo;

    public Pagina(String url) {
        this.url = url;
        this.abajo = null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Pagina getAbajo() {
        return abajo;
    }

    public void setAbajo(Pagina abajo) {
        this.abajo = abajo;
    }
    
}
