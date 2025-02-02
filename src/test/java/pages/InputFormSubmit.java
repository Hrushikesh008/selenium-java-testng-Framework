package pages;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import actions.ActionPage;
import io.cucumber.datatable.DataTable;
import utils.BaseUtils;
import utils.BrowserFactory;
import utils.Logger;

public class InputFormSubmit extends ActionPage {
	BaseUtils BaseUtils;
	private String stateXpath;
	private int errerExpacted;
	private By Send;
	private By error;
	private By inputValuePD;

	public InputFormSubmit(BrowserFactory webDriver) {
		super(webDriver);
		this.stateXpath = "//select[@name='state']/option";
		this.errerExpacted = 0;
		this.Send = By.xpath("//button[@class='btn btn-default']");
		this.error = By.xpath("//div[@class='form-group has-feedback has-error']//label");
		this.inputValuePD = By.xpath(
				"//label[text()='Project Description']/following-sibling::div[@class='col-md-4 inputGroupContainer']/div/textarea");
	}

	private WebElement inputValue(String fieldName) {
		return driver.findElement(By.xpath("//label[text()='" + fieldName
				+ "']/following-sibling::div[@class='col-md-4 inputGroupContainer']/div/input"));
	}

	private WebElement errorMessage(String ErrorMessage) {
		return driver.findElement(By.xpath("//small[normalize-space()='" + ErrorMessage + "']"));
	}

	public String getTitle() {
		return GetTitle();
	}

	public String getExpatedTitle() {
		return dataFromPropertyFile("inputFormSubmitTitle");
	}

	// From property file
	public void dataFromPropertyFile(DataTable dataTable) {
		try {
			List<Map<String, String>> signForms = dataTable.asMaps();
			for (Map<String, String> form : signForms) {
				String InputValue = form.get("inputValue");
				String inputValueFromPropertyFile = getdecodedText(dataFromPropertyFile(InputValue));
				String FieldName = form.get("fieldName");
				sendKey(inputValue(FieldName), inputValueFromPropertyFile);
			}
			sendKey(driver.findElement(inputValuePD), "testpass30");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void selectState() {
		try {
			dropdown(stateXpath, "California", null);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void fillTextinputFromPropertyFile(DataTable dataTable) {
		dataFromPropertyFile(dataTable);
		selectState();
	}

	// From CSV File
	public void dataFromCSVFile(DataTable dataTable) {
		BaseUtils = new BaseUtils();
		try {
			List<Map<String, String>> signForms = dataTable.asMaps();
			for (Map<String, String> form : signForms) {
				String InputValue = form.get("inputValueCSV");
				String InputValueFromCSV = BaseUtils.CSVReader(InputValue);
				String DecodedFirstName = getdecodedText(InputValueFromCSV);
				String FieldName = form.get("fieldName");
				sendKey((inputValue(FieldName)), DecodedFirstName);
			}
			sendKey(driver.findElement(inputValuePD), "testpass30");
		} catch (IOException e) {
			Logger.logSevere(e);
		}
	}

	public void fillTextinputFromCSVFile(DataTable dataTable) {
		dataFromCSVFile(dataTable);
		selectState();
	}

	public void genrateDataFromDataTable(DataTable dataTable) {
		try {
			List<Map<String, String>> signForms = dataTable.asMaps();
			for (Map<String, String> form : signForms) {
				String FieldName = form.get("fieldName");
				String InputValue = form.get("inputValue");
				sendKey(inputValue(FieldName), InputValue);
			}
			sendKey(driver.findElement(inputValuePD), "testpass30");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void fillTextinput(DataTable dataTable) {
		genrateDataFromDataTable(dataTable);
		selectState();
	}

	public void clickSend() {
		try {
			clickWebElement(driver.findElement(Send));
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void errorMessage() {
		Wait();
		List<WebElement> elements = driver.findElements(error);
		int colour = elements.size();
		assertEquals(errerExpacted, colour);
	}

	public void errorMessageVerification(DataTable dataTable) {
		List<Map<String, String>> signForms = dataTable.asMaps();
		for (Map<String, String> form : signForms) {
			String ErrorMessage = form.get("ErrorMessage");
			String FirstName = getText(WaitForElement(errorMessage(ErrorMessage)));
			assertEquals(FirstName, ErrorMessage);
		}
	}
}