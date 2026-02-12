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

/**
 *
 * @author daniel-2405
 */
public class FormularioEmpleadoTC extends JFrame implements ActionListener{
    //Persona
    private JTextField txtidPersona, txtnombreCompleto, txtFechaNacimiento;
    private JComboBox<Genero> cmGenero;
    //empleado
    private JTextField txtnumEmpleado, txtDepartamento, txtSalarioBase;
    //empleado tiempo completo
    private JTextField txtPorcentajeBono, txtCantidadHorasExtra, txtSalarioNeto;
    //tabla
    private JTable tablaEmpleadosTC;
    private DefaultTableModel modeloTabla;
    //botones
    private JButton btnRegistrar, btnCalcularSalario;

    public FormularioEmpleadoTC() {
        super("Formulario Empleado Tiempo Completo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        getContentPane().setBackground(Color.WHITE);

        JPanel panelPrincipal = new JPanel(new GridLayout(0,2,10,10)); //Filas, columnas, horisontal, vertical
        panelPrincipal.setBorder(new EmptyBorder(15,20,15,20)); //Margenes
        panelPrincipal.setBackground(Color.WHITE);

        //Inicializar los componentes
        //Persona
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

        //Empleado
        JLabel lblnumEmpleado = new JLabel("Número de Empleado: ");
        lblnumEmpleado.setForeground(Color.BLACK);
        panelPrincipal.add(lblnumEmpleado);
        txtnumEmpleado = new JTextField(20);
        panelPrincipal.add(txtnumEmpleado);

        JLabel lblDepartamento = new JLabel("Departamento: ");
        lblDepartamento.setForeground(Color.BLACK);
        panelPrincipal.add(lblDepartamento);
        txtDepartamento = new JTextField(20);
        panelPrincipal.add(txtDepartamento);

        JLabel lblSalarioBase = new JLabel("Salario Base: ");
        lblSalarioBase.setForeground(Color.BLACK);
        panelPrincipal.add(lblSalarioBase);
        txtSalarioBase = new JTextField(20);
        panelPrincipal.add(txtSalarioBase);

        //Empleado tiempo completo
        JLabel lblPorcentajeBono = new JLabel("Porcentaje de Bono: ");
        lblPorcentajeBono.setForeground(Color.BLACK);
        panelPrincipal.add(lblPorcentajeBono);
        txtPorcentajeBono = new JTextField(20);
        panelPrincipal.add(txtPorcentajeBono);

        JLabel lblCantidadHorasExtra = new JLabel("Cantidad de Horas Extra: ");
        lblCantidadHorasExtra.setForeground(Color.BLACK);
        panelPrincipal.add(lblCantidadHorasExtra);
        txtCantidadHorasExtra = new JTextField(20);
        panelPrincipal.add(txtCantidadHorasExtra);
        
        panelPrincipal.add(new JLabel("Salario Neto:"));
        txtSalarioNeto = new JTextField(30);
        panelPrincipal.add(txtSalarioNeto);

        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL)); 

	//Botones
	btnRegistrar = new JButton("Registrar Empleado TC");
        btnRegistrar.addActionListener(this);
        btnCalcularSalario = new JButton("Calcular Salario");
        btnCalcularSalario.addActionListener(this);
        panelPrincipal.add(btnCalcularSalario);
        panelPrincipal.add(btnRegistrar);

        //Tabla de Empleados TC
        String [] columnas = {"ID Persona", "Nombre Completo", "Género", "Fecha Nacimiento",
                            "Número Empleado", "Departamento", "Salario Base",
                            "Porcentaje Bono", "Horas Extra", "Salario Total"};

        modeloTabla = new DefaultTableModel(columnas, 0); //Sin filas al iniciarce 
        tablaEmpleadosTC = new JTable(modeloTabla);
        tablaEmpleadosTC.setBackground(Color.DARK_GRAY);
        tablaEmpleadosTC.setForeground (Color.WHITE);
        tablaEmpleadosTC.setRowHeight(14);
        tablaEmpleadosTC.setGridColor(Color.LIGHT_GRAY);
        tablaEmpleadosTC.setShowVerticalLines(false);

