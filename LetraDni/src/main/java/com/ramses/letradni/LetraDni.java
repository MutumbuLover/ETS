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
    /**
     * Comprueba si un DNI es válido (número + letra).
     * @param dni Cadena que representa el DNI (formato: número + letra).
     * @return true si la letra coincide con el número del DNI; false en caso contrario.
     */
    
    public static boolean ComprobarDNI(String dni) {
        // Verificar que el formato del DNI es correcto (8 números + 1 letra)
        if (dni.length() != 9) return false;

        try {
            // Extraer los 8 primeros caracteres como número
            int numero = Integer.parseInt(dni.substring(0, 8));

            // Extraer la última letra
            char letra = dni.charAt(8);

            // Comparar la letra calculada con la proporcionada
            return letra == AdivinarNumeroDNI(numero);
        } catch (NumberFormatException e) {
            // Si no se puede convertir a número, no es un DNI válido
            return false;
        }
    }
    /**
    * Comprueba una lista de DNIs y muestra si son válidos o no.
    */
    public static void VerificarListaDNIs() {
        // Lista de DNIs para comprobar (algunos válidos, otros no)
        String[] dniLista = {
            "12345678Z", // Válido
            "87654321X", // Inválido
            "11223344A", // Inválido
            "98765432P", // Inválido
            "00000000T"  // Válido
        };

        // Iterar sobre la lista y verificar cada DNI
        System.out.println("Comprobando la lista de DNIs:");
        for (String dni : dniLista) {
            boolean esValido = ComprobarDNI(dni);
            System.out.println("DNI: " + dni + " es válido? " + esValido);
        }
    }
}