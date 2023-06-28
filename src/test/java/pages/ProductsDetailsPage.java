package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsDetailsPage extends BasePage{

    public ProductsDetailsPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButtonLocator = By.cssSelector("button[id |= 'add-to-cart'");
    private By backToProductsLocator = By.id("back-to-products");

    public boolean addToCartButtonIsDisplayed() {
        return driver.findElement(addToCartButtonLocator).isDisplayed();
    }
    public boolean backToProductsButtonIsDisplayed() {
        return driver.findElement(backToProductsLocator).isDisplayed();
    }
}
