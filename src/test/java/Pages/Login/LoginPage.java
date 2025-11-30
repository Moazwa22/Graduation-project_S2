package Pages.Login;

import Pages.MyAccount.MyAccountPage;
import Pages.SharedComponents.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Utilities {
    By emailLocator = By.id("input-email");
    By passwordLocator = By.id("input-password");
    By loginButtonLocator = By.xpath("//button[@class='btn btn-primary']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterValidEmail (String email){
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void enterValidPassword (String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public MyAccountPage clickLoginButton (){
        driver.findElement(loginButtonLocator).click();
        return new MyAccountPage(driver);
    }
}
