/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.ramses.letradni;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ramses
 */
public class LetraDniTest {
    @Test
    public void testAdivinarNumeroDNI() {
        // Pruebas con números conocidos
        assertEquals('Z', LetraDni.AdivinarNumeroDNI(12345678)); // Caso válido
        assertEquals('X', LetraDni.AdivinarNumeroDNI(87654321)); // Caso válido
        assertEquals('T', LetraDni.AdivinarNumeroDNI(0));        // Caso válido
    }

    @Test
    public void testComprobarDNI() {
        // Pruebas con DNIs válidos e inválidos
        assertTrue(LetraDni.ComprobarDNI("12345678Z")); // Caso válido
        assertFalse(LetraDni.ComprobarDNI("12345678X")); // Caso inválido
        assertTrue(LetraDni.ComprobarDNI("00000000T"));  // Caso válido
        assertFalse(LetraDni.ComprobarDNI("98765432A")); // Caso inválido
    }

    @Test
    public void testVerificarListaDNIs() {
        // Simular la lista de DNIs del apartado c)
        String[] dniLista = {"12345678Z", "87654321X", "11223344A", "98765432P", "00000000T"};
        boolean[] resultadosEsperados = {true, false, false, false, true};

        for (int i = 0; i < dniLista.length; i++) {
            assertEquals(resultadosEsperados[i], LetraDni.ComprobarDNI(dniLista[i]));
        }
    }
}

