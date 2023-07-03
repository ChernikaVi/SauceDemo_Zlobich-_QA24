package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class CartTests extends BaseTest {
    @Test(groups = {"regression"}, description = "тест формы cart")
    public void cartTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);

        String actualItemName = cartPage.getItemName();
        String expectedItemName = "Sauce Labs Backpack";
        Assert.assertEquals(actualItemName, expectedItemName);

        String actualItemDescription = cartPage.getItemDescription();
        String expectedItemDescription = "carry.allTheThings() with the sleek, streamlined Sly " +
                "Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(actualItemDescription, expectedItemDescription);

        String actualItemPrice = cartPage.getItemPrice();
        String expectedItemPrice = "$29.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
    }

    @Test(groups = {"smoke"}, description = "тест кнопки CheckOut")
    public void checkOutButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutYourInformationPage.firstNameInputIsDisplayed());
        Assert.assertTrue(checkOutYourInformationPage.lastNameInputIsDisplayed());
    }

    @Test(groups = {"smoke"}, description = "тест кнопки continueShopping")
    public void continueShoppingButtonTest() {
        String testItemName = "Sauce Labs Backpack";
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickAddToCartButton(testItemName);
        productsPage.clickShoppingCartLink(testItemName);
        cartPage.clickContinueShoppingButton();
        productsPage.getItemDescription(testItemName);
        Assert.assertTrue(productsPage.titleOfPageIsDisplayed());
    }
}
