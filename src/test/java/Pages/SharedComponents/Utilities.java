package Pages.SharedComponents;

import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Pages.ShoppingCart.ShoppingCartPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    By carticonLocator = By.xpath("//button[@class = 'btn btn-lg btn-dark d-block dropdown-toggle']");
    By massageLocator = By.xpath("//li[@class = 'text-center p-4']");
    String expectedEmptyMassage = "Your shopping cart is empty!";

    public void clickCarticon() {
        driver.findElement(carticonLocator).click();
    }

    public String getMassageLocator() {
        return driver.findElement(massageLocator).getText();
    }

    public String getExpectedEmptyMassage() {
        return expectedEmptyMassage;
    }


     /****************************
     * Adding item Success massage
     *************************** */
     By successMessage = By.id("alert");


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
