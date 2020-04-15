package runner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;
import io.cucumber.testng.CucumberOptions;


@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        toPDF = true,
        outputFolder = "target/pdf")
@CucumberOptions(plugin = {
        "json:target/cucumber.json"},
        features = {"src/test/java/features"},
        glue = {"steps"}
)
public class TestRunner extends ExtendedTestNGRunner {

}