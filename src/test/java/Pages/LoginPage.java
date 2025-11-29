package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    // Locators
    By emailInput = By.id("input-email");
    By passwordInput = By.id("input-password");
    By loginButton = By.cssSelector("button[type='submit']");
    By accountDropdown = By.cssSelector("a[title='My Account']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("http://localhost/opencartproject/index.php?route=account/login&language=en-gb");
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }


    public void login(String username, String password) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(username);

        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);

        driver.findElement(loginButton).click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(accountDropdown));
    }

    public boolean isUserLoggedIn() {
        return driver.findElements(accountDropdown).size() > 0;
    }

    public void loginIfNotAlready(String username, String password) {
        if (!isUserLoggedIn()) {
            login(username, password);
        }
    }
}
