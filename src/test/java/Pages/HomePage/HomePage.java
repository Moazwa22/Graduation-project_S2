package Pages.HomePage;

import Pages.CheckOut.CheckoutPage;
import Pages.LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;



    By myAccount = By.xpath("//span[contains(text(), 'My Account')]");

    By loginButton = By.linkText("Login");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public LoginPage login(){
        driver.findElement(myAccount).click();
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
