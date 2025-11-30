package Pages.Home;

import Pages.SharedComponents.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends Utilities {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    List<WebElement> addToCartLocator = driver.findElements(By.xpath("//button[@type = 'submit']/i"));


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean homePageChecker (){
        List<WebElement> breadcrumb = driver.findElements(By.xpath("//ul[@class='breadcrumb']"));
        return breadcrumb.isEmpty();
    }


    public void addMackBookToCart(){
        WebElement element = addToCartLocator.get(1);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Click using JS to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


}
