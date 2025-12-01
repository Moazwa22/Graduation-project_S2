package Pages.CheckOut;

import Pages.SharedComponents.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends Utilities {

    By pageTitleLocator = By.cssSelector("#content > h1");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(pageTitleLocator).getText();
    }
}
