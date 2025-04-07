package io.demo.evershop.pages;

import org.openqa.selenium.By;

public class RegisterPage {
    //Locators
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


}
