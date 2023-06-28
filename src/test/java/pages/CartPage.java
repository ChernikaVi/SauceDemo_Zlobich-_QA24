package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By itemDescriptionLocator = By.cssSelector(".inventory_item_desc");
    private By removeButtonLocator = By.cssSelector("button[id|='remove'");
    public By continueShoppingButton = By.cssSelector("#continue-shopping");
    private By checkOutButtonLocator = By.cssSelector("#checkout");

    @Step
    public String getItemName() {
        return driver.findElement(itemNameLocator).getText();
    }

    @Step
    public String getItemPrice() {
        return driver.findElement(itemPriceLocator).getText();
    }

    @Step
    public String getItemDescription() {
        return driver.findElement(itemDescriptionLocator).getText();
    }

    public void clickRemoveButton() {
        driver.findElement(removeButtonLocator).click();
    }

    @Step
    public void clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }
    public boolean isContinueShoppingIsDisplayed() {
        return driver.findElement(continueShoppingButton).isDisplayed();
    }

    @Step
    public void clickCheckOutButton() {
        driver.findElement(checkOutButtonLocator).click();
    }
}
