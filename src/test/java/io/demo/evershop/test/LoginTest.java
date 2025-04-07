package io.demo.evershop.test;

import com.demo.nopcommerce.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.demo.evershop.pages.LoginPage.*;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "TC-Login-01 - Inicio de sesión exitoso",groups = "Regression,Integration")
    public void LoginSuccessTest() {
        User newUser = new User();
        newUser.setEmail("nona.klein@hotmail.com");
        newUser.setPassword("@9Pb$XJV&k");
        loginpage.fillFormLogin(newUser);
        loginpage.clickButtonSubmit();
        if(loginpage.isDisplayElement(By.cssSelector("#content h2")))
            Assert.assertEquals(loginpage.getText(By.cssSelector("#content h2")),textValidateSuccessCredencials);
    }

    @Test(description = "TC-Login-02 - Inicio de sesión credenciales incorrectas",groups = "Funcional")
    public void LoginIncorrectCredencialsTest() {
        User newUser = new User();
        newUser.setEmail("nona3.klein@hotmail.com");
        newUser.setPassword("@9Pb$XJV&k3");
        loginpage.fillFormLogin(newUser);
        loginpage.clickButtonSubmit();
        if(loginpage.isDisplayElement(By.cssSelector(".alert")))
            assertEquals(loginpage.getText(By.cssSelector(".alert")), textValidateIncorrectCredencials);
    }

    @Test(description = "TC-Login-03 - credenciales en blanco",groups = "Funcional")
    public void LoginEmpyCredencialsTest() {
        User newUser = new User();
        newUser.setEmail("");
        newUser.setPassword("");
        loginpage.fillFormLogin(newUser);
        loginpage.clickButtonSubmit();
        if(loginpage.isDisplayElement(By.cssSelector(".alert")))
            assertEquals(loginpage.getText(By.cssSelector(".alert")), textValidateIncorrectCredencials);
    }

    @Test(description = "TC-Login-04 - Correo electrónico no registrado",groups = "Regression")
    public void LoginEmailExitingCredencialsTest() {
        User data= dataFaker.getNewUser();
        loginpage.fillFormLogin(data);
        loginpage.clickButtonSubmit();
        if(loginpage.isDisplayElement(By.cssSelector(".alert")))
            assertEquals(loginpage.getText(By.cssSelector(".alert")), textValidateIncorrectCredencials);
    }

    @Test(description = "TC-Login-05 - Contraseña olvidada",groups = "Funcional,Integration")
    public void LoginRemenberPasswordTest() {
        loginpage.clickButtonForgotPassword();
        forgotpage.fillFormForgotPassword("talisha.kirlin@gmail.com");
        forgotpage.clickButtonSubmit();
        WebElement textValidateLoginBadCredencials = driver.findElement(By.cssSelector("#account-login div"));
        assertEquals(textValidateLoginBadCredencials.getText(),textValidateRememberPasswordConfirm);
    }
}
