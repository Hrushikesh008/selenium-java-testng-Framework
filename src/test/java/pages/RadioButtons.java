package pages;

import org.openqa.selenium.By;
import actions.ActionPage;
import utils.BrowserFactory;
import utils.Logger;

public class RadioButtons extends ActionPage {
	private String radioButton;
	private By result;
	private By button;

	public RadioButtons(BrowserFactory webDriver) {
		super(webDriver);
		this.radioButton = "//*[@class='panel-body']/div/label/input";
		this.result = By.xpath("//p[@class='groupradiobutton']");
		this.button = By.xpath("//button[@onclick='getValues();']");
	}

	public String getTitle() {
		return GetTitle();
	}

	public String getExpatedTitle() {
		return dataFromPropertyFile("radioButtonsTitle");
	}

	public void ageGroup(String ageGroup) {
		try {
			clickRadioButton(radioButton, ageGroup);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void sex(String sex) {
		try {
			clickRadioButton(radioButton, sex);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickButton() {
		try {
			clickWebElement(driver.findElement(button));
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public boolean resultSex(String sucessMessageForSex) {
		String Result = getText(driver.findElement(result));
		return Result.contains(sucessMessageForSex);
	}

	public boolean resultAgeGroup(String sucessMessageForAgeGroup) {
		String Result = getText(driver.findElement(result));
		return Result.contains(sucessMessageForAgeGroup);
	}
}
