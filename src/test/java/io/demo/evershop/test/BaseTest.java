package io.demo.evershop.test;

import com.github.javafaker.Faker;
import io.demo.evershop.DataFacker;
import io.demo.evershop.Variables;
import io.demo.evershop.pages.ForgotPage;
import io.demo.evershop.pages.LoginPage;
import io.demo.evershop.pages.OrdersPage;
import io.demo.evershop.pages.RegisterPage;
import io.demo.evershop.utils.Reports;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import static io.demo.evershop.Variables.*;

public class BaseTest {
    private Faker faker = new Faker();

    public DataFacker dataFaker = new DataFacker(faker);

    //Paso 1: declarar las variables que utilizaremos.
    public WebDriver driver;


    // Crear una espera explícita
    public WebDriverWait waitExplicit;

    //Pages

    protected LoginPage loginpage;
    protected ForgotPage forgotpage;
    protected RegisterPage registerpage;
    protected OrdersPage orderpage;

    //Reports
    public Reports reportsOut;
    public static Capabilities capabilities;

    //Assert Soft
    public SoftAssert softAssertValidationInputs = new SoftAssert();

    @BeforeSuite()
    public void setupReport() {
        reportsOut = new Reports();
        reportsOut.initReport();

    }

    @BeforeTest()
    public void setup() {
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

        capabilities = ((RemoteWebDriver) driver).getCapabilities();


        reportsOut.runConfig();

        //indicamos la configuración del navegador ( abrimos en modo maximizado)
        driver.manage().window().maximize();
        //Abrimos la URL
        driver.get(urlBaseHome);
        //Cargamos la data fake para las pruebas
        dataFaker.dataUser();
        //Instance Pages
        loginpage = new LoginPage(driver);
        forgotpage = new ForgotPage(driver);
        registerpage = new RegisterPage(driver);
        orderpage = new OrdersPage(driver);
    }


    @AfterTest()
    public void tearDown() {
        if (driver != null) {
            System.out.println("Se cierra la sesion");
            //cerramos la sesion
            driver.close();
        }
    }

    @AfterSuite()
    public void methodName() {
        reportsOut.clearReport();
    }
}
