package StepDefinitions;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    WebDriver driver;
    @Before
    public void setUp(){

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/");

    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
