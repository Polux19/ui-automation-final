import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class MercadoLibreApiTest {

    @Test
    public void validarDepartamentosMercadoLibre() {
        // El servicio que nos pide el examen
        String url = "https://www.mercadolibre.com.ar/menu/departments";

        RestAssured.given()
                .get(url)
                .then()
                .statusCode(200) // Verificamos que la página responda OK
                .body("departments", notNullValue()); // Verificamos que contenga departamentos

        System.out.println("API de Mercado Libre validada con éxito.");
    }
}