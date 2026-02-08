/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica01;

import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel-2405
 */
public class FigurasGUI extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu accionesFiguras;
    private JMenuItem calcularCirculo;
    private JMenuItem calcularCuadrado;
    private JMenuItem calcularTriangulo;


    public FigurasGUI() {
        super("Figuras Geométricas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        getContentPane().setBackground(Color.WHITE);

        JPanel panelPrincipal = new JPanel(new GridLayout(0,2,10,10)); //Filas, columnas, horisontal, vertical
        panelPrincipal.setBorder(new EmptyBorder(250,300,250,300)); //Margenes
        panelPrincipal.setBackground(Color.WHITE);


        //Iniciar los componentes
        menuBar = new JMenuBar();
        accionesFiguras = new JMenu("Acciones");
        calcularCirculo = new JMenuItem("Calcular Área o Perimetro del Círculo");
        calcularCuadrado = new JMenuItem("Calcular Área o Perimetro del Cuadrado");
        calcularTriangulo = new JMenuItem("Calcular Área o Perimetro del Triángulo");

        calcularCirculo.addActionListener(this);
        calcularCuadrado.addActionListener(this);
        calcularTriangulo.addActionListener(this);

        accionesFiguras.add(calcularCirculo);
        accionesFiguras.add(calcularCuadrado);
        accionesFiguras.add(calcularTriangulo);

        menuBar.add(accionesFiguras);
        setJMenuBar(menuBar);

        //Crear un label de bienbenida centrado
        JLabel bienvenidaLabel = new JLabel("Bienvenido al sistema de Figuras Geométricas");
        bienvenidaLabel.setHorizontalAlignment(JLabel.CENTER);
        bienvenidaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panelPrincipal.add(bienvenidaLabel);




        add(panelPrincipal, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularCirculo) {
            new CalcularCirculoForm().setVisible(true);
        } else if (e.getSource() == calcularCuadrado) {
            new CalcularCuadradoForm().setVisible(true);
        } else if (e.getSource() == calcularTriangulo) {
            new CalcularTrianguloForm().setVisible(true);
        }
    }
}