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
    public static By inputQyItemProductShoppingPage = By.cssSelector("input[type='text'][value='1']");

    public List<WebElement> cardProductsElement;


    public static String textValidateProductShoppingCard = "Success: You have added Canon EOS 5D to your shopping cart!";
    public static String textValidatePageShopping = "Your Store";
    public static String textValidateEmpyProductShopping = "Your shopping cart is empty!";
    public static String textValidateUpdayeQyProductShopping = "Success: You have modified your shopping cart!";


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

    public void clickAddCardItem() {
        click(btnCardShopping);
    }

    public void clickCardViewShopping() {
        click(btnCardViewShopping);
    }

    public void clickViewCardShoppingPage() {
        click(btnViewCardShoppingPage);
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


    public void clickBtnConfirmReturnHome() {
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

}
