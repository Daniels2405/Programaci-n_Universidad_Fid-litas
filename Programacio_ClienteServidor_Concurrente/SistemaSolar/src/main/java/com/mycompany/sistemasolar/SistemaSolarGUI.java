/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasolar;
import com.mycompany.sistemasolar.Clases.*;
import com.mycompany.sistemasolar.ComparadoresPlanetas.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import javax.swing.table.DefaultTableColumnModel;

/**
 *
 * @author daniel-2405
 */
public class SistemaSolarGUI extends JFrame implements ActionListener{
    private ArrayList<PlanetaRocoso> listaPlanetasRocosos = new ArrayList<>();
    private ArrayList<PlanetaGaseoso> listaPlanetasGaseosos = new ArrayList<>();
    //Elementos
    private JTextField txtNombre, txtDiametro, txtRadio, txtCircunferencia, txtmasa,
                        txtVolumen, txtdensidad, txtDistanciaSol, txtVelocidadRotacion, txtVelocidadTraslacion,
                        txtgravedad, txtduracionDia, txtduracionAnio, txtcantLunas;
    private JCheckBox chkTienteAnillos; //Se utiliza un chekbox ya que el atributo es un boolean
    private JComboBox<TipoPlaneta> cmTipoPlaneta;
    // Atributos Propios de Planeta Rocoso
    private JComboBox<TipoSuperficie> cmTipoSuperficie;
    private JCheckBox chkPlacasTectonicas;
    // Atributos propios de planeta Gaseoso
    private JComboBox<CompocisionPlanetaGaseoso> cmComposicion;
    private JCheckBox chkTormentaPermanente;

    private JTable tablaPlanetas;
    private DefaultTableModel modeloTabla;

    // Atributos individuales
    private JButton btncalcRadio, btnCalcCircunferencia, btnCalcVolumen, btnCalcDensidad,
                    btnCalcGravedad, btnCalcDuracionDia, btnCalcDuracionAnio;
    // Guardar planeta
    private JButton btnCalcularAtributos, btnguardarPlaneta;

    //Un combobox y un boton para el filtro de la tabla
    private JComboBox<Filtro> cmfiltro;
    private JButton btnAplicarFiltro;
    
