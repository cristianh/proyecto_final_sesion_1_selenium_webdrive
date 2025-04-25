package io.demo.evershop.test;

import com.github.javafaker.Faker;
import io.demo.evershop.DataFacker;
import io.demo.evershop.Variables;
import io.demo.evershop.pages.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

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
    protected RegisterPage registerpage;
    protected OrdersPage orderpage;
    protected CheckoutPage checkoutpage;

    //Assert Soft
    public SoftAssert softAssertValidationInputs = new SoftAssert();


    @BeforeClass(alwaysRun = true)
    public void setup(){
        // Crear opciones de Firefox
        FirefoxOptions options = new FirefoxOptions();

        // 🔐 Configuraciones de seguridad directamente
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecure-localhost");
        //options.addArguments("--headless");
        options.addArguments("-save-mode");
        //Paso 2: instanciar las variables
        // instanciamos el navegador a utilizar.
        driver = new FirefoxDriver(options);

        Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();

        System.out.println("Browser Name: " + capabilities.getBrowserName() );
        System.out.println("Browser Version: " + capabilities.getBrowserVersion() );
        System.out.println("Plataform Name: " + capabilities.getPlatformName());

        //Instanciamos los actions
        actions= new Actions(driver);
        //indicamos la configuración del navegador ( abrimos en modo maximizado)
        driver.manage().window().maximize();
        //Abrimos la URL
        driver.get(urlBaseHome);
        //Cargamos la data fake para las pruebas
        dataFaker.dataUser();
        //Instance Pages
        loginpage =  new LoginPage(driver);
        forgotpage = new ForgotPage(driver);
        registerpage = new RegisterPage(driver);
        orderpage = new OrdersPage(driver);
        checkoutpage = new CheckoutPage(driver);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        if(driver != null){
            //cerramos la sesion
            driver.close();
        }
    }
}
