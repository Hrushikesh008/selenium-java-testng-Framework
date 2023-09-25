package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserFactory extends BaseUtils {
	public WebDriver driver;

	public WebDriver WebDriverManager() {
		readfromxml();
		String browserName = retrirvrXmlValue("browser");
		if (driver == null) {
			if (browserName.equalsIgnoreCase("EDGE")) {
				System.setProperty("webdriver.edge.driver", retrirvrXmlValue("edgeDriverPath"));
				EdgeOptions options = new EdgeOptions();
				// options.addArguments("headless");
				options.addArguments("-inprivate");
				driver = new EdgeDriver(options);
			} else if (browserName.equalsIgnoreCase("CHROME")) {
				System.setProperty("webdriver.chrome.driver", retrirvrXmlValue("chromeDriverPath"));
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				// options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				System.out.println("This driver is not supported at the movement");
			}
			System.out.println("Test runing in" + browserName + "Driver");
		}
		return driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}