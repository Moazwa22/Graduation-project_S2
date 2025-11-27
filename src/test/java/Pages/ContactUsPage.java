package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    By contactUsIcon = By.xpath("//i[@class = 'fa-solid fa-phone']");
    By contactUsTitle = By.xpath("//h1[text()='Contact Us']");
    By nameField = By.id("input-name");
    By emailField = By.id("input-email");
    By enquiryField = By.id("input-enquiry");
    By submitButton = By.cssSelector("input[type='submit']");
    By successMessage = By.cssSelector(".alert-success");
    By continueButton = By.xpath("//a[text()='Continue']");
    By emailErrorMessage = By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid')]");
    By nameErrorMessage = By.xpath("//div[contains(text(),'Name must be between')]");
    By enquiryErrorMessage = By.xpath("//div[contains(text(),'Enquiry must be between')]");

    public void clickOnContactUsIcon() {
        driver.findElement(contactUsIcon).click();
    }

    public boolean isOnContactUsPage() {
        return driver.findElement(contactUsTitle).isDisplayed();
    }

    public boolean areContactUsFieldsDisplayed() {
        return driver.findElement(nameField).isDisplayed()
                && driver.findElement(emailField).isDisplayed()
                && driver.findElement(enquiryField).isDisplayed();
    }

    public void enterValidContactData(String name, String email, String enquiry) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(enquiryField).clear();
        driver.findElement(enquiryField).sendKeys(enquiry);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void enterInvalidContactData(String name, String email, String enquiry) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(enquiryField).clear();
        driver.findElement(enquiryField).sendKeys(enquiry);
    }

    public boolean isEmailErrorDisplayed() {
        return driver.findElement(emailErrorMessage).isDisplayed();
    }

    public boolean isNameErrorDisplayed() {
        return driver.findElement(nameErrorMessage).isDisplayed();
    }

    public boolean isEnquiryErrorDisplayed() {
        return driver.findElement(enquiryErrorMessage).isDisplayed();
    }

    public void submitValidContactForm() {
        enterValidContactData("Moaz Waleed", "moaazw84@gmail.com",
                "I want anyone to talk to me and I want something from customer service");
        clickSubmitButton();
    }
}
