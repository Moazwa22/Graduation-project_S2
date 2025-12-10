package Pages.LoginPage;

import Pages.CheckOut.CheckoutPage;
import Pages.HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By emaillocator = By.id("input-email");

    By passwordLocator = By.id("input-password");

    By loginButtonLocator = By.xpath("//button[@class='btn btn-primary']");

    By addToCartLocator = By.xpath("//*[@id='content']/div[2]/div[2]/div/div[2]/form/div/button[1]");

    By homeButtonLocator = By.xpath("//img[@src='http://localhost/opencart/image/catalog/opencart-logo.png']");
    By cartIconLocator = By.xpath("//span[contains(text(), 'Checkout')]");

    By accountPageLocator = By.tagName("h1");
    String expectedTitleOfMyAccountPage =  "My Account";

    String email = "test9@test.com";
    String password = "testtest";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Login(){
        driver.findElement(emaillocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void pressLogin(){
        driver.findElement(loginButtonLocator).click();
    }

    public void returnToHomaPage(){
        driver.findElement(homeButtonLocator).click();
    }

    public void addItem(){
        driver.findElement(addToCartLocator).click();
    }

    public CheckoutPage checkout(){
        driver.findElement(cartIconLocator).click();
        return new CheckoutPage(driver);
    }

    public String actualTitleOfAccountPage(){
        return driver.findElement(accountPageLocator).getText();
    }

    public String getExpectedTitleOfMyAccountPage(){
        return expectedTitleOfMyAccountPage;
    }

}
