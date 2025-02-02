package pages;

import org.openqa.selenium.By;
import actions.ActionPage;
import utils.BrowserFactory;
import utils.Logger;

public class SimpleFormDemo extends ActionPage {
	private By txt_message;
	private By btn_showMessage;
	private By yourMessage;
	private By message_A;
	private By message_B;
	private By btn_GetTotal;
	private By total;

	public SimpleFormDemo(BrowserFactory webDriver) {
		super(webDriver);
		// Single Input Field
		this.txt_message = By.xpath("//input[@id='user-message']");
		this.btn_showMessage = By.xpath("//form[@id='get-input']/button");
		this.yourMessage = By.xpath("//span[@id='display']");
		// Two Input Field
		this.message_A = By.xpath("//form[@id='gettotal']/div[1]/input");
		this.message_B = By.xpath("//form[@id='gettotal']/div[2]/input");
		this.btn_GetTotal = By.xpath("//form[@id='gettotal']/button");
		this.total = By.xpath("//span[@id='displayvalue']");
	}

	public String getTitle() {
		return GetTitle();
	}

	public String getExpatedTitle() {
		return dataFromPropertyFile("simpleFormDemoTitle");
	}

	public void sendmessage(String value) {
		try {
			sendKey(driver.findElement(txt_message), value);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickshowMessage() {
		try {
			clickWebElement(driver.findElement(btn_showMessage));
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public String yourMessage(String sucessMessage) {
		return getText(driver.findElement(yourMessage));
	}

	public void sendMessage_A(int A) {
		try {
			sendKey(driver.findElement(message_A), A);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void sendMessage_B(int B) {
		try {
			sendKey(driver.findElement(message_B), B);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickGetTotal() {
		try {
			clickWebElement(driver.findElement(btn_GetTotal));
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public String verifyTotal(String Total) {
		return getText(driver.findElement(total));
	}
}