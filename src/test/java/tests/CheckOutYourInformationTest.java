package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutYourInformationTest extends BaseTest{
    @Test(groups = {"smoke"}, description = "тест формы checkOut")
    public void positiveCheckout() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickCheckOutButton();
        checkOutYourInformationPage.setFirstNameValue(FIRSTNAME);
        checkOutYourInformationPage.setLastNameValue(LASTNAME);
        checkOutYourInformationPage.setPostalCodeValue(ZIPCODE);
        checkOutYourInformationPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.finishButtonIsDisplayed());
    }

    @Test(groups = {"regression"}, description = "тест кнопки cancel")
    public void cancelButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickCheckOutButton();
        checkOutYourInformationPage.clickCancelButton();
        Assert.assertTrue(cartPage.isContinueShoppingIsDisplayed());
    }
}
