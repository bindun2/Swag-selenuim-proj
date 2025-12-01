package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String u) {
        driver.findElement(username).sendKeys(u);
    }

    public void enterPassword(String p) {
        driver.findElement(password).sendKeys(p);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessageText() {
        try {
            return driver.findElement(errorMsg).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isOnInventory() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
}
