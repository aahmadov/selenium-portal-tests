package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (

        features ="src/test/resources/features",
        glue = {"StepDefinitions"},
        dryRun = false,
        tags = "@SeleniumSmoke",
        plugin ={"pretty","json:target/cucumber/report.json",
                "html:target/cucumber/report.html",
                "junit:target/cucumber/report.xml" },
        monochrome = true


)
public class TestRunners {
}
