package io.demo.evershop.test;

import com.demo.nopcommerce.models.User;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import static io.demo.evershop.pages.LoginPage.*;

public class LoginTest extends BaseTest {

    @Test(description = "TC-Login-01 - Inicio de sesión exitoso", priority = 1, groups = {"Regression", "Integration"})
    public void LoginSuccessTest() {
        reportsOut.configReport(capabilities, "Inicio de sesión exitoso", "Test login Page success");
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        if (loginpage.isDisplayElement(inputEmail)) {
            loginpage.fillFormLogin();
            loginpage.clickButtonSubmit();
            loginpage.validateMessage(messageSuccessLogin, textValidateSuccessCredencials);
        }
    }

    @Test(description = "TC-Login-02 - Inicio de sesión credenciales incorrectas", priority = 2, groups = {"Functional"})
    public void LoginIncorrectCredencialsTest() {
        reportsOut.configReport(capabilities, "Inicio de sesión credenciales incorrectas", "Test login Page bad credencials");
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        User newUser = new User();
        newUser.setEmail("nona3.klein@hotmail.com");
        newUser.setPassword("@9Pb$XJV&k3");
        if (loginpage.isDisplayElement(inputEmail)) {
            loginpage.fillFormLogin(newUser);
            loginpage.clickButtonSubmit();
            loginpage.validateMessage(messageError, textValidateIncorrectCredencials);
        }
    }

    @Test(description = "TC-Login-03 - Credenciales en blanco", priority = 3, groups = {"Functional"})
    public void LoginEmpyCredencialsTest() {
        reportsOut.configReport(capabilities, "Credenciales en blanco", "Test login Page empy credencials");
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        User newUser = new User();
        newUser.setEmail("");
        newUser.setPassword("");
        if (loginpage.isDisplayElement(inputEmail)) {
            loginpage.fillFormLogin(newUser);
            loginpage.clickButtonSubmit();
            loginpage.validateMessage(messageError, textValidateIncorrectCredencials);
        }
    }

    @Test(description = "TC-Login-04 - Correo electrónico no registrado", priority = 4, groups = {"Regression"})
    public void LoginEmailExitingCredencialsTest() {
        reportsOut.configReport(capabilities, "Correo electrónico no registrado", "Test login Page not credencials register");
        User newUser = dataFaker.getNewUser();
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        if (loginpage.isDisplayElement(inputEmail)) {
            loginpage.fillFormLogin(newUser);
            loginpage.clickButtonSubmit();
        }
        loginpage.validateMessage(messageError, textValidateIncorrectCredencials);
    }

    @Test(description = "TC-Login-05 - Contraseña olvidada", priority = 5, groups = {"Functional", "Integration"})
    public void LoginRemenberPasswordTest() {
        reportsOut.configReport(capabilities, "Contraseña olvidada", "Test login Page not remenber credencials");
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        if (loginpage.isDisplayElement(btnForgodPassword)) {
            loginpage.clickButtonForgotPassword();
            forgotpage.fillFormForgotPassword("talisha.kirlin@gmail.com");
            forgotpage.clickButtonSubmit();
            loginpage.validateMessage(messageRemenberCredencials, textValidateRememberPasswordConfirm);
        }
    }
}
