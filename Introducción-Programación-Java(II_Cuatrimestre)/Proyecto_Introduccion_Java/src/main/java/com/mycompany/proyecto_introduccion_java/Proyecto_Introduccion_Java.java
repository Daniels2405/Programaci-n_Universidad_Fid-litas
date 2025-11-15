/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_introduccion_java;
import com.mycompany.proyecto_introduccion_java.Clases.*;
import com.mycompany.proyecto_introduccion_java.Controlador.SistemaLaboratorio;
/**
 *
 * @author daniel
 */
public class Proyecto_Introduccion_Java {

    public static void main(String[] args) {
        /*
         * ----------------------- Configuracion inicial -----------------------
         */
        //Se crea el sistema de laboratorio
        // Se crean arrays de parámetros de referencia para Hombres y Mujeres 
        ParametroReferencia[] parametrosH = new ParametroReferencia[12];
        ParametroReferencia[] parametrosM = new ParametroReferencia[12];
        parametrosH[0] = new ParametroReferencia("Hemoglobina", "g/dL", 17.5, 13.5);
        parametrosM[0] = new ParametroReferencia("Hemoglobina", "g/dL", 15.5, 12.0);
        parametrosH[1] = new ParametroReferencia("Hematocrito", "%", 50.0, 38.8);
        parametrosM[1] = new ParametroReferencia("Hematocrito", "%", 44.5, 34.9);
        parametrosH[2] = new ParametroReferencia("Eritrocitos (RBC)", "10^6/µL", 6.1, 4.7);
        parametrosM[2] = new ParametroReferencia("Eritrocitos (RBC)", "10^6/µL", 5.4, 4.2);
        parametrosH[3] = new ParametroReferencia("Leucocitos (WBC)", "10^3/µL", 11.0, 4.0);
        parametrosM[3] = new ParametroReferencia("Leucocitos (WBC)", "10^3/µL", 11.0, 4.0);
        parametrosH[4] = new ParametroReferencia("Plaquetas", "10^3/µL", 450.0, 150.0);
        parametrosM[4] = new ParametroReferencia("Plaquetas", "10^3/µL", 450.0, 150.0);
        parametrosH[5] = new ParametroReferencia("VCM (MCV)", "fL", 100.0, 80.0);
        parametrosM[5] = new ParametroReferencia("VCM (MCV)", "fL", 100.0, 80.0);
        parametrosH[6] = new ParametroReferencia("HCM (MCH)", "pg", 33.0, 27.0);
        parametrosM[6] = new ParametroReferencia("HCM (MCH)", "pg", 33.0, 27.0);
        parametrosH[7] = new ParametroReferencia("CHCM (MCHC)", "g/dL", 36.0, 32.0);
        parametrosM[7] = new ParametroReferencia("CHCM (MCHC)", "g/dL", 36.0, 32.0);
        parametrosH[8] = new ParametroReferencia("RDW", "%", 14.5, 11.5);
        parametrosM[8] = new ParametroReferencia("RDW", "%", 14.5, 11.5);
        parametrosH[9] = new ParametroReferencia("Neutrófilos", "%", 70.0, 40.0);
        parametrosM[9] = new ParametroReferencia("Neutrófilos", "%", 70.0, 40.0);
        parametrosH[10] = new ParametroReferencia("Linfocitos", "%", 40.0, 20.0);
        parametrosM[10] = new ParametroReferencia("Linfocitos", "%", 40.0, 20.0);
        parametrosH[11] = new ParametroReferencia("Monocitos", "%", 10.0, 2.0);
        parametrosM[11] = new ParametroReferencia("Monocitos", "%", 10.0, 2.0);
        SistemaLaboratorio SistemaCPV = new SistemaLaboratorio(
            "CPV Labs",
            new Laboratorio[10],
            new Paciente[100],
            parametrosH,
            parametrosM,
            new Medico[10]);
        //Se crean los laboratorios y se agregan al sistema
        Laboratorio lab1 = new Laboratorio(
            "Lab Central", 
            "3-101-458962", 
            "200 metros al sur de la plaza de Mercedes norte", 
            "8892-2334",
            "CPVCentral@CPVCR.com");
        Laboratorio lab2 = new Laboratorio(
            "Lab Alajuela",
            "3-102-458963",
            "300 metros al este del parque central de Alajuela",
            "2431-5678",
            "CPVAlajuela@CPVCR.com"
            );
        SistemaCPV.setLaboratorios(lab1);
        SistemaCPV.setLaboratorios(lab2);
        //Se ingresa al sistema un medico que sera el usuario que utilizara el sistema
        Medico medico1 = new Medico(
            "1-2345-6789",
            "Daniel",
            "Ramirez", 
            "Lopez",
            "dramirez",  // !Este es el username que se utilizara para el login
            "contrasena123", // !Esta es la contrasena que se utilizara para el login
            "8888-7777",
            "dramirez6789@CPVCR.com"
            );
        SistemaCPV.setMedicos(medico1);
        //--------------------------------------------------------------------------------------------
        // -------------------------------------------------------------------------------------------
        /*
         * ----------------------- Aqui inicia el programa -----------------------
         */
        System.out.println("-------------Bienvenido al sistema de laboratorios " + SistemaCPV.getNombreEmpresa() + "-------------");
        //Se muestra el inicio de sesion
        int intentos = 0;
        boolean acceso = false;
        while (intentos < 3 && !acceso) {
            acceso = SistemaCPV.Loggin();
            if (!acceso) {
                intentos++;
                System.out.println("Credenciales incorrectas. Intento " + intentos + " de 3.");
            }
        }
        if (!acceso){
            System.out.println("Ha excedido el número máximo de intentos. Saliendo del sistema.");
            System.exit(0);
        }
        
    System.out.println("|-------Inicio de sesión exitoso. Bienvenido al sistema.-------|");
    // Se inicia el programa con un menú principal que ejecuta el sistema del laboratorio
    SistemaCPV.mostrarMenuPrincipal();
    // Cuando en el menu principal el usuario decida cerrar el programa terminara de ejecutarse
    System.out.println("Saliendo del sistema. Hasta luego.");
    System.exit(0);

    }
}
