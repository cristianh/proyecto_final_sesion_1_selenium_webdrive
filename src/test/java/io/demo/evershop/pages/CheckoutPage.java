package io.demo.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutPage extends BasePage {

    //formulario pedido:
    public static By radioNewAddress = By.cssSelector("input[value='new']");
    public static By inputFirstName = By.cssSelector("#input-payment-firstname");
    public static By inputLastName = By.cssSelector("#input-payment-lastname");
    public static By inputCompany = By.cssSelector("#input-payment-company");
    public static By inputAddress = By.cssSelector("#input-payment-address-1");
    public static By inputCity = By.cssSelector("#input-payment-city");
    public static By inputSelectCountry = By.cssSelector("#input-payment-country");
    public static By inputSelectCountryZone = By.cssSelector("#input-payment-zone");
    public static By btnPaymentAddress = By.cssSelector("#button-payment-address");
    public static By btnShippingAddress = By.cssSelector("#button-shipping-address");
    public static By btnShippingMethod = By.cssSelector("#button-shipping-method");
    public static By btnPayMethod = By.cssSelector("#button-payment-method");
    public static By btnConfirmOrder = By.cssSelector("#button-confirm");
    public static By selectDeliveryDetails = By.cssSelector("#shipping-existing select[name='address_id']");
    public static By textAreaDeliveryMethod = By.cssSelector("textarea[name='comment']");
    public static By inputChechBoxPrivacyPo = By.cssSelector("input[type='checkbox'][name='agree']");


    public static By messageConfirmOrder = By.cssSelector("#content p:first-of-type");
    public static String textValidateMessague = "Your order has been successfully processed!";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void selectRadioNewAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(radioNewAddress));
        click(radioNewAddress);
    }


    public void fillFormOrderProcess() {
        type(inputFirstName, "Pedro");
        type(inputLastName, "Sanchez");
        type(inputCompany, "SQA.SAS");
        type(inputAddress, "Barrio las Acacias M 2 # 12");
        type(inputCity, "Armenia");
        type(inputCity, "Armenia");
    }


    public void selectCountry() {
        WebElement selectCountry = find(inputSelectCountry);
        Select selectInputCountry = new Select(selectCountry);
        selectInputCountry.selectByVisibleText("Colombia");
    }

    public void selectCountryZone() {
        WebElement selectZone = find(inputSelectCountryZone);
        selectZone.click();
        Select selectInputZone = new Select(selectZone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSelectCountryZone));
        selectInputZone.selectByVisibleText("Quindio");
    }

    public void selectDeliveryDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectDeliveryDetails));
        WebElement inputDeliveryDetails = find(selectDeliveryDetails);
        inputDeliveryDetails.click();
        Select selectDeliveryDetails = new Select(inputDeliveryDetails);
        selectDeliveryDetails.selectByIndex(1);
    }

    public void textAreaDeliveryMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textAreaDeliveryMethod));
        type(textAreaDeliveryMethod, "NA");
    }

    public void clickDeliveyDetails() {
        click(btnShippingAddress);
    }

    public void clickDeliveryMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnShippingMethod));
        click(btnShippingMethod);
    }

    public void clickContinueAddress() {
        click(btnPaymentAddress);
    }

    public void clickPayMenthod() {
        click(btnPayMethod);
    }

    public void clickConfirmOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnConfirmOrder));
        click(btnConfirmOrder);
    }

    public void clickCheckBoxPrivacite() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputChechBoxPrivacyPo));
        click(inputChechBoxPrivacyPo);
    }

    public void validateMessageSuccessOrder() {
        if (isDisplayElement(messageConfirmOrder))
            assertEquals(getText(messageConfirmOrder), textValidateMessague);
    }

}
