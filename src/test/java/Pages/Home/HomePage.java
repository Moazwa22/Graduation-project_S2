package Pages.Home;

import Pages.SharedComponents.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utilities {

    private List<WebElement> addToCartLocator = driver.findElements(By.xpath("//button[@type = 'submit']/i"));
    List<WebElement> productName = driver.findElements(By.tagName("h4"));
    List<WebElement> priceNew    = driver.findElements(By.className("price-new"));
    List<WebElement> priceTax    = driver.findElements(By.className("price-tax"));



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addMackBookToCart(){
        WebElement element = addToCartLocator.get(1);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Click using JS to avoid interception
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String getPName (){return productName.get(0).getText();}
    public String getPriceN(){return priceNew.get(0).getText();}
    public String getPriceT(){return priceTax.get(0).getText();}

    public String getPriceN(String no) {
        double quantity = Double.parseDouble(no.trim());
        double unitNPrice = Double.parseDouble(getPriceN().replaceAll("[^0-9.]", ""));

        double total = quantity * unitNPrice;
        return String.valueOf(total);
    }

    public String getPriceT(String no) {
        double quantity = Double.parseDouble(no.trim());
        double unitTPrice = Double.parseDouble(getPriceN().replaceAll("[^0-9.]", ""));

        double total = quantity * unitTPrice;
        return String.valueOf(total);
    }



}
