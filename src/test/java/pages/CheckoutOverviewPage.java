package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private By itemNameLocator = By.cssSelector(".inventory_item_name");
    private By itemDescriptionLocator = By.cssSelector(".inventory_item_desc");
    private By itemPriceLocator = By.cssSelector(".inventory_item_price");
    private By itemTotalPriceLocator = By.cssSelector(".summary_info_label.summary_total_label");
    private By finishButtonLocator = By.id("finish");
    private By cancelButtonLocator = By.id("cancel");

    public boolean finishButtonIsDisplayed() {
        return driver.findElement(finishButtonLocator).isDisplayed();
    }

    @Step
    public String getItemName() {
        return driver.findElement(itemNameLocator).getText();
    }

    @Step
    public String getItemDescription() {
        return driver.findElement(itemDescriptionLocator).getText();
    }

    @Step
    public String getItemPrice() {
        return driver.findElement(itemPriceLocator).getText();
    }

    @Step
    public String getTotalPrice() {
        return driver.findElement(itemTotalPriceLocator).getText();
    }

    @Step
    public void clickCancelButton() {
        driver.findElement(cancelButtonLocator).click();
    }

    @Step
    public void clickFinishButton() {
        driver.findElement(finishButtonLocator).click();
    }
}
