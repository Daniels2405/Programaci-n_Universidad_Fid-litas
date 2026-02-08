/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana04;

/**
 *
 * @author daniel-2405
 */
public class PilaN {
    private Pagina cima;
    
    public PilaN(){
        cima = null;
    }
    
    public boolean isEmpty(){
        return cima == null;
    }
    
    
    public void push(String url){
        Pagina nuevaURL = new Pagina(url);
        if (isEmpty()){
            cima = nuevaURL;
        } else {
            nuevaURL.setAbajo(cima);
            cima = nuevaURL;
        }
    }

    public String pop(){
        if (isEmpty()){
            System.out.println("La pila está vacía");
            return null;
        } else {
            String urlCima = cima.getUrl();
            cima = cima.getAbajo();
            return urlCima;
        }
    }

    public String peek(){
        if (isEmpty()){
            return "La pila está vacía";
        }

        StringBuilder sb = new StringBuilder();
        Pagina actual = cima;
        while (actual != null){
            sb.append(actual.getUrl()).append(" ");
            actual = actual.getAbajo();
        }
        return sb.toString().trim();
    }
}
