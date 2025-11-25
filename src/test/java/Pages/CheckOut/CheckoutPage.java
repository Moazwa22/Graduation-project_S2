package Pages.CheckOut;

import io.cucumber.java.ar.اذاً;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    WebDriver driver;

    By useANewAddressLocator = By.xpath("//input[@value = '0']");
    By firstNameLocator = By.xpath("//input[@id = 'input-shipping-firstname']");
    By lastNameLocator = By.xpath("//input[@id = 'input-shipping-lastname']");
    By companyLocator = By.xpath("//input[@id = 'input-shipping-company']");
    By addressOneLocator = By.xpath("//input[@id = 'input-shipping-address-1']");
    By addressTwoLocator = By.xpath("//input[@id = 'input-shipping-address-2']");
    By cityLocator = By.xpath("//input[@id = 'input-shipping-city']");
    By postcodeLocator = By.xpath("//input[@id = 'input-shipping-postcode']");
    By countrySelectorLocator = By.xpath("//select[@id = 'input-shipping-country']");
    By regionSelectorLocator = By.xpath("//select[@id = 'input-shipping-zone']");

    By alertMessageLocator = By.id("alert");

    By continueButtonLocator = By.xpath("//button[@id = 'button-shipping-address']");

    By checkoutPageTitle = By.tagName("h1");
    String checkoutPageExpectedTitle = "Checkout";

    String successfulAddressAlert = "Success: You have changed shipping address!";


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
            Select countryList = new Select(driver.findElement(countrySelectorLocator));
            countryList.selectByVisibleText(country);
        }catch (NoSuchElementException e){
            throw new Exception("Value " + country + " not found in dropdown " + countrySelectorLocator + "");
        }
    }
    public void selectRegion(String region) throws Exception{
        try {
            Select countryList = new Select(driver.findElement(regionSelectorLocator));
            countryList.selectByVisibleText(region);
        }catch (NoSuchElementException e){
            throw new Exception("Value " + region + " not found in dropdown " + regionSelectorLocator + "");
        }
    }

    public String alertMessage(){
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

    public String continueButton(){
        driver.findElement(continueButtonLocator).click();
        return alertMessage();
    }

}
