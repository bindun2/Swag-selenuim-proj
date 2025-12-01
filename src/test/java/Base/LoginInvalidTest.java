package Base;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginInvalidTest extends BaseTest {

    @Test
    public void loginLockedUserShowsError() {
        LoginPage login = new LoginPage(driver);

        login.enterUsername("locked_out_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        String err = login.getErrorMessageText();

        Assert.assertTrue(err.length() > 0, "Error message should be shown");

        Assert.assertTrue(
                err.toLowerCase().contains("locked"),
                "Epic sadface: Sorry, this user has been locked out: " + err
        );
    }
}
