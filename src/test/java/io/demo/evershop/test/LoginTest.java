package io.demo.evershop.test;

import com.demo.nopcommerce.models.User;
import org.testng.annotations.Test;
import static io.demo.evershop.pages.LoginPage.*;

public class LoginTest extends BaseTest {

    @Test(description = "TC-Login-01 - Inicio de sesión exitoso", groups = {"Regression", "Integration"})
    public void LoginSuccessTest() {
        loginpage.fillFormLogin();
        loginpage.clickButtonSubmit();
        loginpage.validateMessage(messageSuccessLogin,textValidateSuccessCredencials);
    }

    @Test(description = "TC-Login-02 - Inicio de sesión credenciales incorrectas", groups = {"Functional"})
    public void LoginIncorrectCredencialsTest() {
        User newUser = new User();
        newUser.setEmail("nona3.klein@hotmail.com");
        newUser.setPassword("@9Pb$XJV&k3");
        loginpage.fillFormLogin(newUser);
        loginpage.clickButtonSubmit();
        loginpage.validateMessage(messageError,textValidateIncorrectCredencials);
    }

    @Test(description = "TC-Login-03 - credenciales en blanco", groups = {"Functional"})
    public void LoginEmpyCredencialsTest() {
        User newUser = new User();
        newUser.setEmail("");
        newUser.setPassword("");
        loginpage.fillFormLogin(newUser);
        loginpage.clickButtonSubmit();
        loginpage.validateMessage(messageError,textValidateIncorrectCredencials);
    }

    @Test(description = "TC-Login-04 - Correo electrónico no registrado", groups = {"Regression"})
    public void LoginEmailExitingCredencialsTest() {
        User data = dataFaker.getNewUser();
        loginpage.fillFormLogin(data);
        loginpage.clickButtonSubmit();
        loginpage.validateMessage(messageError,textValidateIncorrectCredencials);
    }

    @Test(description = "TC-Login-05 - Contraseña olvidada", groups = {"Functional", "Integration"})
    public void LoginRemenberPasswordTest() {
        loginpage.clickButtonForgotPassword();
        forgotpage.fillFormForgotPassword("talisha.kirlin@gmail.com");
        forgotpage.clickButtonSubmit();
        loginpage.validateMessage(messageRemenberCredencials,textValidateRememberPasswordConfirm);
    }
}
