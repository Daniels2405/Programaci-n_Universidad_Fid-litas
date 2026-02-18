/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase01;

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


/**
 *
 * @author daniel-2405
 */
public class RegistroClientesGUI extends JFrame implements ActionListener{
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private static final String ARCHIVO_CLIENTES = "clientes.bin";
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
    
    private Direccion direccionActual;

    private JButton btnRegistrar;
    private JButton btnAgregarDireccion;
    private DefaultTableModel modeloTabla;
    private JTable tablaClientes;

    

    public RegistroClientesGUI() {
        //Configuracion de la ventana
        super("Formulario de Registro Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL)); 

        //Boton de Agregar Direccion
        btnAgregarDireccion = new JButton("Agregar Dirección");
        btnAgregarDireccion.addActionListener(this);
        panelPrincipal.add(btnAgregarDireccion);

        //tabla clientes
        String [] columnas = {"ID Persona", "Nombre Completo", "Género", "Fecha Nacimiento",
                             "ID Cliente", "Membresía", "Puntos", "Límite Crédito"};  //Encabezados de la tabla

        modeloTabla = new DefaultTableModel(columnas, 0); //Sin filas al iniciarce 
        tablaClientes = new JTable(modeloTabla);
        tablaClientes.setBackground(Color.DARK_GRAY);
        tablaClientes.setForeground (Color.WHITE);
        tablaClientes.setRowHeight(14);
        tablaClientes.setGridColor(Color.LIGHT_GRAY);
        tablaClientes.setShowVerticalLines(false);

        tablaClientes.getTableHeader().setBackground(Color.BLACK);
        tablaClientes.getTableHeader().setForeground(Color.WHITE);
        tablaClientes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        listenerTable();

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
        try {
            cargarClientes(ARCHIVO_CLIENTES);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Formulario de clientes", JOptionPane.ERROR_MESSAGE);
        }
        }

        
        private void limpiarCampos() {
            txtidPersona.setText("");
            txtnombreCompleto.setText("");
            txtFechaNacimiento.setText("");
            cmGenero.setSelectedIndex(0);
            txtidCliente.setText("");
            txtMenbresia.setText("");
            txtPuntos.setText("");
            txtLimiteCredito.setText("");
        }
    
    private void guardarClientes(){
        try {
            //Obtener los datos
            String idPersona = txtidPersona.getText();
            String nombreCompleto = txtnombreCompleto.getText();
            Date fechaNacimiento = Date.valueOf(txtFechaNacimiento.getText());
            String genero = ((Genero) cmGenero.getSelectedItem()).toString();

            //Obtener datos de cliente
            int idCliente = Integer.parseInt (txtidCliente.getText());
            String membresia = txtMenbresia.getText();
            int puntos = Integer.parseInt (txtPuntos.getText());
            double limiteCredito = Double.parseDouble (txtLimiteCredito.getText());
            
            
            //Construir el objeto
            Direccion direccionCliente = new Direccion();
            Cliente nuevoCliente = new Cliente();
            nuevoCliente.setIdPersona(idPersona);
            nuevoCliente.setNombreCompleto(nombreCompleto);
            nuevoCliente.setGenero(genero);
            nuevoCliente.setFechaNacimiento(fechaNacimiento);
            nuevoCliente.setIdCliente(idCliente);
            nuevoCliente.setMembresia(membresia);
            nuevoCliente.setPuntos(puntos);
            nuevoCliente.setLimiteCredito(limiteCredito);
            nuevoCliente.setDireccion(direccionCliente);
            clientes.add(nuevoCliente); //Agrega a la lista
            
            //Agregar a la tabla
            
            modeloTabla.addRow(new Object[]{
                idPersona,
                nombreCompleto,
                genero,
                fechaNacimiento.toString(),
                idCliente,
                membresia,
                puntos,
                limiteCredito
            });
            guardarClientes(ARCHIVO_CLIENTES, clientes);
            JOptionPane.showMessageDialog(null, "Cliente Registrado Correctamente", "Formulario de clientes", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Formulario de clientes", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Formulario de clientes", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregarDireccionGui(){
        SwingUtilities.invokeLater(() -> { new RegistroDireccionGui();});
        //RegistroDireccionGui direccionGui = new RegistroDireccionGui();
        //direccionGui.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Logica del boton
        if (e.getSource() == btnRegistrar) {
            guardarClientes();
            limpiarCampos();
        }

        if (e.getSource() == btnAgregarDireccion){
            //Constructor de una nueva ventana para direccion
            //agregarDireccionGui();
            JOptionPane.showMessageDialog(null, "Funcionalidad en desarrollo", "Agregar Dirección", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void guardarClientes(String NombreArchivo, List<Cliente> pClientes) throws FileException{
        try(ObjectOutputStream objSalida = new ObjectOutputStream(new FileOutputStream(NombreArchivo))){
            objSalida.writeObject(pClientes);
        } catch (IOException ex){
            throw new FileException(ex.getMessage());
        }
    }

    private void cargarClientes(String NombreArchivo) throws FileException{
        try (ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream(NombreArchivo))){
            List<Cliente> clientesExistentes = (List<Cliente>) objEntrada.readObject();

            for(Cliente registro : clientesExistentes){
                modeloTabla.addRow(new Object[]{
                    registro.getIdPersona(),
                    registro.getNombreCompleto(),
                    registro.getGenero(),
                    registro.getFechaNacimiento(),
                    registro.getIdCliente(),
                    registro.getMembresia(),
                    registro.getPuntos(),
                    registro.getLimiteCredito(),
                });
            }

            clientes.addAll(clientesExistentes);

        } catch (IOException ex) {
            throw new FileException(ex.getMessage());
        } catch (ClassNotFoundException ex){
            throw new FileException(ex.getMessage());
        }
    }

    private void ordenarPorIdCliente(List<Cliente> pClientes){
        pClientes.sort(null); //Se le dice que use el compareTo de la clase Cliente
        actualizarTabla(pClientes);
    }

    private void ordenarPorNombre(List<Cliente> pClientes){
        pClientes.sort(new ComparatorCliente.ComparadorPorNombre()); 
        actualizarTabla(pClientes);
    }

    private void ordenarPorPuntos(List<Cliente> pClientes){
        pClientes.sort(new ComparatorCliente.ComparadorPorPuntos()); 
        actualizarTabla(pClientes);
    }

    private void ordenarPorLimite(List<Cliente> pClientes){
        pClientes.sort(new ComparatorCliente.ComparadorPorLimite()); 
        actualizarTabla(pClientes);
    }

    private void actualizarTabla(List<Cliente> pClientes){
        modeloTabla.setRowCount(0);
        for(Cliente registro : pClientes){
            modeloTabla.addRow(new Object[]{
                registro.getIdPersona(),
                registro.getNombreCompleto(),
                registro.getGenero(),
                registro.getFechaNacimiento(),
                registro.getIdCliente(),
                registro.getMembresia(),
                registro.getPuntos(),
                registro.getLimiteCredito(),
            });
        }
    }

    private void listenerTable(){
        tablaClientes.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                int col = tablaClientes.columnAtPoint(evt.getPoint());
                String nombreColumna = tablaClientes.getColumnName(col);
                ordenarColumna(nombreColumna);
            }
        });
    }

    private void ordenarColumna(String nombreColumna){
        switch (nombreColumna) {
            case "Nombre Completo":
                ordenarPorNombre(clientes);
                break;
            case "ID Cliente":
                ordenarPorIdCliente(clientes);
                break;
            case "Puntos":
                ordenarPorPuntos(clientes);
                break;
            case "Límite Crédito":
                ordenarPorLimite(clientes);
                break;
            default:
                break;
        }
    }
}