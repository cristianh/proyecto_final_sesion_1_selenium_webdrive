package io.demo.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPage extends BasePage {

    public static By inputEmailForgotPassword = By.cssSelector("#input-email");
    public static By btnContinue = By.cssSelector("input[type='submit']");

    public ForgotPage(WebDriver driver) {
        super(driver);
    }

    public void fillFormForgotPassword(String email) {
        type(inputEmailForgotPassword, email);
    }

    public void clickButtonSubmit() {
        click(btnContinue);
    }

}
