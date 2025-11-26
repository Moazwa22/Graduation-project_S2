package Pages.MyAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver=driver;
    }

    By FirstNameLocator = By.cssSelector("#input-firstname");
    By LastNameLocator = By.cssSelector("#input-lastname");
    By EmailLocator = By.cssSelector("#input-email");
    By PasswordLocator = By.cssSelector("#input-password");
    By PrivacyPolicyLocator = By.xpath("//input[@type='checkbox' and @name='agree']");
    By continueButtonLocator = By.xpath("//button[text()='Continue']");
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



}
