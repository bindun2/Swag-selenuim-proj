package Base;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckout() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        InventoryPage inv = new InventoryPage(driver);
        inv.addItemToCartByIndex(0);
        inv.goToCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.getCartItemCount() > 0, "Cart should not be empty.");
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillInformation("Bindu","Neupane","44600");
        checkout.finish();

        String confirm = checkout.getConfirmationText();
        Assert.assertTrue(confirm.toLowerCase().contains("thank you for your order") ||
                confirm.toLowerCase().contains("order"), "Confirmation expected. Got: " + confirm);
    }
}


