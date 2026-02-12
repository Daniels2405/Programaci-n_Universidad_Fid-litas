/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasolar.ComparadoresPlanetas;

import java.util.Comparator;
import com.mycompany.sistemasolar.Clases.*;

/**
 *
 * @author daniel-2405
 */
public class ComDistanciaSol implements Comparator<CuerpoCeleste>{

    @Override
    public int compare(CuerpoCeleste o1, CuerpoCeleste o2) {
        return Double.compare(o1.getDistanciaSol(), o2.getDistanciaSol());
    }
    
}
