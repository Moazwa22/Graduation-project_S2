package Tests;

import Pages.HomePage;
import baseTest.baseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTests extends baseTest {

    @Test
    public void verifyProductsAreVisible(){

        HomePage home = new HomePage(driver);

        List<WebElement> products = home.getProducts();

        for (WebElement product : products){
            System.out.println("Product found: " + product.getText());
        }

    }
}