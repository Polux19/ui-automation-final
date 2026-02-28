package com.bel.automation.tests;

import com.bel.automation.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void pruebaCapturaAlFallar() {
        driver.get("https://www.google.com");

        // Forzamos un fallo para probar la captura
        String tituloEsperado = "Bing";
        String tituloActual = driver.getTitle();

        System.out.println("Validando título...");
        Assert.assertEquals(tituloActual, tituloEsperado, "El título no coincide, debería fallar.");
    }
}