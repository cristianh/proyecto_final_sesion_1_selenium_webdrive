package io.demo.evershop.test;

import com.demo.nopcommerce.models.User;
import io.demo.evershop.BaseTest;
import io.demo.evershop.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import static io.demo.evershop.Variables.TIME_OUT;
import static io.demo.evershop.pages.RegisterPage.*;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage2Test extends BaseTest {


    SoftAssert softAssertValidationInputs = new SoftAssert();


    @Test(description = "TC-Register-01 - Registro exitoso",groups = "Functional")
    public void registerSuccessTest(){

        //Damos clic en el boton de registro.
        //WebElement btnUser = driver.findElement(By.cssSelector("#hrefUserIcon"));
        //btnUser.click();

        WebElement inputFirstName = driver.findElement(RegisterPage.inputFirstName);
        WebElement inputLastName = driver.findElement(RegisterPage.inputLastName);
        WebElement inputEmail = driver.findElement(RegisterPage.inputEmail);
        WebElement inputPhoneNumber = driver.findElement(RegisterPage.inputPhoneNumber);
        WebElement inputPassword = driver.findElement(RegisterPage.inputPassword);
        WebElement inputConfirmPassword = driver.findElement(RegisterPage.inputConfirmPassword);

        WebElement radioSuscribe = driver.findElement(RegisterPage.inputRadioSuscribe);
        WebElement chechBoxPrivacyPo = driver.findElement(RegisterPage.inputChechBoxPrivacyPo);
        WebElement btnRegister = driver.findElement(RegisterPage.btnRegister);

        User data= dataFaker.getNewUser();

        //Address data
        //WebElement selectCountry = driver.findElement(By.cssSelector("select[name='countryListboxRegisterPage']"));
        inputFirstName.sendKeys(data.getFirstName());
        inputLastName.sendKeys(data.getLastName());
        inputEmail.sendKeys(data.getEmail());
        inputPhoneNumber.sendKeys(data.getTelephone());
        inputPassword.sendKeys(data.getPassword());
        inputConfirmPassword.sendKeys(data.getPasswordconfirm());
        radioSuscribe.click();
        chechBoxPrivacyPo.click();
        btnRegister.submit();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        boolean isVisibletextoRegister = wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("p"),textValidateRegister));

        if(isVisibletextoRegister){
            Assert.assertTrue(isVisibletextoRegister);
            //Assert.assertEquals(driver.getTitle(),titleValidateRegister);
        }

    }


    @Test(description = "TC-Register-02 - registro con campos obligatorios faltantes",groups = "Functional")
    public void registerInputRequiredTest(){
        WebElement chechBoxPrivacyPo = driver.findElement(RegisterPage.inputChechBoxPrivacyPo);
        chechBoxPrivacyPo.click();
        WebElement btnRegister = driver.findElement(RegisterPage.btnRegister);
        btnRegister.submit();

        //Capturamos los mensajes de validacion del formulario.
        WebElement inputFirstName = driver.findElement(RegisterPage.inputFirstNameValidate);
        WebElement inputLastName = driver.findElement(RegisterPage.inputLastNameValidate);
        WebElement inputEmail = driver.findElement(RegisterPage.inputEmailValidate);
        WebElement inputPhoneNumber = driver.findElement(inputPhoneNumberValidate);
        WebElement inputPassword = driver.findElement(inputPasswordValidate);

        softAssertValidationInputs.assertEquals(inputFirstName.getText(),inputFirstNameEmpyMessage);
        softAssertValidationInputs.assertEquals(inputLastName.getText(),inputLastNameEmpyMessage);
        softAssertValidationInputs.assertEquals(inputEmail.getText(),inputEmailEmpyMessage);
        softAssertValidationInputs.assertEquals(inputPhoneNumber.getText(),inputTelephoneEmpyMessage);
        softAssertValidationInputs.assertEquals(inputPassword.getText(),inputPasswordEmpyMessage);
        softAssertValidationInputs.assertAll();
    }


    @Test(description = "TC-Register-03 - correo formato invalido o incorrecto",groups = "Functional")
    public void registerEmailNotValidateTest(){

        WebElement inputFirstName = driver.findElement(RegisterPage.inputFirstName);
        WebElement inputLastName = driver.findElement(RegisterPage.inputLastName);
        WebElement inputEmail = driver.findElement(RegisterPage.inputEmail);
        WebElement inputPhoneNumber = driver.findElement(RegisterPage.inputPhoneNumber);
        WebElement inputPassword = driver.findElement(RegisterPage.inputPassword);
        WebElement inputConfirmPassword = driver.findElement(RegisterPage.inputConfirmPassword);

        WebElement radioSuscribe = driver.findElement(RegisterPage.inputRadioSuscribe);
        WebElement chechBoxPrivacyPo = driver.findElement(RegisterPage.inputChechBoxPrivacyPo);
        WebElement btnRegister = driver.findElement(RegisterPage.btnRegister);


        User data= dataFaker.getNewUser();

        //WebElement selectCountry = driver.findElement(By.cssSelector("select[name='countryListboxRegisterPage']"));
        inputFirstName.sendKeys(data.getFirstName());
        inputLastName.sendKeys(data.getLastName());
        inputEmail.sendKeys("pruebasqa2025@gmail");
        inputPhoneNumber.sendKeys(data.getTelephone());
        inputPassword.sendKeys(data.getPassword());
        inputConfirmPassword.sendKeys(data.getPasswordconfirm());
        radioSuscribe.click();
        chechBoxPrivacyPo.click();
        btnRegister.submit();

        WebElement inputEmailValidate = driver.findElement(RegisterPage.inputEmailValidate);

        if(inputEmailValidate.isDisplayed()){
            assertEquals(inputEmailValidate.getText(),inputEmailInvalidMessage);
        }
    }

    @Test(description = "TC-Register-05 - Confirmación de contraseña",groups = "Functional")
    public void registerPasswordConfimTest(){

        WebElement inputFirstName = driver.findElement(RegisterPage.inputFirstName);
        WebElement inputLastName = driver.findElement(RegisterPage.inputLastName);
        WebElement inputEmail = driver.findElement(RegisterPage.inputEmail);
        WebElement inputPhoneNumber = driver.findElement(RegisterPage.inputPhoneNumber);
        WebElement inputPassword = driver.findElement(RegisterPage.inputPassword);
        WebElement inputConfirmPassword = driver.findElement(RegisterPage.inputConfirmPassword);
        WebElement radioSuscribe = driver.findElement(RegisterPage.inputRadioSuscribe);
        WebElement chechBoxPrivacyPo = driver.findElement(RegisterPage.inputChechBoxPrivacyPo);
        WebElement btnRegister = driver.findElement(RegisterPage.btnRegister);


        User data= dataFaker.getNewUser();

        //WebElement selectCountry = driver.findElement(By.cssSelector("select[name='countryListboxRegisterPage']"));
        inputFirstName.sendKeys(data.getFirstName());
        inputLastName.sendKeys(data.getLastName());
        inputEmail.sendKeys(data.getEmail());
        inputPhoneNumber.sendKeys(data.getTelephone());
        inputPassword.sendKeys("");
        inputConfirmPassword.sendKeys("123456789");
        radioSuscribe.click();
        chechBoxPrivacyPo.click();
        btnRegister.submit();

        WebElement inputPasswordConfimValidate = driver.findElement(RegisterPage.inputConfirmPasswordValidate);
        WebElement inputPasswordValidate = driver.findElement(RegisterPage.inputPasswordValidate);


        if(inputPasswordConfimValidate.isDisplayed() && inputPasswordValidate.isDisplayed()){
            softAssertValidationInputs.assertEquals(inputPasswordValidate.getText(),inputPasswordEmpyMessage);
            softAssertValidationInputs.assertEquals(inputPasswordConfimValidate.getText(),textValidatePasswordConfim);
            softAssertValidationInputs.assertAll();
        }
    }

    @Test(description = "TC-Register-06 - Correo electrónico único",groups = "Functional")
    public void registerValidateUniqueEmailTest(){
        WebElement inputFirstName = driver.findElement(RegisterPage.inputFirstName);
        WebElement inputLastName = driver.findElement(RegisterPage.inputLastName);
        WebElement inputEmail = driver.findElement(RegisterPage.inputEmail);
        WebElement inputPhoneNumber = driver.findElement(RegisterPage.inputPhoneNumber);
        WebElement inputPassword = driver.findElement(RegisterPage.inputPassword);
        WebElement inputConfirmPassword = driver.findElement(RegisterPage.inputConfirmPassword);

        WebElement radioSuscribe = driver.findElement(RegisterPage.inputRadioSuscribe);
        WebElement chechBoxPrivacyPo = driver.findElement(RegisterPage.inputChechBoxPrivacyPo);
        WebElement btnRegister = driver.findElement(RegisterPage.btnRegister);


        User data= dataFaker.getNewUser();

        //WebElement selectCountry = driver.findElement(By.cssSelector("select[name='countryListboxRegisterPage']"));
        inputFirstName.sendKeys(data.getFirstName());
        inputLastName.sendKeys(data.getLastName());
        //El correo ya se encuentra registrado
        inputEmail.sendKeys("pepe1234@hotmail.com");
        inputPhoneNumber.sendKeys(data.getTelephone());
        inputPassword.sendKeys(data.getPassword());
        inputConfirmPassword.sendKeys(data.getPasswordconfirm());
        radioSuscribe.click();
        chechBoxPrivacyPo.click();
        btnRegister.submit();

        WebElement textValidatEmailEiting = driver.findElement(By.cssSelector(".alert"));

        assertEquals(textValidatEmailEiting.getText(),textValidateEmailExiting);

    }

}
