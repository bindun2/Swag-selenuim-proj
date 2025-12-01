package Base;

import Pages.LoginPage;
import Pages.InventoryPage;
import Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void addMultipleItemsToCart() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        InventoryPage inv = new InventoryPage(driver);
        inv.addItemToCartByIndex(0);
        inv.addItemToCartByIndex(1);
        inv.goToCart();

        CartPage cart = new CartPage(driver);
        Assert.assertEquals(cart.getCartItemCount(), 2, "Cart should contain 2 items.");
    }
}
