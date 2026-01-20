/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase01;

import javax.swing.JFrame;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author daniel-2405
 */
public class RegistroClientesGUI extends JFrame implements ActionListener{
    //Componentes de Persona
    private JTextField txtidPersona;
    private JTextField txtnombreCompleto;
    private JTextField txtFechaNacimiento;
    private JComboBox<Genero> cmGenero;

    //Componentes de Cliente
    private JTextField txtidCliente;
    private JTextField txtMenbresia;
    private JTextField txtPuntos;
    private JTextField txtLimiteCredito;

    private JButton btnRegistrar;
    private DefaultTableModel modeloTabla;
    private JTable tablaClientes;

    public RegistroClientesGUI() {
        //Configuracion de la ventana
        super("Formulario de Registro Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        getContentPane().setBackground(Color.WHITE);


        //Usamos un layout de tipo cuadricula
        JPanel panelPrincipal = new JPanel(new GridLayout(0,2,10,10)); //Filas, columnas, horisontal, vertical
        panelPrincipal.setBorder(new EmptyBorder(15,20,15,20)); //Margenes
        panelPrincipal.setBackground(Color.WHITE);

        //Inicializar los componentes
        JLabel lblidPersona = new JLabel("Identificación: "); //Se crea el label
        lblidPersona.setForeground(Color.BLACK);
        panelPrincipal.add(lblidPersona);
        txtidPersona = new JTextField(20); //Se crea el campo de texto
        panelPrincipal.add(txtidPersona);

        JLabel lblNombreCompleto = new JLabel("Nombre Completo: ");
        lblNombreCompleto.setForeground(Color.BLACK);
        panelPrincipal.add(lblNombreCompleto);
        txtnombreCompleto = new JTextField(200);
        panelPrincipal.add(txtnombreCompleto);

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento: ");
        lblFechaNacimiento.setForeground(Color.BLACK);
        panelPrincipal.add(lblFechaNacimiento);
        txtFechaNacimiento = new JTextField(20);
        panelPrincipal.add(txtFechaNacimiento);

        JLabel lblGenero = new JLabel("Género: ");
        lblGenero.setForeground(Color.BLACK);
        panelPrincipal.add(lblGenero);
        cmGenero = new JComboBox<>(Genero.values());
        panelPrincipal.add(cmGenero);


        //Componentes de Cliente
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL)); //Linea separadora

        JLabel lblidCliente = new JLabel("ID Cliente: ");
        lblidCliente.setForeground(Color.BLACK);
        panelPrincipal.add(lblidCliente);
        txtidCliente = new JTextField(20);
        panelPrincipal.add(txtidCliente);

        JLabel lblMembresia = new JLabel("Membresía: ");
        lblMembresia.setForeground(Color.BLACK);
        panelPrincipal.add(lblMembresia);
        txtMenbresia = new JTextField(20);
        panelPrincipal.add(txtMenbresia);

        JLabel lblPuntos = new JLabel("Puntos: ");
        lblPuntos.setForeground(Color.BLACK);
        panelPrincipal.add(lblPuntos);
        txtPuntos = new JTextField(20);
        panelPrincipal.add(txtPuntos);

        JLabel lblLimiteCredito = new JLabel("Límite de Crédito: ");
        lblLimiteCredito.setForeground(Color.BLACK);
        panelPrincipal.add(lblLimiteCredito);
        txtLimiteCredito = new JTextField(20);
        panelPrincipal.add(txtLimiteCredito);
        
        panelPrincipal.add(new JLabel(""));

        //Boton Registrar
        btnRegistrar = new JButton("Registrar Cliente");
        btnRegistrar.addActionListener(this);
        panelPrincipal.add(btnRegistrar);

        //tabla clientes
        String [] columnas = {"ID Persona", "Nombre Completo", "Género", "Fecha Nacimiento",
                             "ID Cliente", "Membresía", "Puntos", "Límite Crédito"};  //Encabezados de la tabla

        modeloTabla = new DefaultTableModel(columnas, 0); //Sin filas al iniciarce 
        tablaClientes = new JTable(modeloTabla);
        tablaClientes.setBackground(Color.DARK_GRAY);
        tablaClientes.setForeground (Color.WHITE);
        tablaClientes.setRowHeight(25);
        tablaClientes.setGridColor(Color.LIGHT_GRAY);
        tablaClientes.setShowVerticalLines(false);

        tablaClientes.getTableHeader().setBackground(Color.BLACK);
        tablaClientes.getTableHeader().setForeground(Color.WHITE);
        tablaClientes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        //Se hace un scroll para la tabla
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        scrollPane.setPreferredSize(new Dimension(800, 200));

        JPanel panelTable = new JPanel(new BorderLayout());
        panelTable.setBorder(new EmptyBorder(15,20,15,20));
        panelTable.setBackground(Color.DARK_GRAY);

        // Añadir el scrollPane que contiene la tabla al panelTable
        panelTable.add(scrollPane, BorderLayout.CENTER);

        // Añadir los paneles al frame usando constantes de BorderLayout
        this.add(panelPrincipal, BorderLayout.NORTH);
        this.add(panelTable, BorderLayout.CENTER);

        // Ajustar tamaño según componentes y centrar la ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Logica del boton
        if (e.getSource() == btnRegistrar) {

        }
    }
}
