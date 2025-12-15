package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    By homePageLocator = By.id("carousel-banner-0");
    By contactUsIcon = By.xpath("//span[text() = '123456789']");
    By contactUsTitle = By.xpath("//h1[text() = 'Contact Us']");
    By nameField =  By.id("input-name");
    By E_Mail_Address = By.id("input-email");
    By Enquiry = By.id("input-enquiry");
    By submitButton = By.xpath("//button[@type='submit' and text()='Submit']");
    By successMessage = By.tagName("p");
    By continueButton = By.xpath("//a[text()='Continue']");
    public By E_MailError = By.id("error-email");
    public By nameErrorMessage = By.xpath("//div[text() = 'Name must be between 3 and 32 characters!']");
    public By enquiryErrorMessage = By.xpath("//div[text() = 'Enquiry must be between 10 and 3000 characters!']");

    public boolean isHomePageLoaded_HP(){
        return driver.findElement(homePageLocator).isDisplayed();
    }

    public void scrollDownSmall() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
    }

    public void clickOnContactUsIcon(){
        driver.findElement(contactUsIcon).click();
    }

    public boolean userIsOnContactUs(){
        return driver.findElement(contactUsTitle).isDisplayed();
    }

    public boolean contactUsFieldsIsDisplayed(){
        return driver.findElement(nameField).isDisplayed()&&
                driver.findElement(E_Mail_Address).isDisplayed()&&
                driver.findElement(Enquiry).isDisplayed();

    }

    public void enterValidData(){
        driver.findElement(nameField).sendKeys("Moaz Waleed");
        driver.findElement(E_Mail_Address).sendKeys("moaazw84@gmail.com");
        driver.findElement(Enquiry).sendKeys("I want anyone to talk to me and I want something from customer service");
    }

    public void userClickOnSubmitButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }

    public void clickOnSubmitButtonToContinue(){
        driver.findElement(submitButton).click();
    }

    public boolean successMessageIsDisplayed(){
        return driver.findElement(successMessage).isDisplayed();
    }


    public void clickOnContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();
    }

    public void userEntersInvalidName(){
        driver.findElement(nameField).sendKeys("M");
    }

    public void userEntersInvalidEmail(){
        driver.findElement(E_Mail_Address).sendKeys("moazw@.com");
    }

    public void userEnterInvalidEnquiry(){
        driver.findElement(Enquiry).sendKeys("Moaz".repeat(3100));
    }

    public boolean contactErrorMessageIsDisplayed(){
        return driver.findElement(E_MailError).isDisplayed()
                &&driver.findElement(nameErrorMessage).isDisplayed()
                &&driver.findElement(enquiryErrorMessage).isDisplayed();
    }

    public boolean E_MailErrorMessageIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(E_MailError));
        return driver.findElement(E_MailError).isDisplayed();
    }

}

 /* public void clickOnContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));

        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
        driver.findElement(continueButton).click();
    }

    // We Can here make a method to check if the user is redirected to the homepage after clicking on continue.
    // public void userIsRedirectedToHomepage

    public void enterInvalidData() {
        driver.findElement(nameField).sendKeys("M");
        driver.findElement(E_Mail_Address).sendKeys("moazw@.com");
        driver.findElement(Enquiry).sendKeys("Moaz".repeat(3100));
        driver.findElement(submitButton).click();
    }
*/