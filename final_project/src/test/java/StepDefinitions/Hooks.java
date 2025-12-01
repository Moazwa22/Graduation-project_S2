package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("http://localhost/opencart");

    }

    @After
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
