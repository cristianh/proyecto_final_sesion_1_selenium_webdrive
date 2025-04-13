package io.demo.evershop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.demo.evershop.Variables.TIME_OUT_EXPLICIT;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class OrdersPage extends BasePage {

    public static By messageSuccesProductShoppingCard = By.cssSelector(".alert");
    public static By linkHome = By.cssSelector(".breadcrumb li a");
    public static By cardProductsImage = By.cssSelector(".image");
    public static By selectProductItem = By.cssSelector("#input-option226");
    public static By btnCardShopping = By.cssSelector("#button-cart");
    public static By btnCardViewShopping = By.cssSelector("#cart");
    public static By btnRemoveProduct = By.cssSelector("button[data-original-title='Remove']");
    public static By btnUpdateProduct = By.cssSelector("button[data-original-title='Update']");
    public static By btnViewCardShoppingPage = By.xpath("//*[contains(text(), ' View Cart')]");
    public static By btnContinueReturnHome = By.xpath("//*[contains(text(), 'Continue')]");
    public static By btnViewCheckoutPage = By.xpath("//*[contains(text(), ' Checkout')]");
    public static By titlePageShopping = By.cssSelector("h1");
    public static By messagePageShoppingEmpty = By.cssSelector("#content p");
    public static By messageSuccessUpdate = By.cssSelector(".alert");
    public static By messageConfirmOrder = By.cssSelector("#content h1");
    public static By inputQyItemProductShoppingPage = By.cssSelector("input[type='text'][value='1']");

    public List<WebElement> cardProductsElement;

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

    public static String textValidateProductShoppingCard = "Success: You have added Canon EOS 5D to your shopping cart!";
    public static String textValidatePageShopping = "Your Store";
    public static String textValidateEmpyProductShopping = "Your shopping cart is empty!";
    public static String textValidateUpdayeQyProductShopping = "Success: You have modified your shopping cart!";
    public static String textValidateMessague= "Your order has been placed!";


    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_EXPLICIT));

    public OrdersPage(WebDriver driver) {
        super(driver);
    }


    public void clickHome() {
        click(linkHome);
    }

    public void clickElementPageOrder(int indexElement) {
        cardProductsElement = driver.findElements(cardProductsImage);
        System.out.println(cardProductsElement.get(indexElement));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = cardProductsElement.get(indexElement);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void selectPropertyPageShopping() {
        //Seleccionamos el color

        if (isDisplayElement(selectProductItem)) {
            Select selectColor = new Select(find(selectProductItem));
            selectColor.selectByValue("16");
        }
    }


    public void fillUpdateQyItem() {
        if (isDisplayElement(inputQyItemProductShoppingPage)) {
            type(inputQyItemProductShoppingPage, "3");
        }
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

    public void textAreaDeliveryMethod(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(textAreaDeliveryMethod));
        type(textAreaDeliveryMethod,"NA");
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

    public void clickAddCardItem() {
        click(btnCardShopping);
    }

    public void clickCardViewShopping() {
        click(btnCardViewShopping);
    }

    public void clickViewCardShoppingPage() {
        click(btnViewCardShoppingPage);
    }

    public void clickCheckBoxPrivacite(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputChechBoxPrivacyPo));
        click(inputChechBoxPrivacyPo);
    }

    public void clickViewCheckoutPage() {
        click(btnViewCheckoutPage);
    }

    public void clickRemoveItemPageShopping() {
        click(btnRemoveProduct);
    }

    public void clickUpdateItemPageShopping() {
        click(btnUpdateProduct);
    }

    public void clickPayMenthod(){
        click(btnPayMethod);
    }

    public void clickConfirmOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnConfirmOrder));
        click(btnConfirmOrder);
    }

    public void clickBtnConfirmReturnHome(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinueReturnHome));
        click(btnContinueReturnHome);
    }


    public void validateMessage(By element, String textValidate) {
        if (isDisplayElement(element))
            assertTrue(getText(element).contains(textValidate));
    }


    public void validateDeleteItemCardShopping() {
        WebElement waitElementCard = wait.until(ExpectedConditions.visibilityOfElementLocated(btnRemoveProduct));
        if (waitElementCard.isDisplayed()) {
            clickRemoveItemPageShopping();
        }
    }

    public void validateUpdateItemCardShopping() {
        WebElement waitElementCard = wait.until(ExpectedConditions.visibilityOfElementLocated(btnUpdateProduct));
        if (waitElementCard.isDisplayed()) {
            clickUpdateItemPageShopping();
        }
    }

    public void validateMessageSuccessOrder(){
        if (isDisplayElement(messageConfirmOrder))
            assertEquals(getText(messageConfirmOrder), textValidateMessague);
    }
}
