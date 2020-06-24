package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features="classpath:Feature",
		glue="classpath:stepDef"
		
		)
@RunWith(Cucumber.class)
public class TestRunner {

}