    public SistemaSolarGUI(){
        // "Cree" colores especificos para algunas partes del programa
        Color txtColor = new Color(60,60,60);
        Color boton = new Color(70,70,70);
        Color panel = new Color(45,45,45);

        super("Sistema Solar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        getContentPane().setBackground(panel);

        //Paneles
        //Panel para un titulo
        JLabel lblTitulo = new JLabel("Sistema Solar", SwingConstants.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblTitulo.setBorder(new EmptyBorder(15, 10, 15, 10));

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setBackground(new Color(30, 30, 30));
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);

        this.add(panelTitulo, BorderLayout.NORTH);
        //Paneles
        JPanel panelPrincipal = new JPanel(new GridLayout(0,4,10,10)); //Filas, columnas, horisontal, vertical
        panelPrincipal.setBorder(new EmptyBorder(15,20,5,20)); //Margenes
        panelPrincipal.setBackground(new Color(45, 45, 45));
        JPanel panelTable = new JPanel(new GridLayout(0,1,10,10));
        panelTable.setBorder(new EmptyBorder(5,20,15,20));
        panelTable.setBackground(new Color(45, 45, 45));

        //!Incicializacion de los componentes que el sistema pide
        JLabel lblNombre = new JLabel("Nombre del Planeta *");
        lblNombre.setForeground(Color.WHITE);
        panelPrincipal.add(lblNombre);
        txtNombre = new JTextField(100);
        txtNombre.setBackground(txtColor);
        txtNombre.setForeground(Color.white);
        panelPrincipal.add(txtNombre);

        JLabel lblTipo = new JLabel("Tipo de planeta *");
        lblTipo.setForeground(Color.WHITE);
        panelPrincipal.add(lblTipo);
        cmTipoPlaneta = new JComboBox<>(TipoPlaneta.values());
        cmTipoPlaneta.setBackground(txtColor);
        cmTipoPlaneta.setForeground(Color.WHITE);
        panelPrincipal.add(cmTipoPlaneta);

        // Atributos unicos para Planeta Rocoso
        JLabel lblTipoSuperficie = new JLabel("Tipo de superficie (Rocoso) *");
        lblTipoSuperficie.setForeground(Color.WHITE);
        panelPrincipal.add(lblTipoSuperficie);
        cmTipoSuperficie = new JComboBox<>(TipoSuperficie.values());
        cmTipoSuperficie.setBackground(txtColor);
        cmTipoSuperficie.setForeground(Color.WHITE);
        panelPrincipal.add(cmTipoSuperficie);

        JLabel lblPlacas = new JLabel("Placas tectónicas (Rocoso) *");
        lblPlacas.setForeground(Color.WHITE);
        panelPrincipal.add(lblPlacas);
        chkPlacasTectonicas = new JCheckBox("Sí");
        chkPlacasTectonicas.setBackground(panel);
        chkPlacasTectonicas.setForeground(Color.WHITE);
        panelPrincipal.add(chkPlacasTectonicas);

        // Atributos uniocos para Planeta Gaseoso
        JLabel lblComposicion = new JLabel("Composición (Gaseoso) *");
        lblComposicion.setForeground(Color.WHITE);
        panelPrincipal.add(lblComposicion);
        cmComposicion = new JComboBox<>(CompocisionPlanetaGaseoso.values());
        cmComposicion.setBackground(txtColor);
        cmComposicion.setForeground(Color.WHITE);
        panelPrincipal.add(cmComposicion);

        JLabel lblTormenta = new JLabel("Tormenta permanente (Gaseoso) *");
        lblTormenta.setForeground(Color.WHITE);
        panelPrincipal.add(lblTormenta);
        chkTormentaPermanente = new JCheckBox("Sí");
        chkTormentaPermanente.setBackground(panel);
        chkTormentaPermanente.setForeground(Color.WHITE);
        panelPrincipal.add(chkTormentaPermanente);

        JLabel lblMasa = new JLabel("Masa (kg) *");
        lblMasa.setForeground(Color.WHITE);
        panelPrincipal.add(lblMasa);
        txtmasa = new JTextField();
        txtmasa.setBackground(txtColor);
        txtmasa.setForeground(Color.WHITE);
        panelPrincipal.add(txtmasa);

        JLabel lblDiametro = new JLabel("Diámetro (km) *");
        lblDiametro.setForeground(Color.WHITE);
        panelPrincipal.add(lblDiametro);
        txtDiametro = new JTextField();
        txtDiametro.setBackground(txtColor);
        txtDiametro.setForeground(Color.WHITE);
        panelPrincipal.add(txtDiametro);

        JLabel lblRadio = new JLabel("Radio (km)");
        lblRadio.setForeground(Color.WHITE);
        panelPrincipal.add(lblRadio);
        JPanel panelRadio = new JPanel(new BorderLayout(5,0));
        panelRadio.setBackground(panel);
        txtRadio = new JTextField();
        txtRadio.setBackground(txtColor);
        txtRadio.setForeground(Color.WHITE);
        btncalcRadio = new JButton("Calcular Radio");
        btncalcRadio.setBackground(boton);
        btncalcRadio.setForeground(Color.WHITE);
        panelRadio.add(txtRadio, BorderLayout.CENTER);
        panelRadio.add(btncalcRadio, BorderLayout.EAST);
        panelPrincipal.add(panelRadio);

        JLabel lblCirc = new JLabel("Circunferencia");
        lblCirc.setForeground(Color.WHITE);
        panelPrincipal.add(lblCirc);
        JPanel panelCirc = new JPanel(new BorderLayout(5,0));
        panelCirc.setBackground(panel);
        txtCircunferencia = new JTextField();
        txtCircunferencia.setBackground(txtColor);
        txtCircunferencia.setForeground(Color.WHITE);
        btnCalcCircunferencia = new JButton("Calcular Circ.");
        btnCalcCircunferencia.setBackground(boton);
        btnCalcCircunferencia.setForeground(Color.WHITE);
        panelCirc.add(txtCircunferencia, BorderLayout.CENTER);
        panelCirc.add(btnCalcCircunferencia, BorderLayout.EAST);
        panelPrincipal.add(panelCirc);

        JLabel lblVol = new JLabel("Volumen");
        lblVol.setForeground(Color.WHITE);
        panelPrincipal.add(lblVol);
        JPanel panelVol = new JPanel(new BorderLayout(5,0));
        panelVol.setBackground(panel);
        txtVolumen = new JTextField();
        txtVolumen.setBackground(txtColor);
        txtVolumen.setForeground(Color.WHITE);
        btnCalcVolumen = new JButton("Calcular Volumen");
        btnCalcVolumen.setBackground(boton);
        btnCalcVolumen.setForeground(Color.WHITE);
        panelVol.add(txtVolumen, BorderLayout.CENTER);
        panelVol.add(btnCalcVolumen, BorderLayout.EAST);
        panelPrincipal.add(panelVol);

        JLabel lblDen = new JLabel("Densidad");
        lblDen.setForeground(Color.WHITE);
        panelPrincipal.add(lblDen);
        JPanel panelDen = new JPanel(new BorderLayout(5,0));
        panelDen.setBackground(panel);
        txtdensidad = new JTextField();
        txtdensidad.setBackground(txtColor);
        txtdensidad.setForeground(Color.WHITE);
        btnCalcDensidad = new JButton("Calcular Densidad");
        btnCalcDensidad.setBackground(boton);
        btnCalcDensidad.setForeground(Color.WHITE);
        panelDen.add(txtdensidad, BorderLayout.CENTER);
        panelDen.add(btnCalcDensidad, BorderLayout.EAST);
        panelPrincipal.add(panelDen);


        JLabel lblDistSol = new JLabel("Distancia al Sol (km) *");
        lblDistSol.setForeground(Color.WHITE);
        panelPrincipal.add(lblDistSol);
        txtDistanciaSol = new JTextField();
        txtDistanciaSol.setBackground(txtColor);
        txtDistanciaSol.setForeground(Color.WHITE);
        panelPrincipal.add(txtDistanciaSol);

        JLabel lblGrav = new JLabel("Gravedad");
        lblGrav.setForeground(Color.WHITE);
        panelPrincipal.add(lblGrav);
        JPanel panelGrav = new JPanel(new BorderLayout(5, 0));
        panelGrav.setBackground(panel);
        txtgravedad = new JTextField();
        txtgravedad.setBackground(txtColor);
        txtgravedad.setForeground(Color.WHITE);
        btnCalcGravedad = new JButton("Calcular Gravedad");
        btnCalcGravedad.setBackground(boton);
        btnCalcGravedad.setForeground(Color.WHITE);
        panelGrav.add(txtgravedad, BorderLayout.CENTER);
        panelGrav.add(btnCalcGravedad, BorderLayout.EAST);
        panelPrincipal.add(panelGrav);

        JLabel lblVelRot = new JLabel("Velocidad rotación (km/h) *");
        lblVelRot.setForeground(Color.WHITE);
        panelPrincipal.add(lblVelRot);
        txtVelocidadRotacion = new JTextField();
        txtVelocidadRotacion.setBackground(txtColor);
        txtVelocidadRotacion.setForeground(Color.WHITE);
        panelPrincipal.add(txtVelocidadRotacion);

        JLabel lblDia = new JLabel("Duración del día");
        lblDia.setForeground(Color.WHITE);
        panelPrincipal.add(lblDia);
        JPanel panelDia = new JPanel(new BorderLayout(5, 0));
        panelDia.setBackground(panel);
        txtduracionDia = new JTextField();
        txtduracionDia.setBackground(txtColor);
        txtduracionDia.setForeground(Color.WHITE);
        btnCalcDuracionDia = new JButton("Calcular Día");
        btnCalcDuracionDia.setBackground(boton);
        btnCalcDuracionDia.setForeground(Color.WHITE);
        panelDia.add(txtduracionDia, BorderLayout.CENTER);
        panelDia.add(btnCalcDuracionDia, BorderLayout.EAST);
        panelPrincipal.add(panelDia);

        JLabel lblVelTras = new JLabel("Velocidad traslación (km/h) *");
        lblVelTras.setForeground(Color.WHITE);
        panelPrincipal.add(lblVelTras);
        txtVelocidadTraslacion = new JTextField();
        txtVelocidadTraslacion.setBackground(txtColor);
        txtVelocidadTraslacion.setForeground(Color.WHITE);
        panelPrincipal.add(txtVelocidadTraslacion);

        JLabel lblAnio = new JLabel("Duración del año");
        lblAnio.setForeground(Color.WHITE);
        panelPrincipal.add(lblAnio);
        JPanel panelAnio = new JPanel(new BorderLayout(5, 0));
        panelAnio.setBackground(panel);
        txtduracionAnio = new JTextField();
        txtduracionAnio.setBackground(txtColor);
        txtduracionAnio.setForeground(Color.WHITE);
        btnCalcDuracionAnio = new JButton("Calcular Año");
        btnCalcDuracionAnio.setBackground(boton);
        btnCalcDuracionAnio.setForeground(Color.WHITE);
        panelAnio.add(txtduracionAnio, BorderLayout.CENTER);
        panelAnio.add(btnCalcDuracionAnio, BorderLayout.EAST);
        panelPrincipal.add(panelAnio);

        JLabel lblLunas = new JLabel("Cantidad de lunas *");
        lblLunas.setForeground(Color.WHITE);
        panelPrincipal.add(lblLunas);
        txtcantLunas = new JTextField();
        txtcantLunas.setBackground(txtColor);
        txtcantLunas.setForeground(Color.WHITE);
        panelPrincipal.add(txtcantLunas);

        JLabel lblAnillos = new JLabel("¿Tiene anillos?");
        lblAnillos.setForeground(Color.WHITE);
        panelPrincipal.add(lblAnillos);
        chkTienteAnillos = new JCheckBox("Sí");
        chkTienteAnillos.setBackground(panel);
        chkTienteAnillos.setForeground(Color.WHITE);
        panelPrincipal.add(chkTienteAnillos);

        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JLabel(""));
        panelPrincipal.add(new JLabel(""));
        // Botondes de calcular todos los atributos y de guardar
        btnCalcularAtributos = new JButton("Calcular atributos");
        btnCalcularAtributos.setBackground(new Color(90,90,90));
        btnCalcularAtributos.setForeground(Color.WHITE);
        panelPrincipal.add(btnCalcularAtributos);
        btnguardarPlaneta = new JButton("Guardar planeta");
        btnguardarPlaneta.setBackground(new Color(100,120,100));
        btnguardarPlaneta.setForeground(Color.WHITE);
        panelPrincipal.add(btnguardarPlaneta);

        btncalcRadio.addActionListener(this);
        btnCalcCircunferencia.addActionListener(this);
        btnCalcVolumen.addActionListener(this);
        btnCalcDensidad.addActionListener(this);
        btnCalcGravedad.addActionListener(this);
        btnCalcDuracionDia.addActionListener(this);
        btnCalcDuracionAnio.addActionListener(this);
        btnCalcularAtributos.addActionListener(this);
        btnguardarPlaneta.addActionListener(this);

        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JSeparator(SwingConstants.HORIZONTAL));
        panelPrincipal.add(new JLabel(""));
        panelPrincipal.add(new JLabel(""));
        
