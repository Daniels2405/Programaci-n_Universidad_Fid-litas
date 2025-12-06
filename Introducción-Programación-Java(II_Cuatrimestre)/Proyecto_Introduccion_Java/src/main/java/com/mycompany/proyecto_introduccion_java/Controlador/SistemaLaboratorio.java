/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_introduccion_java.Controlador;
import java.util.Scanner;
import java.time.LocalDateTime;

import com.mycompany.proyecto_introduccion_java.Clases.*;
/**
 *
 * @author daniel
 */
public class SistemaLaboratorio {
    private String nombreEmpresa;
    private Laboratorio[] laboratorios; //Array de laboratorios en el sistema
    private Paciente[] pacientes; //Array de pacientes en el sistema
    private Medico[] medicos; //Array de medicos en el sistema
    private ParametroReferencia[] parametrosDeReferenciaH; //Objeto que contiene los parametros de referencia
    private ParametroReferencia[] parametrosDeReferenciaM;
    // Contador simple para generar números de orden secuenciales
    private int contadorOrdenes = 1;

    //Constructor
    public SistemaLaboratorio(String nombreEmpresa, Laboratorio[] laboratorios, Paciente[] pacientes, ParametroReferencia[] parametrosDeReferenciaH, ParametroReferencia[] parametrosDeReferenciaM, Medico[] medicos){
        this.nombreEmpresa = nombreEmpresa;
        this.laboratorios = laboratorios;
        this.pacientes = pacientes;
        this.parametrosDeReferenciaH = parametrosDeReferenciaH;
        this.parametrosDeReferenciaM = parametrosDeReferenciaM;
        this.medicos = medicos;
    }
    public SistemaLaboratorio(){}
    
    //Metodos del sistema
    public void mostrarLaboratorios(){ //Metodo para mostrar los laboratorios registrados en el sistema
        for (int i = 0; i < laboratorios.length; i++) {
        Laboratorio labActual = laboratorios[i];
        if (labActual != null) {
            System.out.println("Laboratorio " + (i + 1) + ":");
            System.out.println("Nombre: " + labActual.getNombre());
            System.out.println("Cédula Jurídica: " + labActual.getCedulaJuridica());
            System.out.println("Dirección: " + labActual.getDireccion());
            System.out.println("Teléfono: " + labActual.getTelefono());
            System.out.println("Correo: " + labActual.getCorreo());
            System.out.println();
            }
        } 
    }
    
    //*Metodo para el inicio de sesion
    public boolean Loggin(){ 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario:");
        String userName = scanner.next();
        System.out.print("Ingrese su contraseña:");
        String contrasena = scanner.next();
        // * Se verifica si el usuario y la contraseña son correctos recoriendo el array de medicos
        for (int i = 0; i < medicos.length; i++){
            if (medicos[i] != null && userName.equals(medicos[i].getUserName()) && contrasena.equals(medicos[i].getContrasena())){
                return true;
            }
        }
        return false;
    }

