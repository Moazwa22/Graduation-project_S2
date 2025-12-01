package Pages.ShoppingCart;

import Pages.CheckOut.CheckOutPage;
import Pages.Home.HomePage;
import Pages.SharedComponents.Utilities;
import StepDefinition.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends Utilities {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));;


    By pageTitleLocator = By.cssSelector("#shopping-cart > h1");
    By emptyMassageLocator = By.tagName("p");
    String expectedEmptyMassage = "Your shopping cart is empty!";
    By continueButtonLocator = By.linkText("Continue");
    By continueShoppingBtnLocator = By.linkText("Continue Shopping");
    By inputQuantityLocator = By.xpath("//input[@name='quantity']");
    By updateLocator = By.xpath("//i[@class = 'fa-solid fa-rotate']");
    By removeIconLocator =By.cssSelector("#output-cart > table > tbody > tr > td:nth-child(3) > form > div > a");
    By useCouponDropDownLocator = By.xpath("//button[contains(text(),'Use Coupon Code')]");
    By inputCouponLocator = By.id("input-coupon");
    By applyCouponBottonLocator = By.xpath("//button[contains(text(),'Apply Coupon')]");
    By removeBottonLocator = By.xpath("//button[contains(text(),'Remove')]");
    By checkOutBtnLocator = By.linkText("Checkout");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return driver.findElement(pageTitleLocator).getText();
    }

    public String getEmptyMassage(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyMassageLocator)).getText();
    }

    public String getExpectedEmptyMassage() {
        return expectedEmptyMassage;
    }

    public HomePage clickContinueButton(){
        driver.findElement(continueButtonLocator).click();
        return new HomePage(driver);
    }


    public void updateQuantity(int quantity){
        driver.findElement(inputQuantityLocator).clear();
        driver.findElement(inputQuantityLocator).sendKeys(String.valueOf(quantity));

        driver.findElement(updateLocator).click();
    }

    public void removeItem(){
        driver.findElement(removeIconLocator).click();
    }

    public void clickAddCouponDropDown(){
        WebElement element = driver.findElement(useCouponDropDownLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Click using JS to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void enterCoupon(String coupon){

        driver.findElement(inputCouponLocator).sendKeys(coupon);
    }

    public void pressApplyCouponButton(){
        driver.findElement(applyCouponBottonLocator).click();
    }

    public void pressRemoveButton(){
        driver.findElement(removeBottonLocator).click();
    }

    public HomePage clickContinueShoppingBtn(){
        WebElement element = driver.findElement(continueShoppingBtnLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Click using JS to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new HomePage(driver);
    }

    public CheckOutPage clickCheckOutBtn(){
        WebElement element = driver.findElement(checkOutBtnLocator);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Click using JS to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new CheckOutPage(driver);
    }

}
