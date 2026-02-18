/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;
import com.mycompany.calculadora.Excepctions.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

/**
 *
 * @author daniel-2405
 */
public class CalculadoraGUI extends JFrame implements ActionListener{
    private ArrayList<Operacion> historial = new ArrayList<>();
    // private ArrayList<Cliente> historial = new ArrayList<>();
    private static final String ARCHIVO_HISTORIAL = "Historial.bin";
    // Botones para los numeros
    private JButton btnNumero0, btnNumero1, btnNumero2, btnNumero3, btnNumero4, btnNumero5, btnNumero6,
                    btnNumero7, btnNumero8, btnNumero9, btnPunto;
    //Botones para las operaciones
    private JButton btnSumar, btnRestar, btnMultiplicar, btnDividir;
    // Boton de borrar e Igual
    private JButton btnBorrar, btnIgual;

    //Tabla donde saldra el historial
    private JTable tablaHistorial;
    private DefaultTableModel modeloTabla;

    private JButton btnGenerico;

    private JTextField txtOperacion;

    public CalculadoraGUI(){
        super("Sistema Solar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        getContentPane().setBackground(new Color(45, 45, 45));

        JPanel panelTable = new JPanel(new GridLayout(0,1,10,10));
        panelTable.setBorder(new EmptyBorder(5,20,5,20));
        panelTable.setBackground(new Color(45, 45, 45));
        JPanel panelTexto = new JPanel(new GridLayout(0,1,10,10)); 
        panelTexto.setBorder(new EmptyBorder(5,20,5,20)); 
        panelTexto.setBackground(new Color(45, 45, 45));
        JPanel panelPrincipal = new JPanel(new GridLayout(0,4,10,10)); 
        panelPrincipal.setBorder(new EmptyBorder(5,20,5,20)); 
        panelPrincipal.setBackground(new Color(45, 45, 45));

        txtOperacion = new JTextField();
        panelTexto.add(txtOperacion);

        btnBorrar = new JButton("C");
        btnBorrar.addActionListener(this);
        panelPrincipal.add(btnBorrar);
        btnGenerico = new JButton();
        panelPrincipal.add(btnGenerico);
        btnGenerico = new JButton();
        panelPrincipal.add(btnGenerico);
        btnDividir = new JButton("/");
        btnDividir.addActionListener(this);
        panelPrincipal.add(btnDividir);

        btnNumero7 = new JButton("7");
        btnNumero7.addActionListener(this);
        panelPrincipal.add(btnNumero7);
        btnNumero8 = new JButton("8");
        btnNumero8.addActionListener(this);
        panelPrincipal.add(btnNumero8);
        btnNumero9 = new JButton("9");
        btnNumero9.addActionListener(this);
        panelPrincipal.add(btnNumero9);
        btnMultiplicar = new JButton("x");
        btnMultiplicar.addActionListener(this);
        panelPrincipal.add(btnMultiplicar);

        btnNumero4 = new JButton("4");
        btnNumero4.addActionListener(this);
        panelPrincipal.add(btnNumero4);
        btnNumero5 = new JButton("5");
        btnNumero5.addActionListener(this);
        panelPrincipal.add(btnNumero5);
        btnNumero6 = new JButton("6");
        btnNumero6.addActionListener(this);
        panelPrincipal.add(btnNumero6);
        btnRestar = new JButton("-");
        btnRestar.addActionListener(this);
        panelPrincipal.add(btnRestar);

        btnNumero1 = new JButton("1");
        btnNumero1.addActionListener(this);
        panelPrincipal.add(btnNumero1);
        btnNumero2 = new JButton("2");
        btnNumero2.addActionListener(this);
        panelPrincipal.add(btnNumero2);
        btnNumero3 = new JButton("3");
        btnNumero3.addActionListener(this);
        panelPrincipal.add(btnNumero3);
        btnSumar = new JButton("+");
        btnSumar.addActionListener(this);
        panelPrincipal.add(btnSumar);

        btnGenerico = new JButton();
        panelPrincipal.add(btnGenerico);
        btnNumero0 = new JButton("0");
        btnNumero0.addActionListener(this);
        panelPrincipal.add(btnNumero0);
        btnPunto = new JButton(".");
        btnPunto.addActionListener(this);
        panelPrincipal.add(btnPunto);
        btnIgual = new JButton("=");
        btnIgual.addActionListener(this);
        panelPrincipal.add(btnIgual);
        
        // Inicializar la tabla de historial 
        modeloTabla = new DefaultTableModel(new Object[]{"Operación","=", "Resultado"}, 0);
        tablaHistorial = new JTable(modeloTabla);
        tablaHistorial.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(tablaHistorial);
        scroll.setPreferredSize(new Dimension(400, 100));
        panelTable.add(scroll);

        // ! ------ Seccion para darle estilo -------
        Color numbersButtonColor = new Color(68, 71, 75);
        Color operationButtonColor = new Color(0, 150, 136);
        Font botonFont = new Font("SansSerif", Font.BOLD, 16);
        Font txtFont = new Font("SansSerif", Font.PLAIN, 18);

        txtOperacion.setFont(txtFont);
        txtOperacion.setBackground(new Color(40, 40, 40));
        txtOperacion.setForeground(Color.WHITE);
        txtOperacion.setCaretColor(Color.WHITE);
        txtOperacion.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(80,80,80)), new EmptyBorder(6,8,6,8)));

        JButton[] botones = new JButton[]{btnBorrar, btnNumero0, btnNumero1, btnNumero2, btnNumero3, btnNumero4, btnNumero5, btnNumero6, btnNumero7, btnNumero8, btnNumero9, btnSumar, btnRestar, btnMultiplicar, btnDividir, btnIgual};
        for (JButton button : botones){
            button.setBackground(numbersButtonColor);
            button.setForeground(Color.WHITE);
            button.setFont(botonFont);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
            button.setOpaque(true);
        }

        btnSumar.setBackground(operationButtonColor);
        btnRestar.setBackground(operationButtonColor);
        btnMultiplicar.setBackground(operationButtonColor);
        btnDividir.setBackground(operationButtonColor);
        btnIgual.setBackground(new Color(33,150,243));

        tablaHistorial.setRowHeight(24);
        tablaHistorial.setShowGrid(false);
        tablaHistorial.setIntercellSpacing(new Dimension(0,0));
        tablaHistorial.setBackground(Color.WHITE);
        tablaHistorial.setForeground(new Color(45,45,45));
        tablaHistorial.setFont(new Font("SansSerif", Font.PLAIN, 13));
        JTableHeader tableHeader = tablaHistorial.getTableHeader();
        tableHeader.setBackground(new Color(30,30,30));
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(new Font("SansSerif", Font.BOLD, 13));
        scroll.setBorder(BorderFactory.createEmptyBorder());
        // !----------------------------------------------------------

        this.add(panelTable, BorderLayout.NORTH);
        this.add(panelTexto, BorderLayout.CENTER);
        this.add(panelPrincipal, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        try {
            cargarHistorial(ARCHIVO_HISTORIAL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Calculadora", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void guardarOperacion(String NombreArchivo, List<Operacion> operaciones) throws FileException{
        try(ObjectOutputStream objSalida = new ObjectOutputStream(new FileOutputStream(NombreArchivo))){
            objSalida.writeObject(operaciones);
        } catch (IOException ex){
            throw new FileException(ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Calculadora", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void cargarHistorial(String nombreArchivo) throws FileException{
        try (ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            List<Operacion> operacionesExistentes = (List<Operacion>) objEntrada.readObject();
            historial.clear();
            historial.addAll(operacionesExistentes);
            for (Operacion operacion : operacionesExistentes){
                modeloTabla.addRow(new Object[]{
                    operacion.getExpresion(),
                    "=",
                    operacion.getResultado()
                });
            }
        } catch (IOException ex) {
            throw new FileException(ex.getMessage());
        } catch (ClassNotFoundException ex){
            throw new FileException(ex.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Calculadora", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double evaluarExpresion() throws FileException, OperationsException{
        String expresion = txtOperacion.getText().replace("x", "*");
        double resultado = 0;
        double numero1 = 0;
        double numero2 = 0;
        char operador = ' ';

        if (expresion.isEmpty()) {
            throw new FileException("No hay expresión para evaluar.");
        }
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operador = c;
                numero1 = Double.parseDouble(expresion.substring(0, i));
                numero2 = Double.parseDouble(expresion.substring(i + 1));
                break;
            }
        }
        switch (operador) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if (numero2 == 0) {
                    txtOperacion.setText("");
                    throw new OperationsException("No se puede dividir entre 0.");
                }
                resultado = numero1 / numero2;
                break;
            default:
                txtOperacion.setText("");
                throw new OperationsException("Operador no válido.");
        }
        txtOperacion.setText(String.valueOf(resultado));
        Operacion nueva = new Operacion(expresion, resultado);
        historial.add(nueva);
        modeloTabla.addRow(new Object[]{
                expresion,
                "=",
                resultado
        });
        guardarOperacion(ARCHIVO_HISTORIAL, historial);
        return resultado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIgual){
            try {
                evaluarExpresion();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Calculadora", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == btnBorrar) {
            txtOperacion.setText("");
        }
        if (e.getSource() == btnPunto){ 
            txtOperacion.setText(txtOperacion.getText() + ".");
        }
        if (e.getSource() == btnNumero0){ 
            txtOperacion.setText(txtOperacion.getText() + "0");
        }
        if (e.getSource() == btnNumero1){ 
            txtOperacion.setText(txtOperacion.getText() + "1");
        }
        if (e.getSource() == btnNumero2){ 
            txtOperacion.setText(txtOperacion.getText() + "2");
        }
        if (e.getSource() == btnNumero3){ 
            txtOperacion.setText(txtOperacion.getText() + "3");
        }
        if (e.getSource() == btnNumero4){ 
            txtOperacion.setText(txtOperacion.getText() + "4");
        }
        if (e.getSource() == btnNumero5){ 
            txtOperacion.setText(txtOperacion.getText() + "5");
        }
        if (e.getSource() == btnNumero6){ 
            txtOperacion.setText(txtOperacion.getText() + "6");
        }
        if (e.getSource() == btnNumero7){ 
            txtOperacion.setText(txtOperacion.getText() + "7");
        }
        if (e.getSource() == btnNumero8){ 
            txtOperacion.setText(txtOperacion.getText() + "8");
        }
        if (e.getSource() == btnNumero9){ 
            txtOperacion.setText(txtOperacion.getText() + "9");
        }
        if (e.getSource() == btnSumar){
        txtOperacion.setText(txtOperacion.getText() + "+");
        }    
        if (e.getSource() == btnRestar) {
            txtOperacion.setText(txtOperacion.getText() + "-");
        }
        if (e.getSource() == btnMultiplicar) {
            txtOperacion.setText(txtOperacion.getText() + "x");
        }
        if (e.getSource() == btnDividir) {
            txtOperacion.setText(txtOperacion.getText() + "/");
        }
    }

}
