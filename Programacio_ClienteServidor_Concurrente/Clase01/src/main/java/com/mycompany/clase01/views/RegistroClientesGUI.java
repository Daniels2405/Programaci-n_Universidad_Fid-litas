package com.mycompany.clase01.views;

import com.mycompany.clase01.models.Cliente;
import com.mycompany.clase01.controllers.ClienteController;
import com.mycompany.clase01.models.Genero;
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
import java.io.*;

public class RegistroClientesGUI extends JFrame {
    public static final String ARCHIVO_CLIENTES = "clientes.bin";
    public List<Cliente> clientes = new ArrayList();
    public JTextField txtidPersona;
    public JTextField txtNombreCompleto;
    public JTextField txtFechaNacimiento;
    public JComboBox<Genero> cmbGenero;

    public JTextField txtidCliente;
    public JTextField txtMembresia;
    public JTextField txtPuntos;
    public JTextField txtLimiteCredito;

    public JButton btnRegistrar;
    public JButton btnAgregarDirec;
    public JButton btnActualizar;
    public JButton btnEliminar;

    public DefaultTableModel modeloTabla;
    public JTable tablaCliente;

    public RegistroClientesGUI() {
        super("Formulario Registro Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        JPanel panelPrincipal = new JPanel(new GridLayout(0, 2, 10, 10));
        panelPrincipal.setBorder(new EmptyBorder(15, 20, 15, 20));
        panelPrincipal.setBackground(Color.GRAY);

        // Persona
        JLabel lblIdPersona = new JLabel("Identificación:");
        lblIdPersona.setForeground(Color.BLACK);
        panelPrincipal.add(lblIdPersona);
        txtidPersona = new JTextField(20);
        panelPrincipal.add(txtidPersona);

        JLabel lblNombre = new JLabel("Nombre Completo:");
        lblNombre.setForeground(Color.BLACK);
        panelPrincipal.add(lblNombre);
        txtNombreCompleto = new JTextField(150);
        panelPrincipal.add(txtNombreCompleto);

        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        lblFechaNacimiento.setForeground(Color.BLACK);
        panelPrincipal.add(lblFechaNacimiento);
        txtFechaNacimiento = new JTextField(20);
        panelPrincipal.add(txtFechaNacimiento);

        JLabel lblGenero = new JLabel("Genero:");
        lblGenero.setForeground(Color.BLACK);
        panelPrincipal.add(lblGenero);
        cmbGenero = new JComboBox<>(Genero.values());
        panelPrincipal.add(cmbGenero);

        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));

        // Cliente
        JLabel lblIdCliente = new JLabel("Numero Cliente:");
        lblIdCliente.setForeground(Color.BLACK);
        panelPrincipal.add(lblIdCliente);
        txtidCliente = new JTextField(20);
        panelPrincipal.add(txtidCliente);

        JLabel lblMembresia = new JLabel("Membresia:");
        lblMembresia.setForeground(Color.BLACK);
        panelPrincipal.add(lblMembresia);
        txtMembresia = new JTextField(30);
        panelPrincipal.add(txtMembresia);

        JLabel lblPuntos = new JLabel("Cant. Puntos:");
        lblPuntos.setForeground(Color.BLACK);
        panelPrincipal.add(lblPuntos);
        txtPuntos = new JTextField(20);
        panelPrincipal.add(txtPuntos);

        JLabel lblLimiteCredito = new JLabel("Limite Credito:");
        lblLimiteCredito.setForeground(Color.BLACK);
        panelPrincipal.add(lblLimiteCredito);
        txtLimiteCredito = new JTextField(20);
        panelPrincipal.add(txtLimiteCredito);

        // Botones
        btnRegistrar = new JButton("Registrar Cliente");
        panelPrincipal.add(btnRegistrar);
        btnAgregarDirec = new JButton("Agregar Direccion");
        panelPrincipal.add(btnAgregarDirec);
        btnActualizar = new JButton("Actualizar Cliente");
        btnActualizar.setEnabled(false);
        panelPrincipal.add(btnActualizar);
        btnEliminar = new JButton("Eliminar Cliente");
        btnEliminar.setEnabled(false);
        panelPrincipal.add(btnEliminar);

        // Tabla
        String[] columnas = {
            "Identificacion", "NombreCompleto", "FechaNacimiento", "Genero",
            "NumeroCliente", "Membresia", "Puntos", "LimiteCredito"
        };

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaCliente = new JTable(modeloTabla);
        tablaCliente.setBackground(Color.DARK_GRAY);
        tablaCliente.setForeground(Color.WHITE);
        tablaCliente.setRowHeight(12);
        tablaCliente.setGridColor(Color.LIGHT_GRAY);
        tablaCliente.setShowVerticalLines(false);

        tablaCliente.getTableHeader().setBackground(Color.BLACK);
        tablaCliente.getTableHeader().setForeground(Color.WHITE);
        tablaCliente.getTableHeader().setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        JScrollPane scroll = new JScrollPane(tablaCliente);
        scroll.setPreferredSize(new Dimension(800, 200));

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(new EmptyBorder(15, 20, 15, 20));
        panelTabla.add(scroll, BorderLayout.CENTER);
        panelTabla.setBackground(Color.DARK_GRAY);

        this.add(panelPrincipal, "North");
        this.add(panelTabla);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        new ClienteController(this);
    }
}