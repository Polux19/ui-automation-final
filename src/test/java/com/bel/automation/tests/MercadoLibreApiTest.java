package com.bel.automation.tests; // Tu ubicación actual

import io.restassured.RestAssured;
import org.testng.annotations.Test;
// CAMBIO CLAVE: Ponemos la dirección completa de BaseTest
import com.bel.automation.utils.BaseTest;
import static org.hamcrest.Matchers.*;

public class MercadoLibreApiTest extends BaseTest { // Ahora sí hereda el driver

    @Test
    public void validarDepartamentosMercadoLibre() {
        String url = "https://www.mercadolibre.com.ar/menu/departments";

        // Al heredar de BaseTest, 'driver' ahora sí existe
        driver.get(url);

        RestAssured.given()
                .get(url)
                .then()
                .statusCode(200)
                .body("departments", notNullValue());

        System.out.println("API de Mercado Libre validada con éxito.");
    }
}