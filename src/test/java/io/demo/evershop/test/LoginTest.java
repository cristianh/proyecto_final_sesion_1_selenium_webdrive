package io.demo.evershop.test;

import com.demo.nopcommerce.models.User;
import org.testng.annotations.Test;
import static io.demo.evershop.pages.LoginPage.*;

public class LoginTest extends BaseTest {

    @Test(description = "TC-Login-01 - Inicio de sesión exitoso", priority = 1, groups = {"Regression", "Integration"})
    public void LoginSuccessTest() {
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        if(loginpage.isDisplayElement(inputEmail)) {
            loginpage.fillFormLogin();
            loginpage.clickButtonSubmit();
            loginpage.validateMessage(messageSuccessLogin, textValidateSuccessCredencials);
        }
    }

    @Test(description = "TC-Login-02 - Inicio de sesión credenciales incorrectas", priority = 2, groups = {"Functional"})
    public void LoginIncorrectCredencialsTest() {
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        User newUser = new User();
        newUser.setEmail("nona3.klein@hotmail.com");
        newUser.setPassword("@9Pb$XJV&k3");
        if(loginpage.isDisplayElement(inputEmail)) {
            loginpage.fillFormLogin(newUser);
            loginpage.clickButtonSubmit();
            loginpage.validateMessage(messageError, textValidateIncorrectCredencials);
        }
    }

    @Test(description = "TC-Login-03 - credenciales en blanco", priority = 3, groups = {"Functional"})
    public void LoginEmpyCredencialsTest() {
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        User newUser = new User();
        newUser.setEmail("");
        newUser.setPassword("");
        if(loginpage.isDisplayElement(inputEmail)) {
            loginpage.fillFormLogin(newUser);
            loginpage.clickButtonSubmit();
            loginpage.validateMessage(messageError, textValidateIncorrectCredencials);
        }
    }

    @Test(description = "TC-Login-04 - Correo electrónico no registrado", priority = 4, groups = {"Regression"})
    public void LoginEmailExitingCredencialsTest() {
        User newUser = dataFaker.getNewUser();
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        if(loginpage.isDisplayElement(inputEmail)) {
            loginpage.fillFormLogin(newUser);
            loginpage.clickButtonSubmit();
        }
        loginpage.validateMessage(messageError,textValidateIncorrectCredencials);
    }

    @Test(description = "TC-Login-05 - Contraseña olvidada", priority = 5, groups = {"Functional", "Integration"})
    public void LoginRemenberPasswordTest() {
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        if(loginpage.isDisplayElement(btnForgodPassword)) {
            loginpage.clickButtonForgotPassword();
            forgotpage.fillFormForgotPassword("talisha.kirlin@gmail.com");
            forgotpage.clickButtonSubmit();
            loginpage.validateMessage(messageRemenberCredencials,textValidateRememberPasswordConfirm);
        }
    }
}
