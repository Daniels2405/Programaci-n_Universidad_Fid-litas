/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saladechat.server;
import java.io.*;
import java.net.*;

import com.mycompany.saladechat.server.SaladeChat;

/**
 *
 * @author daniel-2405
 */
public class ClientHandler implements Runnable {
    private Socket connection;
    private PrintWriter out;
    private BufferedReader in;
    private String name;

    public ClientHandler(Socket connection) {
        this.connection = connection;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(connection.getOutputStream(), true);

            out.println("Se ha conectado a la Sala de Chat");
            name = in.readLine();
            String message;
            message = name + "Se ha conectado a la Sala de Chat";
            SaladeChat.broadcast(message, this);
            System.out.println("Bienvenido " + name);

            while ((message = in.readLine()) != null) {
                String messageFormatted = name + ": " + message;
                System.out.println(messageFormatted);
                SaladeChat.broadcast(messageFormatted, this);
            }
        } catch (IOException e) {
            System.out.println("Error al manejar el cliente: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());    
            }
            SaladeChat.removeClient(this); 
        }
    }

    
}
