package io.demo.evershop.pages;

import com.demo.nopcommerce.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static io.demo.evershop.Variables.urlBaseLogin;

public class LoginPage extends BasePage {
    public static By inputEmail = By.cssSelector("#input-email");
    public static By inputPassword =  By.cssSelector("#input-password");
    public static By btnLogin = By.cssSelector("input[type='submit']");
    public static By btnForgodPassword = By.cssSelector("#input-password + a");

    public static String textValidateSuccessCredencials = "My Account";
    public static String textValidateIncorrectCredencials = "Warning: No match for E-Mail Address and/or Password.";
    public static String textValidateRememberPasswordConfirm = "An email with a confirmation link has been sent your email address.";

    public LoginPage(WebDriver driver,String urlBase) {
        super(driver);
        visit(urlBase);
    }

    public void fillFormLogin(User userlogin){
        type(inputEmail,userlogin.getEmail());
        type(inputPassword,userlogin.getPassword());;
    }


    public void clickButtonSubmit(){
        click(btnLogin);
    }

    public void clickButtonForgotPassword(){
        click(btnForgodPassword);
    }
}
