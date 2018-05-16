package stepDefinitions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/results/Cucumber.json" }
		,features =("src/test/java/features")
		,glue={"stepDefinitions"}
		)
public class TestRunner {
 
}
