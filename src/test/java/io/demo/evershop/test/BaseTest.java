package io.demo.evershop;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static io.demo.evershop.Variables.*;

public class BaseTest {
    private Faker faker = new Faker();

    public DataFacker dataFaker = new DataFacker(faker);

    //Paso 1: declarar las variables que utilizaremos.
    public WebDriver driver;
    public Actions actions;

    // Crear una espera explícita
    public WebDriverWait waitExplicit;


    @BeforeClass
    public void setup(){
        //Paso 2: instanciar las variables
        // instanciamos el navegador a utilizar.
        driver = new FirefoxDriver();
        //Instanciamos los actions
        actions= new Actions(driver);
        //indicamos la configuración del navegador ( abrimos en modo maximizado)
        driver.manage().window().maximize();
        //Especificamo un tiempo de espera a que los elementos esten presentes en la pagina
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        // Crear una espera explícita
        waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_EXPLICIT));
        //Abrimos la URL
        driver.get(urlBase);
        //Cargamos la data fake para las pruebas
        dataFaker.dataUser();
    }


    @AfterClass
    public void tearDown(){
        if(driver != null){
            //cerramos la sesion
            //driver.close();
        }
    }
}
