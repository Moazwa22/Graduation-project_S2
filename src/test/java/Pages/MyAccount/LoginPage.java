package Pages.MyAccount;

import Pages.CheckOut.CheckOutPage;
import Pages.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    By userNameLocator = By.id("input-email");
    By EmailLocator = By.id("input-email");
    By PasswordLocator =By.id("input-password");
    By LoginButtonLocator = By.xpath("//button[text()='Login']");
    By HomePageIcon = By.xpath("//a[contains(@href,'route=common/home')]");
    By ContinueButtonLocator = By.linkText("Continue");
    By ForgottenPasswordLocator = By.xpath("//form[@id='form-login']//a[text()='Forgotten Password']");
    By LoginLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Login']");
    By RegisterLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Register']");
    By ForgottenPasswordLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Forgotten Password']");

    //--------------------Raneem------------//
    By loginButton = By.cssSelector("button[type='submit']");
    By accountDropdown = By.cssSelector("a[title='My Account']");
    //-------------Tebry-------------//
    By emaillocator = By.id("input-email");

    By passwordLocator = By.id("input-password");

    By loginButtonLocator = By.xpath("//button[@class='btn btn-primary']");

    By addToCartLocator = By.xpath("//*[@id='content']/div[2]/div[2]/div/div[2]/form/div/button[1]");

    By homeButtonLocator = By.xpath("//img[@src='http://localhost/opencart/image/catalog/opencart-logo.png']");
    By cartIconLocator = By.xpath("//span[contains(text(), 'Checkout')]");

    By accountPageLocator = By.tagName("h1");
    String expectedTitleOfMyAccountPage =  "My Account";

    String email = "test10@gmail.com";
    String password = "testtest";

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

    //--------------Raneem------------//
    public void openLoginPage() {
        driver.get("http://localhost/opencartproject/index.php?route=account/login&language=en-gb");
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }


    public void login(String username, String password) {
        driver.findElement(EmailLocator).clear();
        driver.findElement(EmailLocator).sendKeys(username);

        driver.findElement(PasswordLocator).clear();
        driver.findElement(PasswordLocator).sendKeys(password);

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
    //--------------Tebry------------//
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

    public CheckOutPage checkout(){
        driver.findElement(cartIconLocator).click();
        return new CheckOutPage(driver);
    }

    public String actualTitleOfAccountPage(){
        return driver.findElement(accountPageLocator).getText();
    }

    public String getExpectedTitleOfMyAccountPage(){
        return expectedTitleOfMyAccountPage;
    }
    //-----------Amr-----------//
    public void enterUserName(String userName) {
        driver.findElement(userNameLocator).sendKeys(userName);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

}