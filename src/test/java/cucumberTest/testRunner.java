package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		features ={"src/test/java/login_logout.feature",
				"src/test/java/create_update_delete.feature"},
		glue="StepDef",
		dryRun = false,
		monochrome = true,
		format={"html:format"}
		)

public class testRunner {

}
