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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
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

    //Reports
    public Reports reportsOut;

    //Assert Soft
    public SoftAssert softAssertValidationInputs = new SoftAssert();

    @BeforeSuite
    public  void setupReport(){
        reportsOut= new Reports();
        reportsOut.initReport();

    }

    @BeforeClass(alwaysRun = true)
    public void setup(){
        // Crear opciones de Firefox
        FirefoxOptions options = new FirefoxOptions();

        // 🔐 Configuraciones de seguridad directamente
        options.addPreference("security.mixed_content.block_active_content", false);
        options.addPreference("security.mixed_content.block_display_content", false);
        options.addPreference("webdriver_accept_untrusted_certs", true);
        options.addPreference("webdriver_assume_untrusted_issuer", false);
        //options.addArguments("--headless");
        options.addArguments("-save-mode");
        //Paso 2: instanciar las variables
        // instanciamos el navegador a utilizar.
        driver = new FirefoxDriver(options);

        Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();


        //Config reports
        reportsOut.configReport(capabilities);
        reportsOut.runReports();

        //Instanciamos los actions
        actions= new Actions(driver);
        //indicamos la configuración del navegador ( abrimos en modo maximizado)
        driver.manage().window().maximize();
        //Abrimos la URL
        //driver.get(urlBaseRegister);
        //driver.get(urlBaseLogin);
        driver.get(urlBaseHome);
        //Cargamos la data fake para las pruebas
        dataFaker.dataUser();
        //Instance Pages
        loginpage =  new LoginPage(driver);
        forgotpage = new ForgotPage(driver);
        registerpage = new RegisterPage(driver);
        orderpage = new OrdersPage(driver);
    }




    @AfterClass(alwaysRun = true)
    public void tearDown(){
        if(driver != null){
            //cerramos la sesion
            driver.close();
        }
    }

    @AfterSuite
    public void methodName() {
        reportsOut.clearReport();
    }
}
