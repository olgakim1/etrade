package step_definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-reports", "json:target/cukesreport.json"},
        features = "src/test/java/features/",
        glue = "step_definitions/",
        dryRun = false,
        tags = "@etrade"
)

public class CukesRunner {
}