        tablaEmpleadosTC.getTableHeader().setBackground(Color.BLACK);
        tablaEmpleadosTC.getTableHeader().setForeground(Color.WHITE);
        tablaEmpleadosTC.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        //Se hace un scroll para la tabla
        JScrollPane scrollPane = new JScrollPane(tablaEmpleadosTC);
        scrollPane.setPreferredSize(new Dimension(800, 200));

        JPanel panelTable = new JPanel(new BorderLayout());
        panelTable.setBorder(new EmptyBorder(15,20,15,20));
        panelTable.setBackground(Color.DARK_GRAY);

        // Añadir el scrollPane que contiene la tabla al panelTable
        panelTable.add(scrollPane, BorderLayout.CENTER);

        this.add(panelPrincipal, BorderLayout.NORTH);
        this.add(panelTable, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void limpiarCampos() {
        txtidPersona.setText("");
        txtnombreCompleto.setText("");
        txtFechaNacimiento.setText("");
        cmGenero.setSelectedIndex(0);
        txtnumEmpleado.setText("");
        txtDepartamento.setText("");
        txtSalarioBase.setText("");
        txtPorcentajeBono.setText("");
        txtCantidadHorasExtra.setText("");
        }

    public EmpleadoTiempoCompleto construirEmpleado(){
        EmpleadoTiempoCompleto empleadoTC = new EmpleadoTiempoCompleto();
        String idPersona = txtidPersona.getText();
        String nombreCompleto = txtnombreCompleto.getText();
        Date fechaNacimiento = Date.valueOf(txtFechaNacimiento.getText());
        String genero = ((Genero) cmGenero.getSelectedItem()).toString();

        int numEmpleado = Integer.parseInt(txtnumEmpleado.getText());
        String departamento = txtDepartamento.getText();
        double salarioBase = Double.parseDouble(txtSalarioBase.getText());
        double porcentajeBono = Double.parseDouble(txtPorcentajeBono.getText());
        int cantidadHorasExtra = Integer.parseInt(txtCantidadHorasExtra.getText());
        
        empleadoTC.setIdPersona(idPersona);
        empleadoTC.setNombreCompleto(nombreCompleto);
        empleadoTC.setFechaNacimiento(fechaNacimiento);
        empleadoTC.setGenero(genero);
        empleadoTC.setNumEmpleado(numEmpleado);
        empleadoTC.setDepartamento(departamento);
        empleadoTC.setSalarioBase(salarioBase);
        empleadoTC.setPorcentajeBono(porcentajeBono);
        empleadoTC.setCantidadHorasExtra(cantidadHorasExtra);
        return empleadoTC;
    }
    public void registrarEmpleado() {
        try{
            EmpleadoTiempoCompleto empleadoTC = construirEmpleado();
            Double salarioNeto = empleadoTC.calcularSalario();
            
            modeloTabla.addRow(new Object[]{
                empleadoTC.getIdPersona(),
                empleadoTC.getNombreCompleto(),
                empleadoTC.getGenero(),
                empleadoTC.getFechaNacimiento(),
                empleadoTC.getNumEmpleado(),
                empleadoTC.getDepartamento(),
                empleadoTC.getSalarioBase(),
                empleadoTC.getPorcentajeBono(),
                empleadoTC.getCantidadHorasExtra(),
                salarioNeto
            });
            JOptionPane.showMessageDialog(null, "Empleado Registrado Correctamente", "Formulario de Empleados", JOptionPane.INFORMATION_MESSAGE);
        } catch(SalarioException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error registrar empleado Tiempo Completo", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error registrar empleado Tiempo Completo", JOptionPane.ERROR_MESSAGE);
        }

    }
    public void calcularSalario() {
        try{
            EmpleadoTiempoCompleto emp = construirEmpleado();
            Double salarioNeto = emp.calcularSalario();
            txtSalarioNeto.setText(String.valueOf(salarioNeto));
        }catch(SalarioException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error Calcular Salario", JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error Calcular Salario", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            registrarEmpleado();
            limpiarCampos();
        } else if (e.getSource() == btnCalcularSalario) {
            calcularSalario();
        }
    }
    
}
