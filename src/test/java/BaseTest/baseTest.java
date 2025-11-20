package baseTest;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openURL(){
        driver.get("http://localhost/opencart/");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}