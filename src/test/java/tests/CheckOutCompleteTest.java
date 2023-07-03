package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutCompleteTest extends BaseTest{
    @Test(groups = {"smoke"}, description = "тест навыполнение заказа")
    public void positiveCompleteTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickCheckOutButton();
        checkOutYourInformationPage.checkOut(FIRSTNAME, LASTNAME, ZIPCODE);
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.completeTextIsDisplayed());
        Assert.assertTrue(checkoutCompletePage.backHomeButtonIsDisplayed());
    }
}
