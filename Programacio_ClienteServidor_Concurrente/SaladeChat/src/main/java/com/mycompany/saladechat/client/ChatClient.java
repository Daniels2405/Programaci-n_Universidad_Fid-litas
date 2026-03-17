/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saladechat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;


/**
 *
 * @author daniel-2405
 */
public class ChatClient {
    private Socket connection;
    private PrintWriter out;
    private BufferedReader in;
    private JTextArea chatArea;
    private JTextField inputField;
    private JFrame frame;
    private String userName;

    public ChatClient(String host, int port) {
        requestUserName();
        createGUI();
        connectToServer(host, port);
    }




    private void requestUserName(){
        userName = JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario", "Nombre de usuario", JOptionPane.PLAIN_MESSAGE);
        if(userName == null || userName.trim().isEmpty()){
            userName = "Invitado" + ((int)(Math.random() * 100));
        }
    }

    private void createGUI() {
        frame = new JFrame("Sala de Chat - " + userName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        chatArea = new JTextArea();
        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        inputField = new JTextField();
        frame.add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(e -> sendMessage());
        frame.setVisible(true);
    }

    private void connectToServer(String host, int port) {
        try {
            connection = new Socket(host, port);
            out = new PrintWriter(connection.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String firstLine = in.readLine();
            if (firstLine == null) {
                JOptionPane.showMessageDialog(frame, "Conexion por el servidor", "Conexion", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (firstLine.equals("Maximo de clientes alcanzado. Rechazando coneccion.")) {
                JOptionPane.showMessageDialog(frame, firstLine, "Sala de Chat", JOptionPane.WARNING_MESSAGE);
                closeAndExit();
                return;
            }else{
                SwingUtilities.invokeLater(() -> chatArea.append("\n" + firstLine));
                out.println(userName);
            }

            new Thread(()-> {
                try {
                    String message;
                    while((message = in.readLine()) != null){
                        final String messageFinal = message;
                        SwingUtilities.invokeLater(() -> chatArea.append("\n" + messageFinal));
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(frame, e.getMessage(), "Sala de Chat", JOptionPane.ERROR_MESSAGE);
                }
            }).start();;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Sala de Chat", JOptionPane.ERROR_MESSAGE);
            closeAndExit();
        }
    }

    private void sendMessage(){
        String message = inputField.getText();
        if(out == null){
            JOptionPane.showMessageDialog(frame, "No conectado al servidor", "Error al enviar mensaje", JOptionPane.ERROR_MESSAGE);
            return;
        }
        out.println(message);
        chatArea.append("\n" + userName + ": " + message);
        inputField.setText("");
    }

    private void closeAndExit() {
        try { if(out != null) out.close(); } catch (Exception e) {}
        try { if(in != null) in.close(); } catch (Exception e) {}
        try { if(connection != null) connection.close(); } catch (Exception e) {}
        SwingUtilities.invokeLater(() -> frame.dispose());
    }

    public static void main(String[] args) {
        JTextField hostField = new JTextField("127.0.0.1");
        JTextField portField = new JTextField("5000");

        JPanel panel = new JPanel(new GridLayout(2,2,5,5));
        panel.add(new JLabel("Host:"));
        panel.add(hostField);
        panel.add(new JLabel("Puerto:"));
        panel.add(portField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Ingrese los datos del servidor", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.OK_OPTION){
            String host = hostField.getText();
            int port;
            try {
                port = Integer.parseInt(portField.getText());
                new ChatClient(host, port);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}
