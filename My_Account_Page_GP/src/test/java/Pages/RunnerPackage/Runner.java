package Pages.RunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = "StepDefinitions",
        plugin = {"pretty",
                "html:target/cucmber-reports.json",
                "html:target/cucmber-reports.html"}
)


public class Runner extends AbstractTestNGCucumberTests {
}