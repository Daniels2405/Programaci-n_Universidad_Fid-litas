package com.mycompany.clase01.controllers;

import com.mycompany.clase01.models.Cliente;
import com.mycompany.clase01.models.ComparatorCliente;
import com.mycompany.clase01.models.FileException;
import com.mycompany.clase01.models.Direccion;
import com.mycompany.clase01.models.Genero;
import com.mycompany.clase01.views.RegistroClientesGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ClienteController {
    private RegistroClientesGUI clientsView;
    private int indiceEdicion = -1;

    public ClienteController(RegistroClientesGUI clientsView) {
        this.clientsView = clientsView;
        initActions();
    }

    private void initActions() {
        this.clientsView.btnRegistrar.addActionListener(e -> RegistrarCliente());
        this.clientsView.btnActualizar.addActionListener(e -> actualizarCliente());
        this.clientsView.btnEliminar.addActionListener(e -> eliminarCliente());
        ListenerTable();
        ListenerTableDoubleClick();

        try {
            cargarClientes(this.clientsView.ARCHIVO_CLIENTES);
        } catch (FileException e) {
            JOptionPane.showMessageDialog(this.clientsView,
                    e.getMessage(),
                    "Error - Formulario Clientes",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void RegistrarCliente() {
        try {
            this.clientsView.clientes.add(LeerClienteFormulario());
            actualizarTabla(this.clientsView.clientes);
            guardarCliente(this.clientsView.ARCHIVO_CLIENTES, this.clientsView.clientes);
            JOptionPane.showMessageDialog(this.clientsView,
                    "Cliente registrado correctamente",
                    "Formulario Clientes",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (FileException e) {
            JOptionPane.showMessageDialog(this.clientsView,
                    e.getMessage(),
                    "Error - Formulario Clientes",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.clientsView,
                    e.getMessage(),
                    "Error - Formulario Clientes",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void guardarCliente(String NombreArchivo, List<Cliente> pClientes) throws FileException {
        try (ObjectOutputStream objSalida = new ObjectOutputStream(new FileOutputStream(NombreArchivo))) {
            objSalida.writeObject(pClientes);
        } catch (IOException ex) {
            throw new FileException(ex.getMessage());
        }
    }

    private void cargarClientes(String NombreArchivo) throws FileException {
        try (ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream(NombreArchivo))) {
            List<Cliente> clientesExistentes = (List<Cliente>) objEntrada.readObject();
            for (Cliente registro : clientesExistentes) {
                this.clientsView.modeloTabla.addRow(new Object[]{
                    registro.getIdPersona(),
                    registro.getNombreCompleto(),
                    registro.getFechaNacimiento().toString(),
                    registro.getGenero(),
                    registro.getIdCliente(),
                    registro.getMembresia(),
                    registro.getPuntos(),
                    registro.getLimiteCredito()
                });
            }
            this.clientsView.clientes.addAll(clientesExistentes);
        } catch (IOException ex) {
            throw new FileException(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new FileException(ex.getMessage());
        }
    }

    private void limpiarCampos() {
        this.clientsView.txtidPersona.setText("");
        this.clientsView.txtNombreCompleto.setText("");
        this.clientsView.txtFechaNacimiento.setText("");
        this.clientsView.txtidCliente.setText("");
        this.clientsView.txtMembresia.setText("");
        this.clientsView.txtPuntos.setText("");
        this.clientsView.txtLimiteCredito.setText("");
        this.clientsView.cmbGenero.setSelectedIndex(0);
        // Habilitar/Deshabilitar botones
        this.clientsView.btnRegistrar.setEnabled(true);
        this.clientsView.btnActualizar.setEnabled(false);
        this.clientsView.btnEliminar.setEnabled(false);
    }

    private void actualizarTabla(List<Cliente> pClientes) {
        this.clientsView.modeloTabla.setRowCount(0);
        for (Cliente registro : pClientes) {
            this.clientsView.modeloTabla.addRow(new Object[]{
                registro.getIdPersona(),
                registro.getNombreCompleto(),
                registro.getFechaNacimiento().toString(),
                registro.getGenero(),
                registro.getIdCliente(),
                registro.getMembresia(),
                registro.getPuntos(),
                registro.getLimiteCredito()
            });
        }
    }

    private Cliente LeerClienteFormulario() {
        String idPersona = this.clientsView.txtidPersona.getText();
        String NombreCompleto = this.clientsView.txtNombreCompleto.getText();
        Date fechaNaci = Date.valueOf(this.clientsView.txtFechaNacimiento.getText());
        String genero = ((Genero) this.clientsView.cmbGenero.getSelectedItem()).toString();
        int idCliente = Integer.parseInt(this.clientsView.txtidCliente.getText());
        String Membresia = this.clientsView.txtMembresia.getText();
        int puntos = Integer.parseInt(this.clientsView.txtPuntos.getText());
        double limite = Double.parseDouble(this.clientsView.txtLimiteCredito.getText());

        Direccion direccionCliente = new Direccion();
        Cliente oCliente = new Cliente();
        oCliente.setIdPersona(idPersona);
        oCliente.setNombreCompleto(NombreCompleto);
        oCliente.setFechaNacimiento(fechaNaci);
        oCliente.setGenero(genero);
        oCliente.setIdCliente(idCliente);
        oCliente.setMembresia(Membresia);
        oCliente.setPuntos(puntos);
        oCliente.setLimiteCredito(limite);
        return oCliente;
    }

    private void cargarClienteFormulario(int fila) {
        if (fila < 0 || fila >= this.clientsView.clientes.size()) return;

        Cliente c = this.clientsView.clientes.get(fila);
        this.clientsView.txtidPersona.setText(c.getIdPersona());
        this.clientsView.txtNombreCompleto.setText(c.getNombreCompleto());
        this.clientsView.txtFechaNacimiento.setText(c.getFechaNacimiento().toString());
        this.clientsView.txtidCliente.setText(String.valueOf(c.getIdCliente()));
        this.clientsView.txtMembresia.setText(c.getMembresia());
        this.clientsView.txtPuntos.setText(String.valueOf(c.getPuntos()));
        this.clientsView.txtLimiteCredito.setText(String.valueOf(c.getLimiteCredito()));
        seleccionarGenero(c.getGenero());
        // Habilitar/Deshabilitar botones
        this.clientsView.btnRegistrar.setEnabled(false);
        this.clientsView.btnActualizar.setEnabled(true);
        this.clientsView.btnEliminar.setEnabled(true);
    }

    private void seleccionarGenero(String pGenero) {
        for (int i = 0; i < this.clientsView.cmbGenero.getItemCount(); i++) {
            Object item = this.clientsView.cmbGenero.getItemAt(i);
            if (item != null && item.toString().equals(pGenero)) {
                this.clientsView.cmbGenero.setSelectedIndex(i);
                return;
            }
        }
    }

    private void ListenerTable() {
        this.clientsView.tablaCliente.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int col = clientsView.tablaCliente.columnAtPoint(evt.getPoint());
                String nombreColumna = clientsView.tablaCliente.getColumnName(col);
                ordenarColumna(nombreColumna);
            }
        });
    }

    private void ordenarColumna(String nombreColumna) {
        switch (nombreColumna) {
            case "NombreCompleto":
                ordenarPorNombre(this.clientsView.clientes);
                break;
            case "NumeroCliente":
                ordenarPorIdCliente(this.clientsView.clientes);
                break;
            case "Puntos":
                ordenarPorPuntos(this.clientsView.clientes);
                break;
            case "LimiteCredito":
                ordenarPorLimite(this.clientsView.clientes);
                break;
            default:
                break;
        }
    }

    private void ordenarPorIdCliente(List<Cliente> pClientes) {
        pClientes.sort(null);
        actualizarTabla(pClientes);
    }

    private void ordenarPorNombre(List<Cliente> pClientes) {
        pClientes.sort(new ComparatorCliente.ComparadorPorNombre());
        actualizarTabla(pClientes);
    }

    private void ordenarPorPuntos(List<Cliente> pClientes) {
        pClientes.sort(new ComparatorCliente.ComparadorPorPuntos());
        actualizarTabla(pClientes);
    }

    private void ordenarPorLimite(List<Cliente> pClientes) {
        pClientes.sort(new ComparatorCliente.ComparadorPorLimite());
        actualizarTabla(pClientes);
    }

    private void ListenerTableDoubleClick() {
        this.clientsView.tablaCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2 && clientsView.tablaCliente.getSelectedRow() != -1) {
                    int filaTabla = clientsView.tablaCliente.getSelectedRow();
                    int filaModelo = clientsView.tablaCliente.convertRowIndexToModel(filaTabla);
                    cargarClienteFormulario(filaModelo);
                    indiceEdicion = filaModelo;
                }
            }
        });
    }

    private void actualizarCliente() {
        try {
            if (indiceEdicion == -1 && this.clientsView.tablaCliente.getSelectedRow() != -1) {
                int filaTabla = clientsView.tablaCliente.getSelectedRow();
                indiceEdicion = clientsView.tablaCliente.convertRowIndexToModel(filaTabla);
            }
            if (indiceEdicion < 0 || indiceEdicion >= this.clientsView.clientes.size()) {
                JOptionPane.showMessageDialog(this.clientsView,
                        "Seleccione un cliente con doble click",
                        "Formulario Clientes",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            Cliente clienteActualizado = LeerClienteFormulario();
            this.clientsView.clientes.set(indiceEdicion, clienteActualizado);
            actualizarTabla(this.clientsView.clientes);
            guardarCliente(this.clientsView.ARCHIVO_CLIENTES, this.clientsView.clientes);
            JOptionPane.showMessageDialog(this.clientsView,
                    "Cliente actualizado con exito",
                    "Formulario Cliente",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            indiceEdicion = -1;
        } catch (FileException e) {
            JOptionPane.showMessageDialog(this.clientsView,
                    "Error al actualizar Cliente: " + e.getMessage(),
                    "Error - Formulario Cliente",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.clientsView,
                    "Error al actualizar Cliente: " + e.getMessage(),
                    "Error - Formulario Cliente",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarCliente() {
        try {
            if (indiceEdicion == -1 && this.clientsView.tablaCliente.getSelectedRow() != -1) {
                int filaTabla = clientsView.tablaCliente.getSelectedRow();
                indiceEdicion = clientsView.tablaCliente.convertRowIndexToModel(filaTabla);
            }
            if (indiceEdicion < 0 || indiceEdicion >= this.clientsView.clientes.size()) {
                JOptionPane.showMessageDialog(this.clientsView,
                        "Seleccione un cliente con doble click",
                        "Formulario Clientes",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            int ok = JOptionPane.showConfirmDialog(this.clientsView,
                    "¿Desea eliminar al cliente seleccionado?",
                    "Confirmar eliminación - Formulario Clientes",
                    JOptionPane.YES_NO_OPTION);
            if (ok != JOptionPane.YES_OPTION) return;

            this.clientsView.clientes.remove(indiceEdicion);
            actualizarTabla(this.clientsView.clientes);
            guardarCliente(this.clientsView.ARCHIVO_CLIENTES, this.clientsView.clientes);
            JOptionPane.showMessageDialog(this.clientsView,
                    "Cliente eliminado con exito",
                    "Formulario Cliente",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            indiceEdicion = -1;
        } catch (FileException e) {
            JOptionPane.showMessageDialog(this.clientsView,
                    "Error al eliminar Cliente: " + e.getMessage(),
                    "Error - Formulario Cliente",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.clientsView,
                    "Error al eliminar Cliente: " + e.getMessage(),
                    "Error - Formulario Cliente",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}