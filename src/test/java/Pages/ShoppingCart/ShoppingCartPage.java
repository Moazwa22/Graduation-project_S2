package Pages.ShoppingCart;

import Pages.Home.HomePage;
import Pages.SharedComponents.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends Utilities {

    By pageTitleLocator = By.cssSelector("#shopping-cart > h1");
    By emptyMassageLocator = By.cssSelector("#shopping-cart > p");
    String expectedEmptyMassage = "Your shopping cart is empty!";
    By continueButtonLocator = By.linkText("Continue");
    By continueShoppingBtnLocator = By.linkText("Continue Shopping");
    List<WebElement> inputQuantityLocators = driver.findElements(By.xpath("//input[@name='quantity']"));


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return driver.findElement(pageTitleLocator).getText();
    }

    public String getEmptyMassage(){
        return driver.findElement(emptyMassageLocator).getText();
    }

    public String getExpectedEmptyMassage() {
        return expectedEmptyMassage;
    }

    public HomePage clickContinueButton(){
        driver.findElement(continueButtonLocator).click();
        return new HomePage(driver);
    }

    public HomePage clickContinueShoppingBtn(){
        driver.findElement(continueShoppingBtnLocator).click();
        return new HomePage(driver);
    }

    public void enterInputQuantity(int quantity){

    }


}
