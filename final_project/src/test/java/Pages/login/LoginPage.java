package Pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
        WebDriver driver;
        By userNameLocator = By.id("input-email");
        By passwordLocator = By.id("input-password");
        By loginButtonLocator = By.xpath("//button[text()='Login']");

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void enterUserName(String userName) {
            driver.findElement(userNameLocator).sendKeys(userName);
        }

        public void enterPassword(String password) {
            driver.findElement(passwordLocator).sendKeys(password);
        }

        public void clickLoginButton() {
            driver.findElement(loginButtonLocator).click();
        }
    }