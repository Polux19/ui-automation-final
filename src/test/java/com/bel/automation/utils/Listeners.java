package com.bel.automation.utils;

import com.bel.automation.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listeners extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        // Obtenemos el driver desde la clase de test que falló
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).getDriver();

        if (driver != null) {
            // Creamos un nombre único con la fecha y hora para la captura
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String fileName = result.getName() + "_" + timestamp + ".png";

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // Se guardarán en una carpeta llamada 'screenshots' en la raíz del proyecto
                FileUtils.copyFile(srcFile, new File("./screenshots/" + fileName));
                System.out.println("❌ Test fallido. Captura guardada como: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}