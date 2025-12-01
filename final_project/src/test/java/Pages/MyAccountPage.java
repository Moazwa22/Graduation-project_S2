package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;
    public MyAccountPage(WebDriver driver)
    {
        this.driver = driver;
    }
    By HomePageIcon = By.cssSelector("a[href*='route=common/home']");

    public void clickOnHomePageIcon() {

        driver.findElement(HomePageIcon).click();
    }
}
