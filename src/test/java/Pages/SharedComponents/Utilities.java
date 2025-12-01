package Pages.SharedComponents;

import Pages.CheckOut.CheckOutPage;
import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Pages.ShoppingCart.ShoppingCartPage;
import StepDefinition.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
     * BreadCrumb
     ************** */
    By homePageIcon = By.xpath("//li[@class='breadcrumb-item'][1]");

    public HomePage clickHomePageIcon (){
        driver.findElement(homePageIcon).click();
        //wait.until(ExpectedConditions.urlToBe("http://localhost/opencart/index.php?route=common/home&language=en-gb"));
        return new HomePage(driver);
    }


    /* **************
     * NavigationTop
     *************** */
    By shoppingCartLocator  = By.xpath("//a[@title='Shopping Cart']");
    By dropdownLocator = By.className("dropdown-item");

    public ShoppingCartPage clickShoppingCart (){
        driver.findElement(shoppingCartLocator).click();
        return new ShoppingCartPage(driver);
    }

    public void clickMyAccountButton (){
        List<WebElement> elements = driver.findElements(By.xpath("//span[@class='d-none d-lg-inline']"));
        elements.get(1).click();
    }

    public LoginPage selectLoginDropdownText() {
        List<WebElement> items = driver.findElements(dropdownLocator);
        for (WebElement item : items) {
            if (item.getText().equalsIgnoreCase("Login")) {
                item.click();
                break;
            }
        }
        return new LoginPage(driver);
    }



    /* *//* **************
     * Nav-menue
     *************** *//*
    List<WebElement> navItems = driver.findElements(By.cssSelector("ul.navbar-nav > li.nav-item"));




*/
    /* **************
     * Carticon
     *************** */
    By carticonLocator = By.xpath("//button[contains(@class,'dropdown-toggle')]");
    By massageLocator = By.xpath("//li[@class = 'text-center p-4']");
    String expectedEmptyMassage = "Your shopping cart is empty!";
    By viewCartLocator = By.xpath("//a[contains(.,'View Cart')]");
    By checkOutLocator = By.xpath("//a[contains(.,' Checkout')]");
    List<WebElement> deleteiconLocator = driver.findElements(By.xpath("//button[@type='submit']/i"));


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
        WebElement element = deleteiconLocator.get(1);

        // Click using JS to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }





    /****************************
     * Adding item Success massage
     *************************** */
    static By successMessage = By.id("alert");


    public String getActualText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    private Alert getAlert(){
        return driver.switchTo().alert();
    }
    public String getActualTextOfAlert(){
        return getAlert().getText();
    }






}
