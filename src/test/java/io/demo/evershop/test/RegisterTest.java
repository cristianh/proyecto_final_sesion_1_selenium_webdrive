package io.demo.evershop.test;

import com.demo.nopcommerce.models.User;
import io.demo.evershop.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.demo.evershop.pages.RegisterPage.*;
import static org.testng.AssertJUnit.assertEquals;

public class RegisterTest extends BaseTest {

    @Test(description = "TC-Register-01 - Registro exitoso", priority = 1, groups = {"Functional"})
    public void registerSuccessTest() {
        reportsOut.configReport(capabilities,"Registro exitoso","Test Register Page Sucess");
        //Damos clic en el boton de registro.
        registerpage.clickMyAccount();
        registerpage.clickMyAccountRegister();
        User data = dataFaker.getNewUser();
        registerpage.fillFormRegister(data);
        registerpage.clickRadioButtonSuscribe();
        registerpage.clickCheckBoxPrivacite();
        registerpage.clickButtonSubmit();
        if (registerpage.isDisplayText(textValidateRegisterSuccess, textValidateRegister))
            Assert.assertEquals(registerpage.getText(textValidateRegisterSuccess), textValidateRegister);
        registerpage.clickMyAccount();
        registerpage.clickMyAccountOut();
    }


    @Test(description = "TC-Register-02 - registro con campos obligatorios faltantes", priority = 2, groups = {"Functional","Integration"})
    public void registerInputRequiredTest() {
        reportsOut.configReport(capabilities,"Registro con campos obligatorios faltantes","Test Register Page required inputs");
        //Damos clic en el boton de registro.
        registerpage.clickMyAccount();
        registerpage.clickMyAccountRegister();
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
        registerpage.clickMyAccount();
        registerpage.clickMyAccountOut();
    }


    @Test(description = "TC-Register-03 - correo formato invalido o incorrecto", priority = 3, groups = {"Functional","Regression"})
    public void registerEmailNotValidateTest() {
        reportsOut.configReport(capabilities,"Correo formato invalido o incorrecto","Test Register Page email bad format");
        //Damos clic en el boton de registro.
        registerpage.clickMyAccount();
        registerpage.clickMyAccountRegister();
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
        registerpage.clickMyAccount();
        registerpage.clickMyAccountOut();
    }



    @Test(description = "TC-Register-05 - Confirmación de contraseña",priority = 4, groups = {"Functional","Integration"})
    public void registerPasswordConfimTest() {
        reportsOut.configReport(capabilities,"Confirmación de contraseña","Test Register Page confirm password");
        //Damos clic en el boton de registro.
        registerpage.clickMyAccount();
        registerpage.clickMyAccountRegister();
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
        registerpage.clickMyAccount();
        registerpage.clickMyAccountOut();
    }

    @Test(description = "TC-Register-06 - Correo electrónico único",priority = 4, groups = {"Functional","Integration"})
    public void registerValidateUniqueEmailTest() {
        reportsOut.configReport(capabilities,"Correo electrónico único","Test Register Page email uniqued");
        //Damos clic en el boton de registro.
        registerpage.clickMyAccount();
        registerpage.clickMyAccountRegister();
        User data = dataFaker.getNewUser();
        data.setEmail("pepe1234@hotmail.com");
        registerpage.fillFormRegister(data);
        registerpage.clickRadioButtonSuscribe();
        registerpage.clickCheckBoxPrivacite();
        registerpage.clickButtonSubmit();
        assertEquals(registerpage.getText(textValidateMessageAlert), textValidateEmailExiting);
        registerpage.clickMyAccount();
        registerpage.clickMyAccountOut();
    }

}
