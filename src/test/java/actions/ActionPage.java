package actions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;

import utils.BaseUtils;
import utils.BrowserFactory;
import utils.Logger;

public class ActionPage {
	public WebDriver driver;
	Properties p;
	BaseUtils reader;
	BaseUtils baseUtils;

	public ActionPage(BrowserFactory webDriver) {
		driver = webDriver.getDriver();
	}

	// getURL
	public void visit(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	// getTitle
	public String GetTitle() {
		return driver.getTitle();
	}

	// getText
	public String getText(WebElement element) {
		return element.getText();
	}
	
	// Assert
	public void AssertEquals(String expectedValue, String actualValue) {
		try {
			assertEquals(expectedValue, actualValue);
		} catch (Exception e) {
			throw new AssertionError("Actual value and experted value is not equal", e);
		}
	}

	public void AssertContains(String actualValue, String expectedValue) {
		try {
			assertTrue(actualValue.contains(expectedValue));
		} catch (Exception e) {
			throw new AssertionError("Actual value and experted value is not equal", e);
		}
	}

	// wait
	public WebElement WaitForElement(WebElement element) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Logger.logSevere(e);
		}
		return element;
	}

	public WebElement Wait() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (Exception e) {
			Logger.logSevere(e);
		}
		return null;
	}

	// click
	public void clickWebElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickRadioButton(String xpath, String radioBtn) {
		try {
			List<WebElement> options = driver.findElements(By.xpath(xpath));
			for (WebElement option : options) {
				if (option.getAttribute("value").equalsIgnoreCase(radioBtn)) {
					higlightElement(option);
					clickWebElement(option);
					break;
				}
			}
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	// sendKey
	public void sendKey(WebElement element, String key) {
		try {
			element.sendKeys(key);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void sendKey(WebElement element, int key) {
		try {
			element.sendKeys(String.valueOf(key));
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	// higlight
	public void higlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red');", element);
		js.executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);
	}

	public void higlightElement(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		js.executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);
	}

	// others
	public String dataFromPropertyFile(String value) {
		reader = new BaseUtils();
		p = reader.getProperties();
		return p.getProperty(value);
	}

	public String dataFromCSVFile(String value) {
		return value;
	}

	public void dropdown(String xpath, String txt_hedDropDown, String txt_subDropDown) {
		try {
			List<WebElement> options = driver.findElements(By.xpath(xpath));
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(txt_hedDropDown)) {
					higlightElement(option);
					clickWebElement(option);
				}
				if (option.getText().equalsIgnoreCase(txt_subDropDown)) {
					higlightElement(option);
					clickWebElement(option);
					break;
				}
			}
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void textBox(String xpath, String txtBox, String Key) {
		try {
			List<WebElement> options = driver.findElements(By.xpath(xpath));
			for (WebElement option : options) {
				if (option.getAttribute("placeholder").equalsIgnoreCase(txtBox)) {
					higlightElement(option);
					sendKey(option, Key);
				}
			}
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void slider(String xpath, String txt_slider, WebElement element, int a, int b) {
		try {
			List<WebElement> options = driver.findElements(By.xpath(xpath));
			Actions action = new Actions(driver);
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(txt_slider)) {
					higlightElement(option);
					action.dragAndDropBy(element, a, b).perform();
					break;
				}
			}
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	// encoder
	public static String getEncodedText(String value) {
		byte[] encodedByte = Base64.getEncoder().encode(value.getBytes());
		String encodedString = new String(encodedByte);
		return encodedString;
	}

	public static String getdecodedText(String value) {
		byte[] decodedByte = Base64.getDecoder().decode(value.getBytes());
		String decodedString = new String(decodedByte);
		return decodedString;
	}

	// screenshot
	public void screenshot(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
				System.out.println("Screenshot taken");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
	}
}
