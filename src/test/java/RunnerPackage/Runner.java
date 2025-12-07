package RunnerPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "Src/main/resources/Features",
        glue = "StepDefinition",
        plugin = {"pretty",
                "html:target/cucumber-report.json",
                "html:target/cucumber-report.html"}
)


public class Runner extends AbstractTestNGCucumberTests {
}
