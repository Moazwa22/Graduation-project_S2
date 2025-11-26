package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductPage {
    WebDriver driver;

    By productTitle = By.cssSelector("h1");
    By productPrice = By.cssSelector(".list-unstyled h2");
    By addToCartBtn = By.id("button-cart");
    By successMessage = By.cssSelector(".alert-success");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyProductTitle(String expected){
        String title = driver.findElement(productTitle).getText();
        Assert.assertEquals(title, expected);
    }

    public void verifyProductPrice(){
        Assert.assertTrue(driver.findElement(productPrice).isDisplayed());
    }

    public void verifyAddToCartVisible(){
        Assert.assertTrue(driver.findElement(addToCartBtn).isDisplayed());
    }

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public boolean isCartSuccessMessageDisplayed() {
        try {
            WebElement msg = driver.findElement(successMessage);
            return msg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getProductTitleElement() {
        return driver.findElement(productTitle);
    }
}

