package Pages.CheckOut;

import StepDefinitions.Hooks;
import io.cucumber.java.ar.اذاً;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    By useANewAddressLocator = By.xpath("//input[@value = '0']");
    By useOldAddressLocator = By.xpath("//input[@value = '1']");
    By firstNameLocator = By.xpath("//input[@id = 'input-shipping-firstname']");
    By lastNameLocator = By.xpath("//input[@id = 'input-shipping-lastname']");
    By companyLocator = By.xpath("//input[@id = 'input-shipping-company']");
    By addressOneLocator = By.xpath("//input[@id = 'input-shipping-address-1']");
    By addressTwoLocator = By.xpath("//input[@id = 'input-shipping-address-2']");
    By cityLocator = By.xpath("//input[@id = 'input-shipping-city']");
    By postcodeLocator = By.xpath("//input[@id = 'input-shipping-postcode']");
    By countrySelectorLocator = By.xpath("//select[@id = 'input-shipping-country']");
    By regionSelectorLocator = By.xpath("//select[@id = 'input-shipping-zone']");
    By shippingMethodLocator = By.id("button-shipping-methods");
    By flatShippingRateLocator = By.id("input-shipping-method-flat-flat");
    By freeShippingLocator = By.id("input-shipping-method-free-free");
    By continueButtonShippingLocator = By.id("button-shipping-method");
    By paymentMethodLocator = By.id("button-payment-methods");
    By cashOnDeliveryMethod = By.id("input-payment-method-cod-cod");
    By continueButtonPaymentLocator = By.id("button-payment-method");
    By commentEnteringField = By.id("input-comment");
    By alreadyExistingAddress = By.id("input-shipping-address");

    By confirmCheckoutButton = By.id("button-confirm");

    By alertMessageLocator = By.id("alert");

    String shippingConfirmationAlertMessage = "Success: You have changed shipping method!";

    String paymentMethodConfirmationAlertMessage = "Success: You have changed payment method!";

    By continueButtonLocator = By.xpath("//button[@id = 'button-shipping-address']");

    By checkoutPageTitle = By.tagName("h1");
    String checkoutPageExpectedTitle = "Checkout";

    String successfulAddressAlert = "Success: You have changed shipping address!";

    By actualSuccessfulOrderPlacedMessage = By.xpath("//div/h1[contains(text(), 'Your order has been placed!')]");
    String expectedSuccessfulOrderPlacedMessage = "Your order has been placed!";

    //Error Locators
    By firstNameErrorLocator = By.id("error-shipping-firstname");
    By lastNameErrorLocator    = By.id("error-shipping-lastname");
    By countryErrorLocator     = By.id("error-shipping-country");
    By cityErrorLocator        = By.id("error-shipping-city");
    By postCodeErrorLocator    = By.id("error-shipping-postcode");
    By regionErrorLocator      = By.id("error-shipping-zone");
    By addressOneErrorLocator  = By.id("error-shipping-address-1");
    By shippingMethodErrorLocator = By.id("error-shipping-method");

    String expectedFirstNameErrorMessage  = "First Name must be between 1 and 32 characters!";
    String expectedLastNameErrorMessage   = "Last Name must be between 1 and 32 characters!";
    String expectedAddressOneErrorMessage = "Address 1 must be between 3 and 128 characters!";
    String expectedCityErrorMessage       = "City must be between 2 and 128 characters!";
    String expectedPostCodeErrorMessage   = "Postcode must be between 2 and 10 characters!";
    String expectedCountryErrorMessage    = "Please select a country!";
    String expectedRegionErrorMessage     = "Please select a region / state!";
    String expectedShippingErrorMessage = "Shipping method required!";


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void useNewAddress(){
        driver.findElement(useANewAddressLocator).click();
    }

    public void enterFirstName(String firstName){
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }
    public void enterCompany(String company){
        driver.findElement(companyLocator).sendKeys(company);
    }
    public void enterAddressOne(String addressOne){
        driver.findElement(addressOneLocator).sendKeys(addressOne);
    }
    public void enterAddressTwo(String addressTwo){
        driver.findElement(addressTwoLocator).sendKeys(addressTwo);
    }
    public void enterCity(String city){
        driver.findElement(cityLocator).sendKeys(city);
    }
    public void enterPostCode(String postCode){
        driver.findElement(postcodeLocator).sendKeys(postCode);
    }
    public void selectCountry(String country) throws Exception{
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(countrySelectorLocator));
            element.click();
            Select countryList = new Select(driver.findElement(countrySelectorLocator));
            countryList.selectByVisibleText(country);
        }catch (NoSuchElementException e){
            throw new Exception("Value " + country + " not found in dropdown " + countrySelectorLocator + "");
        }
    }
    public void selectRegion(String region) throws Exception{
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(regionSelectorLocator));
            element.click();
            Select countryList = new Select(driver.findElement(regionSelectorLocator));
            countryList.selectByVisibleText(region);
        }catch (NoSuchElementException e){
            throw new Exception("Value " + region + " not found in dropdown " + regionSelectorLocator + "");
        }
    }

    public String alertMessage(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessageLocator));
        element.click();
        return driver.findElement(alertMessageLocator).getText();
    }
    public String successfulAddressAdded(){
        return successfulAddressAlert;
    }

    public String checkoutPageActualTitle(){
        return driver.findElement(checkoutPageTitle).getText();
    }
    public String checkoutPageExpectedTitle(){
        return checkoutPageExpectedTitle;
    }

    public void continueButton(){
        driver.findElement(continueButtonLocator).click();
    }

    public void useOldAddress(){
        driver.findElement(useOldAddressLocator).click();
    }

    public boolean oldAddressExists(){
        return driver.findElement(useOldAddressLocator).isSelected();
    }

    public void selectFreeShipping() throws InterruptedException {
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(freeShippingLocator)).click();
        driver.findElement(continueButtonShippingLocator).click();
    }

    public void selectFlatShippingRate() throws InterruptedException {
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(flatShippingRateLocator)).click();
        driver.findElement(continueButtonShippingLocator).click();
    }

    public String getShippingConfirmationAlertMessage(){
        return shippingConfirmationAlertMessage;
    }

    public void payCashOnDelivery(){
        driver.findElement(paymentMethodLocator).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cashOnDeliveryMethod));
        element.click();
        driver.findElement(cashOnDeliveryMethod).click();
        driver.findElement(continueButtonPaymentLocator).click();
    }

    public String getPaymentMethodConfirmationAlertMessage(){
        return paymentMethodConfirmationAlertMessage;
    }

    public void enterComment(String comment){
        driver.findElement(commentEnteringField).sendKeys(comment);
    }

    public void confirmCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(confirmCheckoutButton))).click();
    }

    public String getExpectedSuccessfulOrderPlacedMessage(){
        return expectedSuccessfulOrderPlacedMessage;
    }

    public String getActualSuccessfulOrderPlacedMessage(){
        return driver.findElement(actualSuccessfulOrderPlacedMessage).getText();
    }

    public void chooseAnAlreadyExistingAddress(String address) throws Exception {
        try {
            Select countryList = new Select(driver.findElement(alreadyExistingAddress));
            countryList.selectByContainsVisibleText(address);
        }catch (NoSuchElementException e){
            throw new Exception("Value " + address + " not found in dropdown " + alreadyExistingAddress + "");
        }
    }

    //Error Methods
    public String getExpectedFirstNameErrorMessage(){
        return expectedFirstNameErrorMessage;
    }
    public String getActualFirstNameErrorMessage(){
        return driver.findElement(firstNameErrorLocator).getText();
    }

    public String getExpectedLastNameErrorMessage() {
        return expectedLastNameErrorMessage;
    }
    public String getActualLastNameErrorMessage() {
        return driver.findElement(lastNameErrorLocator).getText();
    }

    public String getExpectedAddressOneErrorMessage() {
        return expectedAddressOneErrorMessage;
    }
    public String getActualAddressOneErrorMessage() {
        return driver.findElement(addressOneErrorLocator).getText();
    }

    public String getExpectedCountryErrorMessage() {
        return expectedCountryErrorMessage;
    }
    public String getActualCountryErrorMessage() {
        return driver.findElement(countryErrorLocator).getText();
    }

    public String getExpectedCityErrorMessage() {
        return expectedCityErrorMessage;
    }
    public String getActualCityErrorMessage() {
        return driver.findElement(cityErrorLocator).getText();
    }

    public String getExpectedRegionErrorMessage() {
        return expectedRegionErrorMessage;
    }
    public String getActualRegionErrorMessage() {
        return driver.findElement(regionErrorLocator).getText();
    }

    public String getExpectedPostcodeErrorMessage() {
        return expectedPostCodeErrorMessage;
    }
    public String getActualPostcodeErrorMessage() {
        return driver.findElement(postCodeErrorLocator).getText();
    }

    public String getExpectedShippingErrorMessage(){
        return expectedShippingErrorMessage;
    }
    public String getActualShippingErrorMessage(){
        return driver.findElement(shippingMethodErrorLocator).getText();
    }
}