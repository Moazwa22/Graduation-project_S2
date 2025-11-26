package Pages.Home;

import Pages.MyAccount.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By MyAccountLocator = By.linkText("My Account");
    By LoginLocator = By.xpath("//a[@class='dropdown-item' and text()='Login']");
    By RegisterLocator = By.xpath("//a[@class='dropdown-item' and text()='Register']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void  ClickOnMyAccountIcon(){
        driver.findElement(MyAccountLocator).click();
    }

    public LoginPage  ClickOnLogin(){
        driver.findElement(LoginLocator).click();
        return new LoginPage(driver);
    }
    public void clickOnRegister()
    {
        driver.findElement(RegisterLocator).click();
    }



}