        // Cb y boton para el filtro
        cmfiltro = new JComboBox<>(Filtro.values());
        cmfiltro.setBackground(txtColor);
        cmfiltro.setForeground(Color.WHITE);
        panelPrincipal.add(cmfiltro);
        btnAplicarFiltro = new JButton("Aplicar Filtro");
        btnAplicarFiltro.setBackground(new Color(90,90,90));
        btnAplicarFiltro.setForeground(Color.WHITE);
        panelPrincipal.add(btnAplicarFiltro);
        btnAplicarFiltro.addActionListener(this);

        //Tabla
        String[] columnas = {"Nombre", "Tipo", "Masa", "Diámetro",
                    "Radio", "Volumen", "Densidad", "Gravedad",
                    "Duración Día", "Duración Año",
                    "Distancia Sol", "Vel. Rotación", "Vel. Traslación",
                    "Lunas", "Anillos",
                    "Tipo Superficie", "Placas Tectónicas", "Composición", "Tormenta Permanente"
        };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaPlanetas = new JTable(modeloTabla);
        tablaPlanetas.setBackground(new Color(55,55,55));
        tablaPlanetas.setForeground(Color.WHITE);
        tablaPlanetas.setGridColor(Color.GRAY);
        tablaPlanetas.getTableHeader().setBackground(new Color(70,70,70));
        tablaPlanetas.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(tablaPlanetas);
        panelTable.add(scrollPane, BorderLayout.CENTER);
        
