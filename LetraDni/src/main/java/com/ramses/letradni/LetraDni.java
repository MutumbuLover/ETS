/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ramses.letradni;

import java.util.Scanner;

/**
 *
 * @author ramses
 */

public class LetraDni {

    /**
     * Calcula la letra correspondiente a un número de DNI.
     * @param numeroDNI Número entero del DNI.
     * @return Letra asociada al número del DNI.
     */
    
    public static char AdivinarNumeroDNI(int numeroDNI) {
        // Tabla de letras según el resto de la división entre 23
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        // Calcula el índice correspondiente
        int indice = numeroDNI % 23;

        // Devuelve la letra correspondiente
        return letras.charAt(indice);
    }

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que introduzca el número del DNI
        System.out.print("Introduce el número del DNI (sin letra): ");
        
        try {
            int numeroDNI = scanner.nextInt(); // Leer el número introducido por el usuario

            // Calcular y mostrar la letra correspondiente
            char letra = AdivinarNumeroDNI(numeroDNI);
            System.out.println("La letra del DNI " + numeroDNI + " es: " + letra);
        } catch (Exception e) {
            System.out.println("Error: Debes introducir un número válido.");
        } finally {
            scanner.close(); // Cerrar el Scanner
        }
    }
}