package Pages;

import org.openqa.selenium.*;

public class CheckoutPage {
    private WebDriver driver;
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postal = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By confirmationHeader = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) { this.driver = driver; }

    public void fillInformation(String f, String l, String p) {
        driver.findElement(firstName).sendKeys(f);
        driver.findElement(lastName).sendKeys(l);
        driver.findElement(postal).sendKeys(p);
        driver.findElement(continueBtn).click();
    }

    public void finish() { driver.findElement(finishBtn).click(); }

    public String getConfirmationText() {
        try { return driver.findElement(confirmationHeader).getText(); }
        catch (NoSuchElementException e) { return ""; }
    }
}