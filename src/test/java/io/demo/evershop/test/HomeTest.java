package io.demo.evershop.test;

import com.demo.nopcommerce.models.User;
import io.demo.evershop.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class HomeTest extends BaseTest {

    @Test(description = "TC-Register-01 - Registro exitoso")
    public void registerTest(){

        User data= dataFaker.getNewUser();

        //Damos clic en el boton de registro.
        WebElement btnUser = driver.findElement(By.cssSelector("#hrefUserIcon"));
        btnUser.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(34000));

        Boolean isVisibleRegister = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'CREATE NEW ACCOUNT')]")));
        if(isVisibleRegister){
            WebElement btnRegistar =  driver.findElement(By.xpath("//*[contains(text(), 'CREATE NEW ACCOUNT')]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", btnRegistar);
        }

        WebElement inputUserName = driver.findElement(By.cssSelector("input[name='usernameRegisterPage']"));
        WebElement inputEmail = driver.findElement(By.cssSelector("input[name='emailRegisterPage']"));
        WebElement inputPassword = driver.findElement(By.cssSelector("input[name='passwordRegisterPage']"));
        WebElement inputConfirmPassword = driver.findElement(By.cssSelector("input[name='confirm_passwordRegisterPage']"));
        WebElement inputFirstName = driver.findElement(By.cssSelector("input[name='first_nameRegisterPage']"));
        WebElement inputLastName = driver.findElement(By.cssSelector("input[name='last_nameRegisterPage']"));
        WebElement inputPhoneNumber = driver.findElement(By.cssSelector("input[name='phone_numberRegisterPage']"));
        WebElement radioIgree = driver.findElement(By.cssSelector("input[type='checkbox'][name='i_agree']"));
        WebElement btnRegister = driver.findElement(By.cssSelector("#register_btn"));

        //Address data
        //WebElement selectCountry = driver.findElement(By.cssSelector("select[name='countryListboxRegisterPage']"));

        inputUserName.sendKeys(data.getFirstName());
        inputEmail.sendKeys(data.getEmail());
        inputPassword.sendKeys(data.getPassword());
        inputConfirmPassword.sendKeys(data.getPasswordconfirm());
        inputFirstName.sendKeys(data.getFirstName());
        inputLastName.sendKeys(data.getLastName());
        inputPhoneNumber.sendKeys(data.getTelephone());


        //Bajamos hasta el select
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", radioIgree);
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight * 0.7);");

        System.out.println(radioIgree.isDisplayed());
        if(radioIgree.isDisplayed()){
            js.executeScript("arguments[0].click();", radioIgree);
            //radioIgree.click();
        }

        //Select selectCountryInput = new Select(selectCountry);
        //selectCountryInput.selectByVisibleText("Colombia");

        //btnRegister.click();
        js.executeScript("arguments[0].click();", btnRegister);


        Boolean isLoginUser = driver.findElement(By.cssSelector("#menuUserLink > span")).isDisplayed();

        if (isLoginUser) {
            WebElement loginUser =  driver.findElement(By.cssSelector("#menuUserLink > span"));
            String textloginUser = loginUser.getText();
            assertEquals(textloginUser,data.getFirstName());
        }

    }
}
