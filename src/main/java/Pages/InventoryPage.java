package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

    public class InventoryPage {
        private WebDriver driver;
        private By productNames = By.cssSelector(".inventory_item_name");
        private By addToCartButtons = By.cssSelector(".btn_inventory");
        private By sortDropdown = By.cssSelector(".product_sort_container");
        private By cartIcon = By.cssSelector(".shopping_cart_link");
        private By prices = By.cssSelector(".inventory_item_price");

        public InventoryPage(WebDriver driver) { this.driver = driver; }

        public void sortBy(String visibleText) {
            Select select = new Select(driver.findElement(sortDropdown));
            select.selectByVisibleText(visibleText);
        }

        public List<String> getAllProductNames() {
            List<WebElement> elems = driver.findElements(productNames);
            return elems.stream().map(WebElement::getText).collect(Collectors.toList());
        }

        public List<String> getAllPrices() {
            List<WebElement> elems = driver.findElements(prices);
            return elems.stream().map(WebElement::getText).collect(Collectors.toList());
        }

        public void addItemToCartByIndex(int index) {
            driver.findElements(addToCartButtons).get(index).click();
        }

        public void goToCart() {
            driver.findElement(cartIcon).click();
        }
    }