    // ! -------------------------------------Menus del sistema-----------------------------------------------------
    //* ----------------------------------------Menu principal------------------------------------------------------
    public void mostrarMenuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir){
            System.out.println("----Menu Pincipal----");
            System.out.println("1. Menu de Pacientes");
            System.out.println("2. Crear Orden de Prueba de Hematología");
            System.out.println("3. Ingresar resultados de prueba de Hematología");
            System.out.println("4. Generar Reporte de Paciente");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    mostrarMenuPacientes();
                    break;
                case 2:
                    generarOrden();
                    break;
                case 3:
                    generarResultados();
                    break;
                case 4:
                    generarReporte();
                    break;
                case 0: 
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
    //* ------Menu para Pacientes------
    public void mostrarMenuPacientes(){
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while(!salir){
            System.out.println("--- Menú Pacientes ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Consultar paciente");
            System.out.println("3. Modificar paciente");
            System.out.println("4. Eliminar paciente");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    consultarPaciente();
                    break;
                case 3:
                    modificarPaciente();
                    break;
                case 4:
                    eliminarPaciente();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
    //--registrar pacientes--
    public void registrarPaciente(){
        Scanner scanner = new Scanner(System.in);
        boolean repetir = true;
        while (repetir) {
            int cedula = -1;
            boolean cedulaRepetida = true;
            // pedir cédula y validar que no exista
            while (cedulaRepetida) {
                System.out.print("Ingrese la cédula del paciente (0 para cancelar): ");
                cedula = scanner.nextInt();
                if (cedula == 0) {
                    System.out.println("Registro cancelado. Volviendo al menú de pacientes.");
                    return;
                }
                cedulaRepetida = false; 
                if (this.pacientes != null) {
                    for (int j = 0; j < this.pacientes.length; j++) {
                        if (this.pacientes[j] != null && this.pacientes[j].getCedula() == cedula) {
                            cedulaRepetida = true;
                            System.out.println("La cédula ingresada ya está registrada. Ingrese otra cédula o 0 para cancelar.");
                            break;
                        }
                    }
                }
            }
            System.out.print("Ingrese el nombre del paciente: ");
            String nombre = scanner.next();
            System.out.print("Ingrese el primer apellido del paciente: ");
            String primerApellido = scanner.next();
            System.out.print("Ingrese el segundo apellido del paciente: ");
            String segundoApellido = scanner.next();
            System.out.print("Ingrese la edad del paciente: ");
            int edad = scanner.nextInt();
            System.out.print("Ingrese el sexo del paciente (M/F): ");
            char sexo = scanner.next().charAt(0);
            System.out.print("Ingrese el teléfono del paciente: ");
            String telefono = scanner.next();
            System.out.print("Ingrese el correo electrónico del paciente: ");
            String correoElectronico = scanner.next();
            System.out.print("Ingrese la dirección del paciente: ");
            String direccion = scanner.next();

            Paciente nuevoPaciente = new Paciente(cedula, nombre, primerApellido, segundoApellido,
                                                    edad, sexo, telefono, correoElectronico,
                                                    direccion);
            this.setPacientes(nuevoPaciente);
            System.out.println("Paciente registrado exitosamente.");
            System.out.print("Desea registrar otro Paciente (s/n): ");
            char opcionRepetir = scanner.next().charAt(0);
            if (opcionRepetir == 's' || opcionRepetir == 'S') {
                repetir = true;
            } else {
                repetir = false;
            }
        }
    }
    //--Consulta de pacientes--
    public void consultarPaciente(){
        Scanner scanner = new Scanner(System.in);
        
        // Validar que existan pacientes
        boolean existePaciente = false;
        for (int i = 0; i < this.pacientes.length; i++) {
            if (this.pacientes[i] != null) {
                existePaciente = true;
                break;
            }
        }
        if (!existePaciente) {
            System.out.println("No hay pacientes registrados en el sistema. Debe registrar un paciente primero para poder consultarlo.");
            return;
        }
        
        boolean repetir = true;
        while (repetir) {
            System.out.print("Ingrese la cédula del paciente a consultar (0 para salir): ");
            int cedulaConsulta = scanner.nextInt();
            
            // Opción para salir
            if (cedulaConsulta == 0) {
                System.out.println("Saliendo de consulta de pacientes.");
                repetir = false;
                continue;
            }
            
            // Buscar el paciente por cédula
            Paciente pacienteEncontrado = null;
            for (int i = 0; i < pacientes.length; i++) {
                if (pacientes[i] != null && pacientes[i].getCedula() == cedulaConsulta) {
                    pacienteEncontrado = pacientes[i];
                    break;
                }
            }
            
            if (pacienteEncontrado != null) {
                System.out.println("\n--- Información del Paciente ---");
                System.out.println("Cédula: " + pacienteEncontrado.getCedula());
                System.out.println("Nombre: " + pacienteEncontrado.getNombre());
                System.out.println("Primer Apellido: " + pacienteEncontrado.getApellido1());
                System.out.println("Segundo Apellido: " + pacienteEncontrado.getApellido2());
                System.out.println("Edad: " + pacienteEncontrado.getEdad());
                System.out.println("Sexo: " + pacienteEncontrado.getSexo());
                System.out.println("Teléfono: " + pacienteEncontrado.getTelefono());
                System.out.println("Correo Electrónico: " + pacienteEncontrado.getCorreoElectronico());
                System.out.println("Dirección: " + pacienteEncontrado.getDireccion());
                System.out.println("--------------------------------\n");
            } else {
                System.out.println("Paciente con cédula " + cedulaConsulta + " no encontrado.\n");
            }
            
            System.out.print("¿Desea consultar otro paciente? (s/n): ");
            char opcion = scanner.next().charAt(0);
            if (opcion != 's' && opcion != 'S') {
                repetir = false;
            }
        }
    }

    //--Gestion de pacientes--
    public void gestionPacientes(){
        Scanner scanner = new Scanner(System.in);
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Gestión de Pacientes ---");
            System.out.println("1. Modificar paciente");
            System.out.println("2. Eliminar paciente");
            System.out.println("0. Volver");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    modificarPaciente();
                    break;
                case 2:
                    eliminarPaciente();
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /*
     * Para modificar un paciente se pide la cedula del paciente y luego se valida
     * cuando se encuentra se le pide al usuario que coloque cual atributo modificar
     * y pide los datos del atributo, y en todo momento si quiere salir puede colocar 0
     */
    public void modificarPaciente(){
        Scanner scanner = new Scanner(System.in);
        
        // Validar que existan pacientes
        boolean existePaciente = false;
        for (int i = 0; i < this.pacientes.length; i++) {
            if (this.pacientes[i] != null) {
                existePaciente = true;
                break;
            }
        }
        if (!existePaciente) {
            System.out.println("No hay pacientes registrados en el sistema. Debe registrar un paciente primero para poder modificarlo.");
            return;
        }
        
        System.out.print("Ingrese la cédula del paciente a modificar: ");
        int cedula = scanner.nextInt();
        int indice = -1;
        for (int i = 0; i < this.pacientes.length; i++){
            if (this.pacientes[i] != null && this.pacientes[i].getCedula() == cedula){
                indice = i;
                break;
            }
        }
        if (indice == -1){
            System.out.println("Paciente con cédula " + cedula + " no encontrado.");
            return;
        }
        Paciente p = this.pacientes[indice];
        boolean salir = false;
        while (!salir){
            System.out.println("--- Modificar Paciente: " + p.getNombre() + " " + p.getApellido1() + " ---");
            System.out.println("1. Nombre");
            System.out.println("2. Primer apellido");
            System.out.println("3. Segundo apellido");
            System.out.println("4. Edad");
            System.out.println("5. Sexo");
            System.out.println("6. Teléfono");
            System.out.println("7. Correo electrónico");
            System.out.println("8. Dirección");
            System.out.println("0. Salir");
            System.out.print("Seleccione el atributo a modificar: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1:
                    System.out.print("Nuevo nombre: ");
                    p.setNombre(scanner.nextLine());
                    System.out.println("Nombre actualizado.");
                    break;
                case 2:
                    System.out.print("Nuevo primer apellido: ");
                    p.setApellido1(scanner.nextLine());
                    System.out.println("Primer apellido actualizado.");
                    break;
                case 3:
                    System.out.print("Nuevo segundo apellido: ");
                    p.setApellido2(scanner.nextLine());
                    System.out.println("Segundo apellido actualizado.");
                    break;
                case 4:
                    System.out.print("Nueva edad: ");
                    p.setEdad(scanner.nextInt());
                    System.out.println("Edad actualizada.");
                    break;
                case 5:
                    System.out.print("Nuevo sexo (M/F): ");
                    p.setSexo(scanner.next().charAt(0));
                    System.out.println("Sexo actualizado.");
                    break;
                case 6:
                    System.out.print("Nuevo teléfono: ");
                    p.setTelefono(scanner.next());
                    System.out.println("Teléfono actualizado.");
                    break;
                case 7:
                    System.out.print("Nuevo correo electrónico: ");
                    p.setCorreoElectronico(scanner.next());
                    System.out.println("Correo actualizado.");
                    break;
                case 8:
                    System.out.print("Nueva dirección: ");
                    scanner.nextLine();
                    p.setDireccion(scanner.nextLine());
                    System.out.println("Dirección actualizada.");
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo de modificación de paciente.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Eliminar paciente, de igual forma que lo anterior con el numero de cedula
    public void eliminarPaciente(){
        Scanner scanner = new Scanner(System.in);
        
        // Validar que existan pacientes
        boolean existePaciente = false;
        for (int i = 0; i < this.pacientes.length; i++) {
            if (this.pacientes[i] != null) {
                existePaciente = true;
                break;
            }
        }
        if (!existePaciente) {
            System.out.println("No hay pacientes registrados en el sistema. Debe registrar un paciente primero para poder eliminarlo.");
            return;
        }
        
        System.out.print("Ingrese la cédula del paciente a eliminar: ");
        int cedula = scanner.nextInt();
        int indice = -1;
        for (int i = 0; i < this.pacientes.length; i++){
            if (this.pacientes[i] != null && this.pacientes[i].getCedula() == cedula){
                indice = i;
                break;
            }
        }
        if (indice == -1){
            System.out.println("Paciente con cédula " + cedula + " no encontrado.");
            return;
        }
        System.out.println("¿Está seguro de que desea eliminar al paciente " + this.pacientes[indice].getNombre() + " " + this.pacientes[indice].getApellido1() + "? (s/n): ");
        char confirmacion = scanner.next().charAt(0);
        if (confirmacion == 's' || confirmacion == 'S') {
            this.pacientes[indice] = null;
            System.out.println("Paciente eliminado correctamente.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }
    //* ------------------------------Crear ordenes de prueba de Hematologia-----------------------------------------------
    /*
     * Para generar la orden se pide que el usuario ingrese a que paciente se le asignara la orden de pruba
     * luego en que laboratorio se realizara y 
     */
    public void generarOrden(){
        Scanner scanner = new Scanner(System.in);
        
        // Se validara que existan pacientes registrados
        boolean existePaciente = false;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                existePaciente = true;
                break;
            }
        }
        if (!existePaciente) {
            System.out.println("No hay pacientes registrados en el sistema. Registre un paciente primero.");
            return;
        }
        
        // Se muestran los pacientes disponibles
        System.out.println("--- Pacientes Disponibles ---");
        int contadorPacientes = 0;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                System.out.println((contadorPacientes + 1) + ". " + pacientes[i].getNombre() + " " + 
                                   pacientes[i].getApellido1() + " (Cédula: " + pacientes[i].getCedula() + ")");
                contadorPacientes++;
            }
        }
        System.out.print("Seleccione el número del paciente: ");
        int numeroPaciente = scanner.nextInt();
        
        // Validar selección de paciente
        if (numeroPaciente < 1 || numeroPaciente > contadorPacientes) {
            System.out.println("Selección inválida.");
            return;
        }
        
        // Se obtiene el paciente que se selecciono anteriormente
        Paciente pacienteSeleccionado = null;
        int contador = 0;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                contador++;
                if (contador == numeroPaciente) {
                    pacienteSeleccionado = pacientes[i];
                    break;
                }
            }
        }
        
        // Se obtiene el unico medico registrado
        Medico medicoSeleccionado = null;
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null) {
                medicoSeleccionado = medicos[i];
                break;
            }
        }
        if (medicoSeleccionado == null) {
            System.out.println("No hay médicos registrados en el sistema.");
            return;
        }
        
        // Seleccion del laboratorio
        // Se muestran los disponibles
        System.out.println("--- Laboratorios Disponibles ---");
        int contadorLaboratorios = 0;
        for (int i = 0; i < laboratorios.length; i++) {
            if (laboratorios[i] != null) {
                System.out.println((contadorLaboratorios + 1) + ". " + laboratorios[i].getNombre() + 
                                   " (Cédula Jurídica: " + laboratorios[i].getCedulaJuridica() + ")");
                contadorLaboratorios++;
            }
        }
        System.out.print("Seleccione el número del laboratorio: ");
        int numeroLaboratorio = scanner.nextInt();
        
        // Se valida la selección
        if (numeroLaboratorio < 1 || numeroLaboratorio > contadorLaboratorios) {
            System.out.println("Selección inválida.");
            return;
        }
        
        // Obtener laboratorio seleccionado
        Laboratorio laboratorioSeleccionado = null;
        contador = 0;
        for (int i = 0; i < laboratorios.length; i++) {
            if (laboratorios[i] != null) {
                contador++;
                if (contador == numeroLaboratorio) {
                    laboratorioSeleccionado = laboratorios[i];
                    break;
                }
            }
        }
        
        // Generar número de orden único (secuencial)
        int numeroOrden = contadorOrdenes++;
        
        // Crear orden con fecha actual
        OrdenDePrueba nuevaOrden = new OrdenDePrueba(numeroOrden, java.time.LocalDateTime.now());
        // Guardar la orden en el paciente
        pacienteSeleccionado.setOrden(nuevaOrden);

        // Mostrar resumen de la orden
        System.out.println("========== ORDEN DE PRUEBA GENERADA ==========");
        System.out.println("Número de Orden: " + nuevaOrden.getnOrden());
        System.out.println("Fecha: " + nuevaOrden.getFecha());
        System.out.println("Paciente: " + pacienteSeleccionado.getNombre() + " " + pacienteSeleccionado.getApellido1());
        System.out.println("Médico: " + medicoSeleccionado.getNombre() + " " + medicoSeleccionado.getApellido1());
        System.out.println("Laboratorio: " + laboratorioSeleccionado.getNombre());
        System.out.println("Tipo de Prueba: Hematología Completa");
        System.out.println("============================================");
        System.out.println("Orden de prueba creada y asignada al paciente exitosamente.");
    }

    //* --------------------------------Ingresar Resultados de Hematologia--------------------------------
    public void generarResultados(){
        Scanner scanner = new Scanner(System.in);
        // Se valida que existan pacientes como se ha realizado en otros metodos
        boolean existePaciente = false;
        for (int i = 0; i < this.pacientes.length; i++) {
            if (this.pacientes[i] != null) { 
                existePaciente = true; 
                break; 
            }
        }
        if (!existePaciente) {
            System.out.println("No hay pacientes registrados en el sistema.");
            return;
        }

        // Se pide al usuario que seleccione el paciente
        System.out.println("--- Pacientes Disponibles ---");
        int contadorPacientes = 0;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                contadorPacientes++;
                System.out.println(contadorPacientes + ". " + pacientes[i].getNombre() + " " + pacientes[i].getApellido1() + " (Céd: " + pacientes[i].getCedula() + ")");
            }
        }
        System.out.print("Seleccione el número del paciente para ingresar resultados: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > contadorPacientes) {
            System.out.println("Selección inválida.");
            return;
        }
        Paciente paciente = null;
        int contador = 0;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                contador++;
                if (contador == seleccion) { paciente = pacientes[i]; break; }
            }
        }

        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // Se verifica que el paciente tenga una orden para la prueba asignada
        if (paciente.getOrden() == null) {
            System.out.println("El paciente no tiene una orden de prueba asignada. Genere una orden primero.");
            return;
        }

        // Selecciona parámetros de referencia según sexo
        ParametroReferencia[] parametros;
        char sexo = Character.toUpperCase(paciente.getSexo());
        if (sexo == 'M') {
            parametros = this.parametrosDeReferenciaH;
        }else {
            parametros = this.parametrosDeReferenciaM;
        }

        // Ingresar resultados manualmente
        ResultadoParametro[] resultados = new ResultadoParametro[parametros.length];
        System.out.println("Ingrese los resultados de la prueba (Hematología completa):");
        for (int i = 0; i < parametros.length; i++) {
            ParametroReferencia p = parametros[i];
            System.out.print(p.getNombre() + " (" + p.getUnidad() + ") - Valor: ");
            double valor = scanner.nextDouble();
            ResultadoParametro rp = new ResultadoParametro(p, valor);
            // Calcula alarma según valor y rango
            rp.setAlarma(null);
            resultados[i] = rp;
        }

        System.out.print("Observaciones (enter para omitir): ");
        String observaciones = scanner.nextLine();

        // Se crea la prueba de Hematologia
        PruebaHematologia prueba = new PruebaHematologia(paciente.getOrden(), resultados, observaciones, java.time.LocalDateTime.now());

        // Guarda la prueba en el paciente
        if (paciente.getPruebasHematologia() == null) {
            paciente.setPruebasHematologia(new PruebaHematologia[10]);
        }
        boolean guardado = false;
        for (int i = 0; i < paciente.getPruebasHematologia().length; i++) {
            if (paciente.getPruebasHematologia()[i] == null) {
                paciente.getPruebasHematologia()[i] = prueba;
                guardado = true;
                break;
            }
        }
        if (!guardado) {
            System.out.println("No se pudo guardar la prueba: espacio insuficiente en el paciente.");
            return;
        }

        System.out.println("Prueba de hematología registrada exitosamente.");
    }

    //* ---------------------------------------Generar Reporte------------------------------------------------
    public void generarReporte(){
        Scanner scanner = new Scanner(System.in);
        // Validacion de pacientes
        boolean existePaciente = false;
        for (int i = 0; i < this.pacientes.length; i++) {
            if (this.pacientes[i] != null) { 
                existePaciente = true; 
                break; 
            }
        }
        if (!existePaciente) {
            System.out.println("No hay pacientes registrados en el sistema.");
            return;
        }

        // Solicita la cédula del paciente
        System.out.print("Ingrese la cédula del paciente para ver el reporte: ");
        int cedula = scanner.nextInt();

        // Busca el paciente por cédula, si no se encuentra devuelve el programa
        Paciente paciente = null;
        for (int i = 0; i < this.pacientes.length; i++) {
            if (this.pacientes[i] != null && this.pacientes[i].getCedula() == cedula) {
                paciente = this.pacientes[i];
                break;
            }
        }
        if (paciente == null) {
            System.out.println("Paciente con cédula " + cedula + " no encontrado.");
            return;
        }
        // Verifica que el paciente tenga pruebas hematológicas
        if (paciente.getPruebasHematologia() == null) {
            System.out.println("El paciente no tiene pruebas de hematología registradas.");
            return;
        }
        boolean existePrueba = false;
        for (int i = 0; i < paciente.getPruebasHematologia().length; i++) {
            if (paciente.getPruebasHematologia()[i] != null) {
                existePrueba = true;
                break;
            }
        }
        if (!existePrueba) {
            System.out.println("El paciente no tiene pruebas de hematología registradas.");
            return;
        }

        // Se revisa si el paciente tiene más de una prueba y le solicita al usuario que seleccione cual es la prueba que requiere 
        System.out.println("--- Pruebas de Hematología Disponibles ---");
        int contadorPruebas = 0;
        for (int i = 0; i < paciente.getPruebasHematologia().length; i++) {
            if (paciente.getPruebasHematologia()[i] != null) {
                contadorPruebas++;
                PruebaHematologia p = paciente.getPruebasHematologia()[i];
                System.out.println(contadorPruebas + ". Orden #" + p.getOrden().getnOrden() + " - Fecha: " + p.getFechaRealizacion());
            }
        }
        System.out.print("Seleccione el número de la prueba a reportar: ");
        int sel = scanner.nextInt();
        if (sel < 1 || sel > contadorPruebas) {
            System.out.println("Selección inválida.");
            return;
        }

        // Obtiene la prueba seleccionada
        PruebaHematologia prueba = null;
        int c = 0;
        for (int i = 0; i < paciente.getPruebasHematologia().length; i++) {
            if (paciente.getPruebasHematologia()[i] != null) {
                c++;
                if (c == sel) {
                    prueba = paciente.getPruebasHematologia()[i];
                    break;
                }
            }
        }
        if (prueba == null) {
            System.out.println("Prueba no encontrada.");
            return;
        }

        // * -------------------Genera el Reporte--------------------------
        System.out.println("===== REPORTE DE HEMATOLOGÍA =====");
        System.out.println("Empresa: " + this.nombreEmpresa);
        System.out.println("Paciente: " + paciente.getNombre() + " " + paciente.getApellido1() + " (Céd: " + paciente.getCedula() + ")");
        System.out.println("Número de Orden: " + prueba.getOrden().getnOrden());
        System.out.println("Fecha de Toma: " + prueba.getFechaRealizacion());
        System.out.println("Médico responsable: ");
        Medico med = null;
        for (int i = 0; i < this.medicos.length; i++) { 
            if (this.medicos[i] != null) { 
                med = this.medicos[i]; 
                break; 
            } 
        }
        if (med != null) {
            System.out.println(med.getNombre() + " " + med.getApellido1());
        }
        System.out.println("----------------------------------");
        System.out.printf("%-25s %-10s %-15s %-15s\n","Parametro","Valor","Rango","Alarma");
        ResultadoParametro[] resultados = prueba.getResultados();
        for (int i = 0; i < resultados.length; i++) {
            ResultadoParametro r = resultados[i];
            String alarma;
            if (r.getAlarma() == null) {
                alarma = "OK";
            } else {
                alarma = r.getAlarma();
            }
            ParametroReferencia pr = r.getParametro();
            String rango = pr.getRangoLow() + " - " + pr.getRangoHigh() + " " + pr.getUnidad();
            System.out.printf("%-25s %-10.2f %-15s %-15s\n", pr.getNombre(), r.getValor(), rango, alarma);
        }
        System.out.println("----------------------------------");
        String observaciones = prueba.getObservaciones();
        if (observaciones != null && !observaciones.isEmpty()) System.out.println("Observaciones: " + observaciones);
        System.out.println("===== FIN DEL REPORTE =====\n");
    }

    //Getters y setters
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public Laboratorio[] getLaboratorios() {
        return laboratorios;
    }
    public void setLaboratorios(Laboratorio laboratorio){ //Se modifica el setter para agregar laboratorios al array
        for(int i = 0; i < this.laboratorios.length; i++){
            if(this.laboratorios[i] == null){
                this.laboratorios[i] = laboratorio;
                break;
            }
        }
    }
    public Paciente[] getPacientes() {
        return pacientes;
    }
    public void setPacientes(Paciente paciente) { //Tambien se modifica el setter para agregar pacientes al array
        for (int i = 0; i < this.pacientes.length; i++) {
            if (this.pacientes[i] == null) {
                this.pacientes[i] = paciente;
                break;
            }
        }
    }
    // Parámetros de referencia para hombres
    public ParametroReferencia[] getParametrosDeReferenciaH() {
        return parametrosDeReferenciaH;
    }
    public void setParametrosDeReferenciaH(ParametroReferencia[] parametrosDeReferenciaH) {
        this.parametrosDeReferenciaH = parametrosDeReferenciaH;
    }

    // Parámetros de referencia para mujeres
    public ParametroReferencia[] getParametrosDeReferenciaM() {
        return parametrosDeReferenciaM;
    }
    public void setParametrosDeReferenciaM(ParametroReferencia[] parametrosDeReferenciaM) {
        this.parametrosDeReferenciaM = parametrosDeReferenciaM;
    }
    public Medico[] getMedicos() {
        return medicos;
    }
    public void setMedicos(Medico medico) { //Ademas se modifica el setter para agregar medicos al array
        for (int i = 0; i < this.medicos.length; i++) {
            if (this.medicos[i] == null){
                this.medicos[i] = medico;
                break;
            }
        }
    }
    
}
