/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso1;

import com.mycompany.caso1.Habitaciones.Habitacion;
import com.mycompany.caso1.Habitaciones.HabitacionEstandar;
import com.mycompany.caso1.Habitaciones.HabitacionEjecutiva;
import com.mycompany.caso1.Habitaciones.SuiteFamiliar;
import com.mycompany.caso1.Reservas.AdministradorReservas;
import com.mycompany.caso1.Reservas.Reserva;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.io.*;
/**
 *
 * @author daniel-2405
 */
public class SistemaReservasGUI extends JFrame{
        private JTextField txtId, txtBuscarId, txtNombre, txtFechaIngreso,
                txtFechaSalida, txtCantidadHuespedes, txtCostoTotal;

        private JComboBox<String> cbTipoHabitacion;
        private JButton btnCalcular, btnRegistrar, btnBuscar;
        private JTable tabla;
        private DefaultTableModel modeloTabla;
        private AdministradorReservas admin = new AdministradorReservas();
        private DecimalFormat df = new DecimalFormat("0.00");
        public SistemaReservasGUI(){
                setTitle("Sistema de Gestión de Reservas Hotel Costa Azul S.A.");
                setSize(1100, 750);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setLayout(null); 

                Color fondoGeneral = new Color(220, 220, 220);
                getContentPane().setBackground(fondoGeneral);

                JPanel panelPrincipal = new JPanel();
                panelPrincipal.setLayout(null);
                panelPrincipal.setBounds(20, 20, 1040, 650);
                panelPrincipal.setBackground(new Color(230, 230, 230));
                panelPrincipal.setBorder(new LineBorder(Color.GRAY, 2));
                add(panelPrincipal);

                JLabel titulo = new JLabel("Sistema de Gestión de Reservas Hotel Costa Azul S.A.");
                titulo.setBounds(250, 15, 600, 30);
                titulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
                panelPrincipal.add(titulo);

                panelPrincipal.add(new JLabel("ID*")).setBounds(60, 80, 100, 25);
                txtId = new JTextField();
                txtId.setBounds(150, 80, 300, 30);
                txtId.setEditable(false);
                panelPrincipal.add(txtId);

                panelPrincipal.add(new JLabel("Buscar ID")).setBounds(550, 80, 100, 25);
                txtBuscarId = new JTextField();
                txtBuscarId.setBounds(650, 80, 300, 30);
                panelPrincipal.add(txtBuscarId);
                btnBuscar = new JButton("Buscar");
                btnBuscar.setBounds(960, 80, 80, 30);
                panelPrincipal.add(btnBuscar);

                panelPrincipal.add(new JLabel("Nombre Completo*")).setBounds(60, 140, 150, 25);
                txtNombre = new JTextField();
                txtNombre.setBounds(200, 140, 250, 30);
                panelPrincipal.add(txtNombre);

                panelPrincipal.add(new JLabel("Tipo Habitacion*")).setBounds(550, 140, 130, 25);
                cbTipoHabitacion = new JComboBox<>(new String[]{
                                "Estándar", "Suite Familiar", "Ejecutiva"
                });
                cbTipoHabitacion.setBounds(700, 140, 200, 30);
                panelPrincipal.add(cbTipoHabitacion);

                panelPrincipal.add(new JLabel("Fecha de ingreso* (yyyy-mm-dd)")).setBounds(60, 200, 200, 25);
                txtFechaIngreso = new JTextField();
                txtFechaIngreso.setBounds(260, 200, 190, 30);
                panelPrincipal.add(txtFechaIngreso);

                panelPrincipal.add(new JLabel("Fecha de salida* (yyyy-mm-dd)")).setBounds(480, 200, 200, 25);
                txtFechaSalida = new JTextField();
                txtFechaSalida.setBounds(700, 200, 200, 30);
                panelPrincipal.add(txtFechaSalida);

                panelPrincipal.add(new JLabel("Cantidad de Huespedes*")).setBounds(60, 260, 180, 25);
                txtCantidadHuespedes = new JTextField();
                txtCantidadHuespedes.setBounds(240, 260, 210, 30);
                panelPrincipal.add(txtCantidadHuespedes);

                panelPrincipal.add(new JLabel("Costo Total")).setBounds(60, 320, 100, 25);
                txtCostoTotal = new JTextField("0.00");
                txtCostoTotal.setBounds(150, 320, 150, 30);
                txtCostoTotal.setEditable(false);
                panelPrincipal.add(txtCostoTotal);

                btnCalcular = new JButton("Calcular");
                btnCalcular.setBounds(310, 320, 100, 30);
                panelPrincipal.add(btnCalcular);

                btnRegistrar = new JButton("Registrar");
                btnRegistrar.setBounds(700, 320, 200, 50);
                panelPrincipal.add(btnRegistrar);

                String[] columnas = {
                                "ID",
                                "Tipo de Habitacion",
                                "Fecha de Ingreso",
                                "Fecha de Salida",
                                "Cantidad de Huespedes",
                                "Costo Total"
                };

                modeloTabla = new DefaultTableModel(columnas, 0);
                tabla = new JTable(modeloTabla);
                JScrollPane scroll = new JScrollPane(tabla);
                scroll.setBounds(40, 400, 960, 200);
                panelPrincipal.add(scroll);
                try{
                        admin.cargarReservas("reservas.bin");
                        for(Reserva reserva : admin.getReservas()){
                                modeloTabla.addRow(new Object[]{ reserva.getID(), reserva.getHabitacion().getTipo(),
                                                reserva.getFechaIngreso() != null ? reserva.getFechaIngreso().toString() : "",
                                                reserva.getFechaSalida() != null ? reserva.getFechaSalida().toString() : "",
                                                reserva.getCantidadHuespedes(), String.valueOf(reserva.getCostoTotal()) });
                        }
                }catch(Exception ex){
                        System.err.println("No se pudieron cargar reservas: " + ex.getMessage());
                }


                btnCalcular.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                calcularCostoAction();
                        }
                });

                btnRegistrar.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                registrarReservaAction();
                        }
                });

                btnBuscar.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                                buscarReservaAction();
                        }
                });

                setVisible(true);
        }

        private Habitacion crearHabitacionDesdeTipo(String tipo){
                double tarifaBase = 35000;
                if(tipo == null) return new HabitacionEstandar("Estándar", tarifaBase);
                switch(tipo){
                        case "Estándar": 
                                return new HabitacionEstandar(tipo, tarifaBase);
                        case "Suite Familiar": 
                                return new SuiteFamiliar(tipo, tarifaBase);
                        case "Ejecutiva": 
                                return new HabitacionEjecutiva(tipo, tarifaBase);
                        default: 
                                return new HabitacionEstandar(tipo, tarifaBase);
                }
        }

        private void calcularCostoAction(){
                try{
                        String tipo = (String) cbTipoHabitacion.getSelectedItem();
                        Habitacion habitacion = crearHabitacionDesdeTipo(tipo);
                        Date fechaIngreso = Date.valueOf(txtFechaIngreso.getText().trim());
                        Date fechaSalida = Date.valueOf(txtFechaSalida.getText().trim());
                        int cantidad = Integer.parseInt(txtCantidadHuespedes.getText().trim());
                        Reserva reserva = new Reserva(0, txtNombre.getText().trim(), habitacion, fechaIngreso, fechaSalida, cantidad, 0);
                        if(!reserva.validarFechas()){
                                JOptionPane.showMessageDialog(this, "Fechas inválidas. Asegúrese que la fecha de salida sea posterior a la de ingreso.");
                                return;
                        }
                        if(!reserva.validarHuespedes()){
                                JOptionPane.showMessageDialog(this, "Cantidad de huéspedes inválida para el tipo de habitación.");
                                return;
                        }
                        double costo = reserva.calcularCosto();
                        txtCostoTotal.setText(df.format(costo));
                }catch(IllegalArgumentException ex){
                        JOptionPane.showMessageDialog(this, "Ingrese un número válido de huéspedes.");
                }catch(Exception ex){
                        JOptionPane.showMessageDialog(this, "Error calculando costo: " + ex.getMessage());
                }
        }

        private void registrarReservaAction(){
                try{
                        String tipo = (String) cbTipoHabitacion.getSelectedItem();
                        Habitacion habitacion = crearHabitacionDesdeTipo(tipo);
                        Date fechaIngreso = Date.valueOf(txtFechaIngreso.getText().trim());
                        Date fechaSalida = Date.valueOf(txtFechaSalida.getText().trim());
                        int cantidad = Integer.parseInt(txtCantidadHuespedes.getText().trim());
                        Reserva reserva = new Reserva(0, txtNombre.getText().trim(), habitacion, fechaIngreso, fechaSalida, cantidad, 0);
                        if(!reserva.validarFechas()){ JOptionPane.showMessageDialog(this, "Fechas inválidas."); return; }
                        if(!reserva.validarHuespedes()){ JOptionPane.showMessageDialog(this, "Huéspedes inválidos para la habitación."); return; }
                        double costo = reserva.calcularCosto();
                        int id = admin.generarID();
                        reserva.setID(id);
                        admin.agregarReserva(reserva);
                        try{
                                admin.guardarReservas("reservas.bin");
                        }catch(IOException ioex){
                                JOptionPane.showMessageDialog(this, "Error guardando reservas: " + ioex.getMessage());
                        }
                        modeloTabla.addRow(new Object[]{ id, tipo, fechaIngreso.toString(), fechaSalida.toString(), cantidad, df.format(costo) });
                        txtId.setText(String.valueOf(id));
                        JOptionPane.showMessageDialog(this, "Reserva registrada con ID: " + id);
                }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(this, "Ingrese un número válido de huéspedes.");
                }catch(IllegalArgumentException ex){
                        JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use yyyy-mm-dd.");
                }catch(Exception ex){
                        JOptionPane.showMessageDialog(this, "Error registrando reserva: " + ex.getMessage());
                }
        }

        private void buscarReservaAction(){
                try{
                        int id = Integer.parseInt(txtBuscarId.getText().trim());
                        Reserva reserva = admin.buscarPorId(id);
                        if(reserva == null){
                                JOptionPane.showMessageDialog(this, "No se encontró una reserva con ID: " + id);
                                return;
                        }
                        // llenar campos
                        txtId.setText(String.valueOf(reserva.getID()));
                        txtNombre.setText(reserva.getNombreCompleto());
                        if(reserva.getHabitacion() != null) cbTipoHabitacion.setSelectedItem(reserva.getHabitacion().getTipo());
                        if(reserva.getFechaIngreso() != null) txtFechaIngreso.setText(reserva.getFechaIngreso().toString());
                        if(reserva.getFechaSalida() != null) txtFechaSalida.setText(reserva.getFechaSalida().toString());
                        txtCantidadHuespedes.setText(String.valueOf(reserva.getCantidadHuespedes()));
                        double costo = reserva.getCostoTotal();
                        if(costo <= 0){
                                costo = reserva.calcularCosto();
                        }
                        txtCostoTotal.setText(df.format(costo));

                        // seleccionar fila en la tabla si existe
                        for(int i=0;i<modeloTabla.getRowCount();i++){
                                Object val = modeloTabla.getValueAt(i, 0);
                                if(val != null && Integer.parseInt(val.toString()) == id){
                                        tabla.setRowSelectionInterval(i, i);
                                        tabla.scrollRectToVisible(tabla.getCellRect(i, 0, true));
                                        break;
                                }
                        }
                }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(this, "Ingrese un ID numérico válido.");
                }catch(Exception ex){
                        JOptionPane.showMessageDialog(this, "Error buscando reserva: " + ex.getMessage());
                }
        }
}
