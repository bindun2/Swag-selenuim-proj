package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By cartItems = By.cssSelector(".cart_item");
    private By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) { this.driver = driver; }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
