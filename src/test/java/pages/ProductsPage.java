package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    private By shoppingCartLink = By.cssSelector("a.shopping_cart_link");
    private By itemsLocator = By.cssSelector(".inventory_item");
    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By addToCartItemLocator = By.cssSelector("button[id|='add-to-cart']");
    private By removeItemLocator = By.cssSelector("button[id|='remove']");
    private By getItemPriceLocator = By.cssSelector(".inventory_item_price");
    private By getItemDescription = By.cssSelector(".inventory_item_desc");
    private By titleOfPageLocator = By.cssSelector(".title");

    public ProductsPage(WebDriver driver) {
        super (driver);
    }

    @Step
    public void clickAddToCartButton(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(addToCartItemLocator).click();
    }

    @Step
    public void clickRemoveButton(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(removeItemLocator).click();
    }

    @Step
    public void openItem(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        itemContainer.findElement(itemNameLocator).click();
    }

    @Step
    public String getItemPrice(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        return itemContainer.findElement(getItemPriceLocator).getText();
    }

    @Step
    public String getItemDescription(String itemName) {
        WebElement itemContainer = getItemContainerByName(itemName);
        return itemContainer.findElement(getItemDescription).getText();
    }


    private WebElement getItemContainerByName(String itemName) {
        List<WebElement> allItems = driver.findElements(itemsLocator);
        for (WebElement item : allItems) {
            if(item.findElement(itemNameLocator).getText().equals(itemName));
            return item;
        }
        return null;
    }
    public boolean isShoppingCartLinkDisplayed() {
        return driver.findElement(shoppingCartLink).isDisplayed();
    }

    @Step
    public void clickShoppingCartLink(String testItemName) {
        driver.findElement(shoppingCartLink).click();
    }

    public boolean removeButtonIsDisplayed() {
        return driver.findElement(removeItemLocator).isDisplayed();
    }
    public boolean addToCartButtonIsDisplayed() {
        return driver.findElement(addToCartItemLocator).isDisplayed();
    }
    public boolean titleOfPageIsDisplayed() {
        return driver.findElement(titleOfPageLocator).isDisplayed();
    }
}

/* OR
    private WebElement getItemContainerByName(String itemName) {
        return driver.findElement(By.xpath(String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']", itemName)));
    }*/



