package Pages.SharedComponents;

import Pages.CheckOut.CheckOutPage;
import Pages.Home.HomePage;
import Pages.ShoppingCart.ShoppingCartPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class Utilities {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Utilities(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

     /* *************
     * OpenCart img
     ************** */
    By openCartImg = By.className("img-fluid");
    public HomePage clickToBackHomePage(){
        driver.findElement(openCartImg).click();
        return new HomePage(driver);
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /* **************
     * NavigationTop
     *************** */
    By shoppingCartLocator  = By.xpath("//a[@title='Shopping Cart']");

    public ShoppingCartPage clickShoppingCart (){
        driver.findElement(shoppingCartLocator).click();
        return new ShoppingCartPage(driver);
    }


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /* **************
     * Carticon
     *************** */
    By carticonLocator          = By.xpath("//button[@class='btn btn-lg btn-dark d-block dropdown-toggle']");
    By massageLocator           = By.xpath("//li[@class = 'text-center p-4']");
    String expectedEmptyMassage = "Your shopping cart is empty!";
    By viewCartLocator          = By.xpath("//a[contains(.,'View Cart')]");
    By checkOutLocator          = By.xpath("//a[contains(.,' Checkout')]");
    By deleteiconListLocator    = By.xpath("//button[@type='submit']/i");
    By productNameCILocator         = By.xpath("//td[2]/a");
    By totalPerProductCILocator     = By.xpath("//td[4]");
    By subTotlalCILocator           = By.cssSelector("#cart > div > ul > li > div > table > tbody > tr:nth-child(1) > td:nth-child(2)");
    By totalCILocator               = By.cssSelector("#cart > div > ul > li > div > table > tbody > tr:nth-child(4) > td:nth-child(2)");



    public void clickCarticon() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement cartBtn = driver.findElement(carticonLocator);
                cartBtn.click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
    }


    public String getMassageLocator() {
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(massageLocator)).getText();
    }

    public String getExpectedEmptyMassage() {
        return expectedEmptyMassage;
    }


    public ShoppingCartPage clickViewCartBtn() {
        clickCarticon();

        By dropdown = By.cssSelector("ul.dropdown-menu.show");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));

        WebElement viewCart = driver.findElement(viewCartLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCart);

        return new ShoppingCartPage(driver);
    }

    public CheckOutPage clickCheckoutBtn() {
        clickCarticon();

        By dropdown = By.cssSelector("ul.dropdown-menu.show");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));

        WebElement checkout = driver.findElement(checkOutLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkout);

        return new CheckOutPage(driver);
    }

    public void deleteItem(){
        clickCarticon();

        List<WebElement> deleteiconList = driver.findElements(deleteiconListLocator);
        WebElement element = deleteiconList.get(1);

        // Click using JS to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String getPNameCI   (){ return driver.findElement(productNameCILocator).getText();}
    public String getTPProdCI  (){ return driver.findElement(totalPerProductCILocator).getText();}
    public String getSubTotalCI(){ return driver.findElement(subTotlalCILocator).getText();}
    public String getTotalCI   (){ return driver.findElement(totalCILocator).getText();}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /****************************
     * Adding item Success massage
     *************************** */
     static By successMessage = By.id("alert");

    public String getActualText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

}