        this.add(panelPrincipal,BorderLayout.CENTER);
        this.add(panelTable, BorderLayout.SOUTH);
        
        //Se colocaan ajustes para el tamaño de la ventana
        setSize(1200, 1000);
        setMinimumSize(new Dimension(1000, 700)); //Hace que la ventana no se pueda hacer más pequeña
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void limpiarCampos(){
        txtNombre.setText("");
        txtmasa.setText("");
        txtDiametro.setText("");
        txtDistanciaSol.setText("");
        txtVelocidadRotacion.setText("");
        txtVelocidadTraslacion.setText("");
        txtcantLunas.setText("");
        txtRadio.setText("");
        txtCircunferencia.setText("");
        txtVolumen.setText("");
        txtdensidad.setText("");
        txtgravedad.setText("");
        txtduracionDia.setText("");
        txtduracionAnio.setText("");
        chkTienteAnillos.setSelected(false);
        chkPlacasTectonicas.setSelected(false);
        chkTormentaPermanente.setSelected(false);
    }

    public void registrarPlaneta(){
        try {
            if (txtNombre.getText().isEmpty() ||
                txtmasa.getText().isEmpty() ||
                txtDiametro.getText().isEmpty() ||
                txtDistanciaSol.getText().isEmpty() ||
                txtVelocidadRotacion.getText().isEmpty() ||
                txtVelocidadTraslacion.getText().isEmpty() ||
                txtcantLunas.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Complete todos los campos obligatorios (*)",
                    "Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            // parsear y validar no-negativos
            double masa = Double.parseDouble(txtmasa.getText());
            double diametro = Double.parseDouble(txtDiametro.getText());
            double distancia = Double.parseDouble(txtDistanciaSol.getText());
            double velocidadRotacion = Double.parseDouble(txtVelocidadRotacion.getText());
            double velTraslacion = Double.parseDouble(txtVelocidadTraslacion.getText());
            int lunas = Integer.parseInt(txtcantLunas.getText());

            if (masa < 0 || diametro < 0 || distancia < 0 || velocidadRotacion < 0 || velTraslacion < 0 || lunas < 0) {
                JOptionPane.showMessageDialog(this, "Los valores numéricos no pueden ser negativos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            TipoPlaneta tipo = (TipoPlaneta) cmTipoPlaneta.getSelectedItem();
            if (tipo == TipoPlaneta.Planeta_Rocoso) {
                PlanetaRocoso planeta = construirPlanetaR();
                listaPlanetasRocosos.add(planeta);
                modeloTabla.addRow(new Object[]{
                    planeta.getNombre(),
                    planeta.getTipo(),
                    planeta.getMasa(),
                    planeta.getDiametro(),
                    planeta.getRadio(),
                    planeta.getVolumen(),
                    planeta.getDensidad(),
                    planeta.getGravedad(),
                    planeta.getDuracionDia(),
                    planeta.getDuracionAnio(),
                    planeta.getDistanciaSol(),
                    planeta.getVelocidadRotacion(),
                    planeta.getVelocidadTraslacion(),
                    planeta.getCantLunas(),
                    planeta.getAnillos(),
                    planeta.getTipoSuperficie(),
                    planeta.isPlacasTectonicas(),
                    "NO APLICA",
                    "NO APLICA"
                });
                limpiarCampos();
                JOptionPane.showMessageDialog(this,
                "Planeta registrado correctamente",
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else if (tipo == TipoPlaneta.Planeta_Gaseoso){
                PlanetaGaseoso planeta = construirPlanetaG();
                listaPlanetasGaseosos.add(planeta);
                modeloTabla.addRow(new Object[]{
                    planeta.getNombre(),
                    planeta.getTipo(),
                    planeta.getMasa(),
                    planeta.getDiametro(),
                    planeta.getRadio(),
                    planeta.getVolumen(),
                    planeta.getDensidad(),
                    planeta.getGravedad(),
                    planeta.getDuracionDia(),
                    planeta.getDuracionAnio(),
                    planeta.getDistanciaSol(),
                    planeta.getVelocidadRotacion(),
                    planeta.getVelocidadTraslacion(),
                    planeta.getCantLunas(),
                    planeta.getAnillos(),
                    "NO APLICA",
                    "NO APLICA",
                    planeta.getComposicion(),
                    planeta.isTormentaPermanente()
                });
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Planeta registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,"Seleccione el tipo de Planeta", "Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Verifique que los campos numéricos sean válidos",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Ocurrio un error inesperado",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public PlanetaRocoso construirPlanetaR(){
        String nombre = txtNombre.getText();
        TipoPlaneta tipo = (TipoPlaneta) cmTipoPlaneta.getSelectedItem();
        double masa = Double.parseDouble(txtmasa.getText());
        double diametro = Double.parseDouble(txtDiametro.getText());
        double distanciaSol = Double.parseDouble(txtDistanciaSol.getText());
        double velRotacion = Double.parseDouble(txtVelocidadRotacion.getText());
        double velTraslacion = Double.parseDouble(txtVelocidadTraslacion.getText());
        TipoSuperficie tipoSuperficie = (TipoSuperficie) cmTipoSuperficie.getSelectedItem();
        boolean placas = chkPlacasTectonicas.isSelected();
        int cantLunas = Integer.parseInt(txtcantLunas.getText());
        boolean anillos = chkTienteAnillos.isSelected();

        PlanetaRocoso nuevoPRocoso = new PlanetaRocoso();
        nuevoPRocoso.setNombre(nombre);
        nuevoPRocoso.setTipo(tipo);
        nuevoPRocoso.setMasa(masa);
        nuevoPRocoso.setDiametro(diametro);
        nuevoPRocoso.setDistanciaSol(distanciaSol);
        nuevoPRocoso.setVelocidadRotacion(velRotacion);
        nuevoPRocoso.setVelocidadTraslacion(velTraslacion);
        nuevoPRocoso.setTipoSuperficie(tipoSuperficie);
        nuevoPRocoso.setPlacasTectonicas(placas);
        nuevoPRocoso.setRadio(nuevoPRocoso.calcularRadio());
        nuevoPRocoso.setCircunferencia(nuevoPRocoso.calcularCircunferencia());
        nuevoPRocoso.setVolumen(nuevoPRocoso.calcularVolumen());
        nuevoPRocoso.setDensidad(nuevoPRocoso.calcularDensidad());
        nuevoPRocoso.setGravedad(nuevoPRocoso.calcularGravedad());
        nuevoPRocoso.setDuracionDia(nuevoPRocoso.calcularDuracionDia());
        nuevoPRocoso.setDuracionAnio(nuevoPRocoso.calcularDuracionAnio());
        nuevoPRocoso.setCantLunas(cantLunas);
        nuevoPRocoso.setAnillos(anillos);
        return nuevoPRocoso;
    }

    public PlanetaGaseoso construirPlanetaG(){
        String nombre = txtNombre.getText();
        TipoPlaneta tipo = (TipoPlaneta) cmTipoPlaneta.getSelectedItem();
        double masa = Double.parseDouble(txtmasa.getText());
        double diametro = Double.parseDouble(txtDiametro.getText());
        double distanciaSol = Double.parseDouble(txtDistanciaSol.getText());
        double velRotacion = Double.parseDouble(txtVelocidadRotacion.getText());
        double velTraslacion = Double.parseDouble(txtVelocidadTraslacion.getText());
        CompocisionPlanetaGaseoso composicion = (CompocisionPlanetaGaseoso) cmComposicion.getSelectedItem();
        boolean tormenta = chkTormentaPermanente.isSelected();
        int cantLunas = Integer.parseInt(txtcantLunas.getText());
        boolean anillos = chkTienteAnillos.isSelected();

        PlanetaGaseoso nuevoPGaseoso = new PlanetaGaseoso();
        nuevoPGaseoso.setNombre(nombre);
        nuevoPGaseoso.setTipo(tipo);
        nuevoPGaseoso.setMasa(masa);
        nuevoPGaseoso.setDiametro(diametro);
        nuevoPGaseoso.setDistanciaSol(distanciaSol);
        nuevoPGaseoso.setVelocidadRotacion(velRotacion);
        nuevoPGaseoso.setVelocidadTraslacion(velTraslacion);
        nuevoPGaseoso.setComposicion(composicion);
        nuevoPGaseoso.setTormentaPermanente(tormenta);
        nuevoPGaseoso.setRadio(nuevoPGaseoso.calcularRadio());
        nuevoPGaseoso.setCircunferencia(nuevoPGaseoso.calcularCircunferencia());
        nuevoPGaseoso.setVolumen(nuevoPGaseoso.calcularVolumen());
        nuevoPGaseoso.setDensidad(nuevoPGaseoso.calcularDensidad());
        nuevoPGaseoso.setGravedad(nuevoPGaseoso.calcularGravedad());
        nuevoPGaseoso.setDuracionDia(nuevoPGaseoso.calcularDuracionDia());
        nuevoPGaseoso.setDuracionAnio(nuevoPGaseoso.calcularDuracionAnio());
        nuevoPGaseoso.setCantLunas(cantLunas);
        nuevoPGaseoso.setAnillos(anillos);
        return nuevoPGaseoso;
    }
    private void calcularRadioDesdeCampos() {
        try {
            double diametro = Double.parseDouble(txtDiametro.getText());
            if (diametro <= 0) {
                JOptionPane.showMessageDialog(this, "Valor numérico inválido para diámetro: " + "Error", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double radio = diametro / 2.0;
            txtRadio.setText(String.valueOf(radio));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor numérico inválido para diámetro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtRadio.setText("");
        }
    }

    private void calcularCircunferenciaDesdeCampos() {
        try {
            double diametro = Double.parseDouble(txtDiametro.getText());
            if (diametro < 0) {
                JOptionPane.showMessageDialog(this, "Valor numérico inválido para diámetro: " + "Error", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double circunferencia = Math.PI * diametro;
            txtCircunferencia.setText(String.valueOf(circunferencia));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor numérico inválido para diámetro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtCircunferencia.setText("");
        }
    }

    private void calcularVolumenDesdeCampos() {
        try {
            calcularRadioDesdeCampos();
            double radio = Double.parseDouble(txtRadio.getText());
            if (radio < 0) {
                JOptionPane.showMessageDialog(this, "Valor numérico inválido para Radio: " + "Error", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
            txtVolumen.setText(String.valueOf(volumen));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor numérico inválido para Radio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtVolumen.setText("");
        }
    }

    private void calcularDensidadDesdeCampos() {
        try {
            double masa = Double.parseDouble(txtmasa.getText());
            calcularVolumenDesdeCampos();
            double volumen = Double.parseDouble(txtVolumen.getText());
            if (masa < 0 || volumen < 0) {
                JOptionPane.showMessageDialog(this, "Valor numérico inválido para masa o volumen: " + "Error", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double densidad = masa / volumen;
            txtdensidad.setText(String.valueOf(densidad));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor numérico inválido para masa o volumen: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtdensidad.setText("");
        }
    }

    private void calcularGravedadDesdeCampos() {
        try {
            double masa = Double.parseDouble(txtmasa.getText());
            calcularRadioDesdeCampos();
            double radio = Double.parseDouble(txtRadio.getText());
            if (masa < 0 || radio < 0) {
                JOptionPane.showMessageDialog(this, "Valor numérico inválido para masa o radio: " + "Error", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double g = (CuerpoCeleste.getG() * masa) / Math.pow(radio, 2);
            txtgravedad.setText(String.valueOf(g));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor numérico inválido para masa o radio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtgravedad.setText("");
        }
    }

    private void calcularDuracionDiaDesdeCampos() {
        try {
            double velocidadRotacion = Double.parseDouble(txtVelocidadRotacion.getText());
            calcularCircunferenciaDesdeCampos();
            double circunferencia = Double.parseDouble(txtCircunferencia.getText());
            if (velocidadRotacion < 0 || circunferencia < 0) {
                JOptionPane.showMessageDialog(this, "Valor numérico inválido para velocidad de rotacion o circunferencia: " + "Error", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double duracionDia = circunferencia / velocidadRotacion;
            txtduracionDia.setText(String.valueOf(duracionDia));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor numérico inválido para circunferencia o velocidad de rotación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtduracionDia.setText("");
        }
    }

    private void calcularDuracionAnioDesdeCampos() {
        try {
            double distancia = Double.parseDouble(txtDistanciaSol.getText());
            double velocidadTraslacion = Double.parseDouble(txtVelocidadTraslacion.getText());
            if (distancia < 0 || velocidadTraslacion < 0) {
                JOptionPane.showMessageDialog(this, "Valor numérico inválido para distancia o velocidad de traslacion: " + "Error", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double duracionAnio = distancia / velocidadTraslacion;
            txtduracionAnio.setText(String.valueOf(duracionAnio));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor numérico inválido para distancia o velocidad de traslación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtduracionAnio.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnguardarPlaneta) {
            registrarPlaneta();
            return;
        }
        // Botones individuales de cálculo
        if (e.getSource() == btncalcRadio) {
            calcularRadioDesdeCampos();
            return;
        }
        if (e.getSource() == btnCalcCircunferencia) {
            calcularCircunferenciaDesdeCampos();
            return;
        }
        if (e.getSource() == btnCalcVolumen) {
            calcularVolumenDesdeCampos();
            return;
        }
        if (e.getSource() == btnCalcDensidad) {
            calcularDensidadDesdeCampos();
            return;
        }
        if (e.getSource() == btnCalcGravedad) {
            calcularGravedadDesdeCampos();
            return;
        }
        if (e.getSource() == btnCalcDuracionDia) {
            calcularDuracionDiaDesdeCampos();
            return;
        }
        if (e.getSource() == btnCalcDuracionAnio) {
            calcularDuracionAnioDesdeCampos();
            return;
        }
        // Botón que calcula todos los atributos: invoca todos los cálculos
        if (e.getSource() == btnCalcularAtributos) {
            calcularRadioDesdeCampos();
            calcularCircunferenciaDesdeCampos();
            calcularVolumenDesdeCampos();
            calcularDensidadDesdeCampos();
            calcularGravedadDesdeCampos();
            calcularDuracionDiaDesdeCampos();
            calcularDuracionAnioDesdeCampos();
            return;
        }
        if (e.getSource() == btnAplicarFiltro) {
            Filtro seleccionado = (Filtro) cmfiltro.getSelectedItem();
            List<CuerpoCeleste> combinado = new ArrayList<>();
            combinado.addAll(listaPlanetasRocosos);
            combinado.addAll(listaPlanetasGaseosos);
            if (seleccionado == Filtro.Distancia_del_Sol) {
                Collections.sort(combinado, new ComDistanciaSol());
            } else if (seleccionado == Filtro.Tamaño) {
                Collections.sort(combinado, new ComTamaño());
            }
            // actualizar tabla con la lista ordenada
            actualizarTablaConLista(combinado);
            return;
        }
    }

    private void actualizarTablaConLista(List<CuerpoCeleste> lista) {
        // Esto limpiaria la tabla
        modeloTabla.setRowCount(0);

        for (CuerpoCeleste cuerpoCeleste : lista) {
            if (cuerpoCeleste.getTipo() == TipoPlaneta.Planeta_Rocoso) {
                PlanetaRocoso planeta = (PlanetaRocoso) cuerpoCeleste;
                modeloTabla.addRow(new Object[]{
                    planeta.getNombre(),
                    planeta.getTipo(),
                    planeta.getMasa(),
                    planeta.getDiametro(),
                    planeta.getRadio(),
                    planeta.getVolumen(),
                    planeta.getDensidad(),
                    planeta.getGravedad(),
                    planeta.getDuracionDia(),
                    planeta.getDuracionAnio(),
                    planeta.getDistanciaSol(),
                    planeta.getVelocidadRotacion(),
                    planeta.getVelocidadTraslacion(),
                    planeta.getCantLunas(),
                    planeta.getAnillos(),
                    planeta.getTipoSuperficie(),
                    planeta.isPlacasTectonicas(),
                    "NO APLICA",
                    "NO APLICA"
                });
            } else if (cuerpoCeleste.getTipo() == TipoPlaneta.Planeta_Gaseoso) {
                PlanetaGaseoso planeta = (PlanetaGaseoso) cuerpoCeleste;
                modeloTabla.addRow(new Object[]{
                    planeta.getNombre(),
                    planeta.getTipo(),
                    planeta.getMasa(),
                    planeta.getDiametro(),
                    planeta.getRadio(),
                    planeta.getVolumen(),
                    planeta.getDensidad(),
                    planeta.getGravedad(),
                    planeta.getDuracionDia(),
                    planeta.getDuracionAnio(),
                    planeta.getDistanciaSol(),
                    planeta.getVelocidadRotacion(),
                    planeta.getVelocidadTraslacion(),
                    planeta.getCantLunas(),
                    planeta.getAnillos(),
                    "NO APLICA",
                    "NO APLICA",
                    planeta.getComposicion(),
                    planeta.isTormentaPermanente()
                });
            } else {
                modeloTabla.addRow(new Object[]{
                    cuerpoCeleste.getNombre(), 
                    cuerpoCeleste.getTipo(), 
                    cuerpoCeleste.getMasa(), 
                    cuerpoCeleste.getDiametro(), 
                    cuerpoCeleste.getRadio(), 
                    cuerpoCeleste.getVolumen(), 
                    cuerpoCeleste.getDensidad(), 
                    cuerpoCeleste.getGravedad(), 
                    cuerpoCeleste.getDuracionDia(), 
                    cuerpoCeleste.getDuracionAnio(), 
                    cuerpoCeleste.getDistanciaSol(), 
                    cuerpoCeleste.getVelocidadRotacion(), 
                    cuerpoCeleste.getVelocidadTraslacion(), 
                    cuerpoCeleste.getCantLunas(), 
                    cuerpoCeleste.getAnillos(), 
                    "NO APLICA", 
                    "NO APLICA", 
                    "NO APLICA", 
                    "NO APLICA"
                });
            }
        }
    }
}
