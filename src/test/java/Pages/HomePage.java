package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

    public class HomePage {
        protected WebDriver driver;

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        By products = By.className("product-layout");
        public List<WebElement> getProducts(){
            return driver.findElements(products);
        }
    }

