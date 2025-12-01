package Base;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginValidTest extends BaseTest {

    @Test
    public void loginWithValidUser() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        Assert.assertTrue(login.isOnInventory(), "After successful login user should be on inventory page.");
    }
}

