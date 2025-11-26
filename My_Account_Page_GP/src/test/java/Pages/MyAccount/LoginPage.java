package Pages.MyAccount;

import Pages.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    By WarningMessageLocator = By.xpath("//div[contains(@class,'alert-danger')]");

    //this to locators for the right list in the login page
    By LoginLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Login']");
    By RegisterLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Register']");
    By ForgottenPasswordLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Forgotten Password']");
    By PaymentMethodsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Payment Methods']");
    By AddressBookLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Address Book']");
    By WishListLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Wish List']");
    By OrderHistoryLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Order History']");
    By DownloadsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Downloads']");
    By SubscriptionsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Subscriptions']");
    By RewardPointsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Reward Points']");
    By ReturnsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Returns']");
    By TransactionsLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Transactions']");
    By NewsletterLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Newsletter']");

     public void enterEmail(String email) {

         driver.findElement(EmailLocator).sendKeys(email);
     }
     public void enterPassword(String password){

         driver.findElement(PasswordLocator).sendKeys(password);
     }
    public boolean isWarningMessageDisplayed() {
        WebElement warningElement = wait.until(ExpectedConditions.visibilityOfElementLocated(WarningMessageLocator));
        return warningElement.isDisplayed();
    }

    public String getWarningMessageText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(WarningMessageLocator));
        return driver.findElement(WarningMessageLocator).getText();
    }


     public void clickOnLoginButton(){

         driver.findElement(LoginButtonLocator).click();
     }
     public void clickOnHomePageIcon() {

         driver.findElement(HomePageIcon).click();
     }
     public RegisterPage clickOnContinueButton(){
         driver.findElement(ContinueButtonLocator).click();
         return new RegisterPage(driver);
     }
    public MyAccountPage userRedirectionToMyAccountPage() {
         driver.findElement(LoginButtonLocator).click();
        return new MyAccountPage(driver);
     }
    public ForgottenPasswordPage clickOnForgottenPasswordBlueLink (){
         driver.findElement(ForgottenPasswordLocator).click();
         return new ForgottenPasswordPage(driver);
    }




    /// /
    public void clickOnLoginLink() {
        driver.findElement(LoginLinkLocator).click();
    }

    public void clickOnRegisterLink() {
        driver.findElement(RegisterLinkLocator).click();
    }

    public void clickOnForgottenPasswordLink() {
        driver.findElement(ForgottenPasswordLinkLocator).click();
    }

//    public void clickOnMyAccountLink() {
//        driver.findElement(MyAccountLinkLocator).click();
//    }

    public void clickOnPaymentMethodsLink() {
        driver.findElement(PaymentMethodsLinkLocator).click();
    }

    public void clickOnAddressBookLink() {
        driver.findElement(AddressBookLinkLocator).click();
    }

    public void clickOnWishListLink() {
        driver.findElement(WishListLinkLocator).click();
    }

    public void clickOnOrderHistoryLink() {
        driver.findElement(OrderHistoryLinkLocator).click();
    }

    public void clickOnDownloadsLink() {
        driver.findElement(DownloadsLinkLocator).click();
    }



}
