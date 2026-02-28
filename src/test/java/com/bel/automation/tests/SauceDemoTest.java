package com.bel.automation.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.nio.file.Files;

public class SauceDemoTest {
    WebDriver driver; // Nuestro Robot

    // Antes de cada prueba: Abrir Chrome y entrar a la página
    @BeforeMethod
    public void prepararRobot() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    // --- PUNTO 3: 2 CASOS DE LOGIN ---

    @Test
    public void CP01_LoginExitoso() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Verifica si entró viendo si existe el título de productos
        boolean estaEnProductos = driver.findElement(By.className("title")).isDisplayed();
        Assert.assertTrue(estaEnProductos, "El robot no pudo entrar a la tienda.");
    }

    @Test
    public void CP02_LoginBloqueado() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Verifica que salga el mensaje de error de bloqueado
        String error = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(error.contains("locked out"), "No apareció el error de bloqueo.");
    }

    // --- PUNTO 3: 2 CASOS DE CARRITO ---

    @Test
    public void CP06_AgregarProducto() {
        // Primero, el robot tiene que iniciar sesión
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Clic en agregar la mochila
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Verifica que el número del carrito sea 1
        String cantidad = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cantidad, "1", "El carrito no tiene 1 producto.");
    }

    @Test
    public void CP08_QuitarProducto() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Agrega la mochila y al instante la quita
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        // Verifica que ya no exista el circulito rojo de cantidad en el carrito
        int cantidadCirculitos = driver.findElements(By.className("shopping_cart_badge")).size();
        Assert.assertEquals(cantidadCirculitos, 0, "El carrito no está vacío.");
    }

    // --- PUNTO 2: SACAR FOTO SI FALLA (Captura de pantalla) ---

    @AfterMethod
    public void apagarRobotYSacarFoto(ITestResult resultado) {
        // Si la prueba salió mal (FAILURE)
        if (ITestResult.FAILURE == resultado.getStatus()) {
            try {
                TakesScreenshot camara = (TakesScreenshot) driver;
                File foto = camara.getScreenshotAs(OutputType.FILE);
                File destino = new File("screenshots/" + resultado.getName() + ".png");
                Files.copy(foto.toPath(), destino.toPath());
            } catch (Exception e) {
                System.out.println("No se pudo sacar la foto.");
            }
        }
        driver.quit(); // Cierra el navegador
    }
}