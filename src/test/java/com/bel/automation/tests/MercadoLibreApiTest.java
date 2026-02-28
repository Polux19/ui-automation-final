package com.bel.automation.tests;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest; // Importamos el BaseTest para usar el Chrome
import static org.hamcrest.Matchers.*;

public class MercadoLibreApiTest extends BaseTest { // <--- Agregamos "extends BaseTest"

    @Test
    public void validarDepartamentosMercadoLibre() {
        String url = "https://www.mercadolibre.com.ar/menu/departments";

        // 1. Abrimos la URL en el navegador para que, si falla, HAYA una foto que sacar
        driver.get(url);

        // 2. Validamos la API
        RestAssured.given()
                .get(url)
                .then()
                .statusCode(200)
                .body("departments", notNullValue());

        // 3. Forzamos una falla para que veas la foto (opcional, igual que en el CP05)
        // Assert.assertTrue(false, "Falla intencional para capturar pantalla de API");

        System.out.println("API de Mercado Libre validada y foto disponible si falla.");
    }
}