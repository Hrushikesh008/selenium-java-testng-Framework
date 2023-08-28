package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksUtils {
	BrowserFactory webDriver;

	public HooksUtils(BrowserFactory webDriver) {
		this.webDriver = webDriver;
	}

	@Before
	public void beforeSetup() {
		Logger.info("Running before hooks to setup browser");
		webDriver.WebDriverManager().manage().window().maximize();
	}

	@After
	public void quitApp() {
		Logger.info("Running after hooks to close browser");
		webDriver.WebDriverManager().close();
		webDriver.WebDriverManager().quit();
	}
}
