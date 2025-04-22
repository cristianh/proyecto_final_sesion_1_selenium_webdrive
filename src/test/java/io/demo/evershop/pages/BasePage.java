package io.demo.evershop.pages;

import io.demo.evershop.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.demo.evershop.Variables.*;
import static io.demo.evershop.pages.LoginPage.textValidateSuccessCredencials;

public class BasePage extends BaseTest {

    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
    }

    public void visit(String urlBase){
        //Especificamo un tiempo de espera a que los elementos esten presentes en la pagina
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        // Crear una espera explícita
        //waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_EXPLICIT));
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public void click(By element) {
        find(element).click();
    }

    public void submit(By element) {
        find(element).submit();
    }

    public void type(By element, String text) {
        find(element).clear();
        find(element).sendKeys(text);
    }

    public boolean isDisplayElement(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(By element){
        return find(element).getText();
    }

    public boolean isDisplayText(By locator,String text){
        try {
            wait.until(ExpectedConditions.invisibilityOfElementWithText(locator,text));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
