package io.demo.evershop.test;

import org.testng.annotations.Test;

import static io.demo.evershop.pages.LoginPage.messageSuccessLogin;
import static io.demo.evershop.pages.LoginPage.textValidateSuccessCredencials;
import static io.demo.evershop.pages.OrdersPage.*;

public class OrdersTest extends BaseTest {

    @Test(description = "TC-Order-01 - Añadir productos al carrito", groups = {"Regression"})
    public void orderAddCardProductTest() {
        loginpage.clickMyAccount();
        loginpage.clickMyAccountLogin();
        loginpage.fillFormLogin();
        loginpage.clickButtonSubmit();
        loginpage.validateMessage(messageSuccessLogin, textValidateSuccessCredencials);
        orderpage.clickHome();
        orderpage.clickElementPageOrder(3);
        orderpage.selectPropertyPageShopping();
        orderpage.clickAddCardItem();
        orderpage.validateMessage(messageSuccesProductShoppingCard, textValidateProductShoppingCard);
    }

    @Test(description = "TC-Order-02 - Eliminar productos del carrito", dependsOnMethods = "orderAddCardProductTest", groups = {"Regression"})
    public void orderDeleteCardProductTest() {
        orderpage.clickCardViewShopping();
        orderpage.clickViewCardShoppingPage();
        orderpage.validateMessage(titlePageShopping, textValidatePageShopping);
        orderpage.validateDeleteItemCardShopping();
        orderpage.validateMessage(messagePageShoppingEmpty, textValidateEmpyProductShopping);
        loginpage.clickMyAccount();
        loginpage.clickMyAccountOut();
    }

    @Test(description = "TC-Order-03 - Modificar cantidad de productos en el carrito", dependsOnMethods = "orderAddCardProductTest", groups = {"Functional"})
    public void orderCountProductsShoppingTest() {
        orderpage.clickCardViewShopping();
        orderpage.clickViewCardShoppingPage();
        orderpage.fillUpdateQyItem();
        orderpage.validateUpdateItemCardShopping();
        orderpage.validateMessage(messageSuccessUpdate, textValidateUpdayeQyProductShopping);
        orderpage.clickHome();
        loginpage.clickMyAccount();
        loginpage.clickMyAccountOut();
    }

    @Test(description = "TC-Order-04 - Creación de orden exitosa ", groups = {"Regression"})
    public void orderSuccesProcessProductsShoppingTest() {
        loginpage.fillFormLogin();
        loginpage.clickButtonSubmit();
        loginpage.validateMessage(messageSuccessLogin, textValidateSuccessCredencials);
        orderpage.clickHome();
        //Seleccionamos la mackbook
        orderpage.clickElementPageOrder(0);
        orderpage.clickAddCardItem();
        orderpage.clickHome();
        //Seleccionamos la iPhone
        orderpage.clickElementPageOrder(1);
        orderpage.clickAddCardItem();
        orderpage.clickHome();
        //Seleccionamos la camara
        orderpage.clickElementPageOrder(3);
        orderpage.selectPropertyPageShopping();
        orderpage.clickAddCardItem();
        orderpage.clickHome();
        orderpage.clickCardViewShopping();
        orderpage.clickViewCheckoutPage();
        orderpage.selectRadioNewAddress();
        orderpage.fillFormOrderProcess();
        orderpage.selectCountry();
        orderpage.selectCountryZone();
        orderpage.clickContinueAddress();
        orderpage.selectDeliveryDetails();
        orderpage.clickDeliveyDetails();
        orderpage.textAreaDeliveryMethod();
        orderpage.clickDeliveryMethod();
        orderpage.clickCheckBoxPrivacite();
        orderpage.clickPayMenthod();
        orderpage.clickConfirmOrder();
        orderpage.validateMessageSuccessOrder();
        orderpage.clickBtnConfirmReturnHome();
        loginpage.clickMyAccount();
        loginpage.clickMyAccountOut();
    }
}
