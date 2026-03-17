/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.saladechat.server;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;



/**
 *
 * @author daniel-2405
 */
public class SaladeChat {
    private static final int PORT = 5000;
    private static final int MAX_CLIENTS = 30;
    private static Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();
    
    

    public static void main(String[] args) {
        System.out.println("Servidor iniciado en el puerto: " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket connectionClient = serverSocket.accept();
                if(clients.size() < MAX_CLIENTS){
                    ClientHandler clientHandler = new ClientHandler(connectionClient);
                    clients.add(clientHandler);
                    new Thread(clientHandler).start();
                } else{
                    System.out.println("Maximo de clientes alcanzado. Rechazando coneccion.");
                    try(PrintWriter tempOut = new PrintWriter(connectionClient.getOutputStream(),true)){
                        tempOut.println("Maximo de clientes alcanzado. Rechazando coneccion.");
                    } catch (IOException e){
                        System.out.println("Error al rechazar la coneccion: " + e.getMessage());
                    }
                    connectionClient.close();
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }

    public static void broadcast(String message, ClientHandler sender){
        for(ClientHandler client : clients){
            if(client != sender){
                client.sendMessage(message);
            }
        }
    }

    public static void removeClient(ClientHandler client){
        String message = client.getName() + "Se ha desconectado.";
        clients.remove(client);
        System.out.println(message);
        broadcast(message, client);
    }
}
