package com.mycompany.practicaevaluada3;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
public class PracticaEvaluada3 {
    public static void main(String[] args) {
        //Ejercicio 1 – Arreglo Unidimensional
        Scanner scanner = new Scanner(System.in);
        /* 
        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamaño = scanner.nextInt();
        Temperatura[] arrTemperaturas = new Temperatura[tamaño];
        //Llenar el arreglo 
        for (int i = 0; i < arrTemperaturas.length; i++){
            //Solicitar los datos al usuario
            System.out.println("Registro #" + (i+1));
            System.out.print("Ingrese la ciudad:");
            String ciudad = scanner.next();
            System.out.println("");
            System.out.print("Ingrese el día; ");
            String dia = scanner.next();
            System.out.println("");
            System.out.print("Ingrese el mes: ");
            String mes = scanner.next();
            System.out.println("");
            System.out.print("Ingrese el año:");
            int año = scanner.nextInt();
            System.out.println("");
            System.out.print("Ingrese la temperatura máxima: ");
            double tempMax = scanner.nextDouble();
            System.out.println("");
            System.out.print("Ingrese la temperatura mínima: ");
            double tempMin = scanner.nextDouble();
            double temProm = (tempMax + tempMin) / 2;
            System.out.println("");
            System.out.print("Ingrese la sensación térmica: ");
            double sensacionTermica = scanner.nextDouble();
            System.out.println("");
            System.out.print("Ingrese la humedad: ");
            int humedad = scanner.nextInt();
            System.out.println("");
            System.out.print("Ingrese la probabilidad de lluvia: ");
            int probabilidadLluvia = scanner.nextInt();
            System.out.println("");
            System.out.print("Ingrese la velocidad del viento: ");
            int velViento = scanner.nextInt();
            System.out.println("");
            System.out.print("Ingrese la condición del clima: ");
            String condicionClima = scanner.next();
            System.out.println("-------------------------------");

            //Crear un objeto temperatura
            Temperatura temp = new Temperatura();
            temp.setCiudad(ciudad);
            temp.setDía(dia);
            temp.setMes(mes);
            temp.setAño(año);
            temp.setTempMax(tempMax);
            temp.setTemMin(tempMin);
            temp.setTemProm(temProm);
            temp.setSensacionTermica(sensacionTermica);
            temp.setHumedad(humedad);
            temp.setProbabilidadLluvia(probabilidadLluvia);
            temp.setVelViento(velViento);
            temp.setCondicionClima(condicionClima);
            
            //Almacenar el objeto en el arreglo
            arrTemperaturas[i] = temp;
        }

        //Mostrar los datos almacenados en el arreglo
        System.out.println("Se mostraran los datos dentro del arreglo");
        for (int i = 0; i < arrTemperaturas.length; i++){
            System.out.println("Registro #" + (i+1));
            System.out.println("Ciudad: " + arrTemperaturas[i].getCiudad());
            System.out.println("Día: " + arrTemperaturas[i].getDía());
            System.out.println("Mes: " + arrTemperaturas[i].getMes());
            System.out.println("Año: " + arrTemperaturas[i].getAño());
            System.out.println("Temperatura Máxima: " + arrTemperaturas[i].getTempMax());
            System.out.println("Temperatura Mínima: " + arrTemperaturas[i].getTemMin());
            System.out.println("Temperatura Promedio: " + arrTemperaturas[i].getTemProm());
            System.out.println("Sensación Térmica: " + arrTemperaturas[i].getSensacionTermica());
            System.out.println("Humedad: " + arrTemperaturas[i].getHumedad());
            System.out.println("Probabilidad de Lluvia: " + arrTemperaturas[i].getProbabilidadLluvia());
            System.out.println("Velocidad del Viento: " + arrTemperaturas[i].getVelViento());
            System.out.println("Condición del Clima: " + arrTemperaturas[i].getCondicionClima());
            System.out.println("-------------------------------");
        }
            */
        //Ejercicio 2 – Matriz Bidimensional
        System.out.println("------Matriz---------");
        System.out.print("Ingrese el número de filas de la matriz: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el numero de columnas de la matriz: ");
        int columnas = scanner.nextInt();
        Matriz matriz = new Matriz(columnas, filas);
        matriz.llenarMatriz();
        System.out.println("La matriz ingresada es: ");
        matriz.MostrarMatriz();
        System.out.println("La suma de todos lo elementos de la matriz es: " + matriz.getSuma());
        System.out.println("EL valor mínimo de la matriz es: " + matriz.getValorMin());
        System.out.println("La cantidad de valores mayores a 50 es: " + matriz.getContadorMayor50());
    }
}
