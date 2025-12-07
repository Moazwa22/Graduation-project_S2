package Pages.ShoppingCart;

import Pages.CheckOut.CheckOutPage;
import Pages.Home.HomePage;
import Pages.SharedComponents.Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends Utilities {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));;


    By pageTitleLocator           = By.cssSelector("#shopping-cart > h1");
    By emptyMassageLocator        = By.tagName("p");
    String expectedEmptyMassage   = "Your shopping cart is empty!";
    By continueButtonLocator      = By.linkText("Continue");
    By continueShoppingBtnLocator = By.linkText("Continue Shopping");
    By inputQuantityLocator       = By.xpath("//input[@name='quantity']");
    By updateLocator              = By.xpath("//i[@class = 'fa-solid fa-rotate']");
    By removeIconLocator          = By.cssSelector("#output-cart > table > tbody > tr > td:nth-child(3) > form > div > a");
    By useCouponDropDownLocator   = By.xpath("//button[contains(text(),'Use Coupon Code')]");
    By inputCouponLocator         = By.id("input-coupon");
    By applyCouponBottonLocator   = By.xpath("//button[contains(text(),'Apply Coupon')]");
    By removeBottonLocator        = By.xpath("//button[contains(text(),'Remove')]");
    By checkOutBtnLocator         = By.linkText("Checkout");
    By productNameLocator         = By.xpath("//td[@class='text-start text-wrap']/a");
    By unitPriceLocator           = By.cssSelector("#output-cart > table > tbody > tr > td:nth-child(4)");
    By totalPerProductLocator     = By.cssSelector("#output-cart > table > tbody > tr > td:nth-child(5)");
    By subTotlaLocator            = By.cssSelector("#checkout-total > tr:nth-child(1) > td:nth-child(2)");
    By totalLocator               = By.cssSelector("#checkout-total > tr:nth-child(4) > td:nth-child(2)");


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


    public void updateQuantity(String quantity){
        driver.findElement(inputQuantityLocator).clear();
        driver.findElement(inputQuantityLocator).sendKeys(quantity);

        driver.findElement(updateLocator).click();
    }

    public void removeItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeIconLocator)).click();
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

    public String getPName   (){return driver.findElement(productNameLocator).getText();}
    public String getUPrice  (){return driver.findElement(unitPriceLocator).getText();}
    public String getTPProd  () {return driver.findElement(totalPerProductLocator).getText();}
    public String getSubTotal(){return driver.findElement(subTotlaLocator).getText();}
    public String getTotal   (){return driver.findElement(totalLocator).getText();}




}
