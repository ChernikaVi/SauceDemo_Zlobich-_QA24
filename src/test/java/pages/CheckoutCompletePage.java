package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    private By backHomeButtonLocator = By.id("back-to-products");
    private By completeTextLocator = By.cssSelector(".complete-header");

    public boolean backHomeButtonIsDisplayed() {
        return driver.findElement(backHomeButtonLocator).isDisplayed();
    }
    public boolean completeTextIsDisplayed() {
        return driver.findElement(completeTextLocator).isDisplayed();
    }
}
