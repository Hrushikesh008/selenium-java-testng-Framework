package utils;

import org.testng.ITestResult;

import actions.ActionPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksUtils {
	BrowserFactory driver;
	ActionPage actionPage;

	public HooksUtils(BrowserFactory webDriver) {
		this.driver = webDriver;
	}

	@Before
	public void before() {
		Logger.info("Running before hooks to setup browser");
		driver.WebDriverManager().manage().window().maximize();
	}

	@After
	public void after(ITestResult result) {
		Logger.info("Running after hooks to close browser");
		try {
			actionPage.screenshot(result);
			driver.WebDriverManager().quit();
		} catch (Exception e) {
			throw new AssertionError("Drive quit giving Exception", e);
		}
	}
}
