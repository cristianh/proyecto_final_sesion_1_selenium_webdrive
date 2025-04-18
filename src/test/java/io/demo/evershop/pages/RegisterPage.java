package io.demo.evershop.pages;

import com.demo.nopcommerce.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class RegisterPage extends BasePage{


    //Locators
    public static By btnMenuAccount = By.cssSelector("a[title='My Account']");
    public static By btnMenuAccountRegister = By.cssSelector("a[title='My Account'] +ul >li:first-child a");
    public static By btnMenuAccountOut = By.cssSelector("a[title='My Account'] +ul >li:last-child a");
    public static By inputFirstName = By.cssSelector("#input-firstname");
    public static By inputLastName =  By.cssSelector("#input-lastname");
    public static By inputEmail = By.cssSelector("#input-email");
    public static By inputPhoneNumber = By.cssSelector("#input-telephone");
    public static By inputPassword = By.cssSelector("#input-password");
    public static By inputConfirmPassword = By.cssSelector("#input-confirm");
    public static By inputRadioSuscribe = By.cssSelector("input[type='radio'][name='newsletter']");
    public static By inputChechBoxPrivacyPo = By.cssSelector("input[type='checkbox'][name='agree']");
    public static By btnRegister = By.cssSelector("input[type='submit'");

    //Message Validation inputs error
    public static By inputFirstNameValidate = By.cssSelector("#input-firstname + div");
    public static By inputLastNameValidate =  By.cssSelector("#input-lastname + div");
    public static By inputEmailValidate = By.cssSelector("#input-email + div");
    public static By inputPhoneNumberValidate = By.cssSelector("#input-telephone + div");
    public static By inputPasswordValidate = By.cssSelector("#input-password + div");
    public static By inputConfirmPasswordValidate = By.cssSelector("#input-confirm + div");
    public static By inputRadioSuscribeValidate = By.cssSelector("input[type='radio'][name='newsletter']");
    public static By inputChechBoxPrivacyPoValidate = By.cssSelector("input[type='checkbox'][name='agree']");

    //Validation input empys
    public static String inputFirstNameEmpyMessage = "First Name must be between 1 and 32 characters!";
    public static String inputLastNameEmpyMessage = "Last Name must be between 1 and 32 characters!";
    public static String inputEmailEmpyMessage = "E-Mail Address does not appear to be valid!";
    public static String inputTelephoneEmpyMessage = "Telephone must be between 3 and 32 characters!";
    public static String inputPasswordEmpyMessage = "Password must be between 4 and 20 characters!";
    public static String inputEmailInvalidMessage = "E-Mail Address does not appear to be valid!";

    public static String textValidateRegister = "Congratulations! Your new account has been successfully created!";
    public static String titleValidateRegister = "Your Account Has Been Created!";
    public static String textValidatePasswordConfim = "Password confirmation does not match password!";
    public static String textValidateEmailExiting = "Warning: E-Mail Address is already registered!";

    //Mensaje alert
    public static By textValidateMessageAlert=  By.cssSelector(".alert");
    public static By textValidateRegisterSuccess=  By.cssSelector("#content p:first-of-type");



    public RegisterPage(WebDriver driver) {
        super(driver);
        System.out.println("Pasa por aqui");
        //visit(urlBase);
    }

    public void fillFormRegister(User userlogin){
        //Address data
        //WebElement selectCountry = driver.findElement(By.cssSelector("select[name='countryListboxRegisterPage']"));
        type(inputFirstName,userlogin.getFirstName());
        type(inputLastName,userlogin.getLastName());
        type(inputEmail,userlogin.getEmail());
        type(inputPhoneNumber,userlogin.getTelephone());
        type(inputPassword,userlogin.getPassword());
        type(inputConfirmPassword,userlogin.getPasswordconfirm());
    }

    public void clickMyAccount(){
        click(btnMenuAccount);
    }

    public void clickMyAccountRegister(){
        click(btnMenuAccountRegister);
    }

    public void clickMyAccountOut(){
        click(btnMenuAccountOut);
    }

    public void clickRadioButtonSuscribe(){
        click(inputRadioSuscribe);
    }

    public void clickCheckBoxPrivacite(){
        click(inputChechBoxPrivacyPo);
    }

    public void clickButtonSubmit(){
        click(btnRegister);
    }

}
