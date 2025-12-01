package Base;

import Pages.InventoryPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FilterProductsTest extends BaseTest {

    @Test
    public void filterNameAndPrice() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        InventoryPage inv = new InventoryPage(driver);
        inv.sortBy("Name (Z to A)");
        List<String> namesDesc = inv.getAllProductNames();
        Assert.assertTrue(namesDesc.size() > 1, "There should be multiple products");

        boolean descending = true;
        for (int i = 0; i < namesDesc.size()-1; i++) {
            if (namesDesc.get(i).compareTo(namesDesc.get(i+1)) < 0) {
                descending = false;
                break;
            }
        }
        Assert.assertTrue(descending, "Product names should be in descending order (Z to A).");

        // Sort: Price (low to high)
        inv.sortBy("Price (low to high)");
        List<String> prices = inv.getAllPrices(); // e.g. "$7.99"
        double prev = -1.0;
        for (String p : prices) {
            double val = Double.parseDouble(p.replace("$",""));
            if (prev >= 0) {
                Assert.assertTrue(val >= prev, "Prices should be non-decreasing");
            }
            prev = val;
        }
    }
}

