package io.demo.evershop.test;

import com.github.javafaker.Faker;
import io.demo.evershop.DataFacker;
import io.demo.evershop.Variables;
import io.demo.evershop.pages.ForgotPage;
import io.demo.evershop.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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

    //Pages

    protected LoginPage loginpage;
    protected ForgotPage forgotpage;


    @BeforeMethod
    public void setup(){
        //Paso 2: instanciar las variables
        // instanciamos el navegador a utilizar.
        driver = new FirefoxDriver();
        //Instanciamos los actions
        actions= new Actions(driver);
        //indicamos la configuración del navegador ( abrimos en modo maximizado)
        driver.manage().window().maximize();
        //Cargamos la data fake para las pruebas
        dataFaker.dataUser();
        //Instance Pages
        loginpage =  new LoginPage(driver, urlBaseLogin);
        forgotpage = new ForgotPage(driver);
    }


    @AfterMethod
    public void tearDown(){
        if(driver != null){
            //cerramos la sesion
            //driver.close();
        }
    }
}
