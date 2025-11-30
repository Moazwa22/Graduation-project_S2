package Pages.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage
{

    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver=driver;

    }

    By FirstNameLocator = By.cssSelector("#input-firstname");
    By LastNameLocator = By.cssSelector("#input-lastname");
    By EmailLocator = By.cssSelector("#input-email");
    By PasswordLocator = By.cssSelector("#input-password");
    By PrivacyPolicyLocator = By.xpath("//input[@type='checkbox' and @name='agree']");
    By continueButtonLocator = By.xpath("//button[@type='submit' and contains(@class,'btn-primary')]");
    By privacyPolicyWarningMessage = By.xpath("//div[contains(text(),'You must agree to the Privacy Policy')]");
    By errorEmailMessage = By.id("error-email");
    By errorPasswordMessage = By.id("error-password");
    By errorFirstNameMessage = By.id("error-firstname");
    By errorLastNameMessage = By.id("error-lastname");
    By AlreadyHaveAnAccountLoginLinkLocator = By.linkText("login page");


    String ExpectedWarningPolicyMessage = "Warning: You must agree to the Privacy Policy!";
    String ExpectedFirstNameErrorMessage = "First Name must be between 1 and 32 characters!";
    String ExpectedLastNameErrorMessage = "Last Name must be between 1 and 32 characters!";
    String ExpectedEmailErrorMessage = "E-Mail Address does not appear to be valid!";
    String ExpectedPasswordErrorMessage = "Password must be between 6 and 40 characters!";


    By LoginLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Login']");
    By RegisterLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Register']");
    By ForgottenPasswordLinkLocator = By.xpath("//a[@class='list-group-item' and text()='Forgotten Password']");

    By WarningFirstAndLastNameMessageLocator =By.id("error-firstname");
    By PasswordWarningMessageLocator=By.id("error-password");

    String ExpectedWarningNameMessage = "First Name must be between 1 and 32 characters!";
    public void getActualWarningNameMessage()
    {
        driver.findElement(WarningFirstAndLastNameMessageLocator).getText();
    }
    public String getExpectedWarningNameMessage()
    {
        return ExpectedWarningNameMessage;
    }

    public void enterFirstName(String FirstName){
        driver.findElement(FirstNameLocator).sendKeys(FirstName);
    }
    public void enterLastName(String LastName){
        driver.findElement(LastNameLocator).sendKeys(LastName);
    }
    public void enterEmail(String email){
        driver.findElement(EmailLocator).sendKeys(email);
    }
    public void enterPassword(String Password){
        driver.findElement(PasswordLocator).sendKeys(Password);
    }
    public void enablePrivacyToggle(){
        driver.findElement(PrivacyPolicyLocator).click();
    }

    public void clickContinueButton(){

        driver.findElement(continueButtonLocator).click();
    }
    public void getEmailWarningMessage()
    {
        driver.findElement(errorEmailMessage).getText();
    }

    public void getPasswordWarningMessage()
    {
        driver.findElement(errorPasswordMessage).getText();
    }
    public void getFirstNameWarningMessage()
    {
        driver.findElement(errorFirstNameMessage).getText();
    }
    public void getLastNameWarningMessage()
    {
        driver.findElement(errorLastNameMessage).getText();
    }
    public void clickOnAlreadyHaveAnAccountLoginLink()
    {
        driver.findElement(AlreadyHaveAnAccountLoginLinkLocator).click();
    }


// functions for the right links

    public void clickOnLoginLinkFromRegisterPage() {

    driver.findElement(LoginLinkLocator).click();
}
    public void clickOnRegisterLinkFromRegisterPage() {
        driver.findElement(RegisterLinkLocator).click();
    }
    public void clickOnForgottenPasswordLink() {
        driver.findElement(ForgottenPasswordLinkLocator).click();
    }


    public String getActualPolicyWarningMessage()
    {
        return ExpectedWarningPolicyMessage;
    }







}
