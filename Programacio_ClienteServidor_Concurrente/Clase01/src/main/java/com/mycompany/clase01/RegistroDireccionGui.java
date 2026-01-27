/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase01;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 *
 * @author daniel-2405
 */
public class RegistroDireccionGui extends JFrame implements ActionListener{
    private JTextField txtProvincia;
    private JTextField txtCanton;
    private JTextField txtDistrito;
    private JTextField txtOtrasSeñas;
    private JButton btnGuardar;

    public RegistroDireccionGui() {
        super("Formulario de Registro de Dirección de Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        getContentPane().setBackground(Color.WHITE);

        JPanel panelDireccion = new JPanel(new GridLayout(0,2,10,10)); //Filas, columnas, horisontal, vertical
        panelDireccion.setBorder(new EmptyBorder(15,20,15,20)); //Margenes
        panelDireccion.setBackground(Color.WHITE);

        JLabel lblProvincia = new JLabel("Provincia: ");
        lblProvincia.setForeground(Color.BLACK);
        panelDireccion.add(lblProvincia);
        txtProvincia = new JTextField(20);
        panelDireccion.add(txtProvincia);
        
        JLabel lblCanton = new JLabel("Canton: ");
        lblCanton.setForeground(Color.BLACK);
        panelDireccion.add(lblCanton);
        txtCanton = new JTextField(20);
        panelDireccion.add(txtCanton);

        JLabel lblDistrito = new JLabel("Distrito: ");
        lblDistrito.setForeground(Color.BLACK);
        panelDireccion.add(lblDistrito);
        txtDistrito = new JTextField(20);
        panelDireccion.add(txtDistrito);

        JLabel lblOtrasSeñas = new JLabel("Otras Señas: ");
        lblOtrasSeñas.setForeground(Color.BLACK);
        panelDireccion.add(lblOtrasSeñas);
        txtOtrasSeñas = new JTextField(20);
        panelDireccion.add(txtOtrasSeñas);

        btnGuardar = new JButton("Guardar Dirección");
        btnGuardar.addActionListener(this);
        panelDireccion.add(btnGuardar);
        
        this.add(panelDireccion, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            String provincia = txtProvincia.getText();
            String canton = txtCanton.getText();
            String distrito = txtDistrito.getText();
            String otrasSeñas = txtOtrasSeñas.getText();

            Direccion direccion = new Direccion(provincia, canton, distrito, otrasSeñas);
            // lógica para guardar la dirección o pasarla al formulario principal
            
            JOptionPane.showMessageDialog(this, "Dirección guardada:" + direccion.toString());

            this.dispose(); // Cierra la ventana después de guardar
        }
    }
}
