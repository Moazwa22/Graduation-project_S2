package Pages.MyAccount;

import Pages.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    By EmailLocator = By.id("input-email");
    By PasswordLocator =By.id("input-password");
    By LoginButtonLocator = By.xpath("//button[text()='Login']");
    By HomePageIcon = By.xpath("//a[contains(@href,'route=common/home')]");
    By ContinueButtonLocator = By.linkText("Continue");
    By ForgottenPasswordLocator = By.xpath("//form[@id='form-login']//a[text()='Forgotten Password']");


    By LoginLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Login']");
    By RegisterLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Register']");
    By ForgottenPasswordLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Forgotten Password']");


     public void enterEmail(String email) {

         driver.findElement(EmailLocator).sendKeys(email);
     }
     public void enterPassword(String password){

         driver.findElement(PasswordLocator).sendKeys(password);
     }

     public void clickOnLoginButton(){

         driver.findElement(LoginButtonLocator).click();
     }
     public void clickOnHomePageIcon() {

         driver.findElement(HomePageIcon).click();
     }
     public void clickOnContinueButton(){
         driver.findElement(ContinueButtonLocator).click();
         new RegisterPage(driver);
     }
    public MyAccountPage userRedirectionToMyAccountPage() {
         driver.findElement(LoginButtonLocator).click();
        return new MyAccountPage(driver);
     }
    public ForgottenPasswordPage clickOnForgottenPasswordBlueLink (){
         driver.findElement(ForgottenPasswordLocator).click();
         return new ForgottenPasswordPage(driver);
    }

}
