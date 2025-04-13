package io.demo.evershop.pages;

import com.demo.nopcommerce.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static io.demo.evershop.Variables.urlBaseLogin;
import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends BasePage {
    public static By inputEmail = By.cssSelector("#input-email");
    public static By inputPassword =  By.cssSelector("#input-password");
    public static By btnLogin = By.cssSelector("input[type='submit']");
    public static By btnForgodPassword = By.cssSelector("#input-password + a");
    public static By messageSuccessLogin = By.cssSelector("#content h2");
    public static By messageError = By.cssSelector(".alert");
    public static By messageRemenberCredencials = By.cssSelector("#account-login div");

    public static String textValidateSuccessCredencials = "My Account";
    public static String textValidateIncorrectCredencials = "Warning: No match for E-Mail Address and/or Password.";
    public static String textValidateRememberPasswordConfirm = "An email with a confirmation link has been sent your email address.";

    public LoginPage(WebDriver driver) {
        super(driver);
        //visit(urlBase);
    }

    /**
     * La sobrecarga de métodos en Java (method overloading) es una característica que permite definir varios métodos con el mismo nombre dentro de una misma clase,
     * pero con diferentes listas de parámetros (tipo, número o el orden de los parámetros).
     * ¿Para qué sirve?
     * Sirve para que un metodo realice acciones similares pero con diferentes tipos o cantidades de argumentos, mejorando la legibilidad y reutilización del código.*/
    public void fillFormLogin(User userlogin){
        type(inputEmail,userlogin.getEmail());
        type(inputPassword,userlogin.getPassword());;
    }


    public void fillFormLogin(){
        User newUser = new User();
        newUser.setEmail("nona.klein@hotmail.com");
        newUser.setPassword("@9Pb$XJV&k");
        type(inputEmail,newUser.getEmail());
        type(inputPassword,newUser.getPassword());;
    }


    public void clickButtonSubmit(){
        click(btnLogin);
    }

    public void clickButtonForgotPassword(){
        click(btnForgodPassword);
    }

    public void validateMessage(By element,String textValidate){
        if (isDisplayElement(element))
            assertEquals(getText(element), textValidate);
    }
}
