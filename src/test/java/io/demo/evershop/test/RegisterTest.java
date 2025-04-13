package io.demo.evershop.test;

import com.demo.nopcommerce.models.User;
import io.demo.evershop.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.demo.evershop.pages.RegisterPage.*;
import static org.testng.AssertJUnit.assertEquals;

public class RegisterTest extends BaseTest {

    @Test(description = "TC-Register-01 - Registro exitoso", groups = {"Functional"})
    public void registerSuccessTest() {

        //Damos clic en el boton de registro.
        //WebElement btnUser = driver.findElement(By.cssSelector("#hrefUserIcon"));
        //btnUser.click();

        User data = dataFaker.getNewUser();
        registerpage.fillFormRegister(data);
        registerpage.clickRadioButtonSuscribe();
        registerpage.clickCheckBoxPrivacite();
        registerpage.clickButtonSubmit();
        if (registerpage.isDisplayText(textValidateRegisterSuccess, textValidateRegister))
            Assert.assertEquals(registerpage.getText(textValidateRegisterSuccess), textValidateRegister);
    }


    @Test(description = "TC-Register-02 - registro con campos obligatorios faltantes", groups = {"Functional"})
    public void registerInputRequiredTest() {
        registerpage.clickCheckBoxPrivacite();
        registerpage.clickButtonSubmit();
        if (registerpage.isDisplayElement(inputFirstNameValidate)) {
            softAssertValidationInputs.assertEquals(registerpage.getText(inputFirstNameValidate), inputFirstNameEmpyMessage, "Valida mensaje campo First Name obligatorio");
            softAssertValidationInputs.assertEquals(registerpage.getText(inputLastNameValidate), inputLastNameEmpyMessage, "Valida mensaje campo Last Name obligatorio");
            softAssertValidationInputs.assertEquals(registerpage.getText(inputEmailValidate), inputEmailEmpyMessage, "Valida mensaje campo Email obligatorio");
            softAssertValidationInputs.assertEquals(registerpage.getText(inputPhoneNumberValidate), inputTelephoneEmpyMessage, "Valida mensaje campo Phone Number obligatorio");
            softAssertValidationInputs.assertEquals(registerpage.getText(inputPasswordValidate), inputPasswordEmpyMessage, "Valida mensaje campo Password obligatorio");
            softAssertValidationInputs.assertAll();
        }
    }


    @Test(description = "TC-Register-03 - correo formato invalido o incorrecto", groups = {"Functional"})
    public void registerEmailNotValidateTest() {

        registerpage.clickRadioButtonSuscribe();
        registerpage.clickCheckBoxPrivacite();
        registerpage.clickButtonSubmit();

        User data = dataFaker.getNewUser();
        data.setEmail("pruebasqa2025@gmail");
        registerpage.fillFormRegister(data);
        registerpage.clickRadioButtonSuscribe();
        registerpage.clickCheckBoxPrivacite();
        registerpage.clickButtonSubmit();

        if (registerpage.isDisplayElement(RegisterPage.inputEmailValidate))
            assertEquals(registerpage.getText(RegisterPage.inputEmailValidate), inputEmailInvalidMessage);

    }

    @Test(description = "TC-Register-05 - Confirmación de contraseña", groups = {"Functional"})
    public void registerPasswordConfimTest() {

        User data = dataFaker.getNewUser();
        data.setPasswordconfirm("123456789");
        registerpage.fillFormRegister(data);
        registerpage.clickRadioButtonSuscribe();
        registerpage.clickCheckBoxPrivacite();
        registerpage.clickButtonSubmit();

        if (registerpage.isDisplayElement(inputConfirmPasswordValidate) && registerpage.isDisplayElement(inputPasswordValidate)) {
            softAssertValidationInputs.assertEquals(registerpage.getText(inputPasswordValidate), inputPasswordEmpyMessage);
            softAssertValidationInputs.assertEquals(registerpage.getText(inputConfirmPasswordValidate), textValidatePasswordConfim);
            softAssertValidationInputs.assertAll();
        }
    }

    @Test(description = "TC-Register-06 - Correo electrónico único", groups = {"Functional"})
    public void registerValidateUniqueEmailTest() {

        User data = dataFaker.getNewUser();
        data.setEmail("pepe1234@hotmail.com");
        registerpage.fillFormRegister(data);
        registerpage.clickRadioButtonSuscribe();
        registerpage.clickCheckBoxPrivacite();
        registerpage.clickButtonSubmit();
        assertEquals(registerpage.getText(textValidateMessageAlert), textValidateEmailExiting);
    }

}
