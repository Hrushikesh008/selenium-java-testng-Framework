package pages;

import org.openqa.selenium.By;
import actions.ActionPage;
import utils.BrowserFactory;
import utils.Logger;

public class RadioButtons extends ActionPage {
	private String radioButton;
	private By result;
	private By button;
	private String radioButtonGroup;
	private By resultGroup;
	private By buttonGroup;

	public RadioButtons(BrowserFactory webDriver) {
		super(webDriver);
		this.radioButton = "//*[@class='panel-body']/label/input";
		this.button = By.xpath("//button[@id='buttoncheck']");
		this.result = By.xpath("//p[@class='radiobutton']");
		this.radioButtonGroup = "//*[@class='panel-body']/div/label/input";
		this.resultGroup = By.xpath("//p[@class='groupradiobutton']");
		this.buttonGroup = By.xpath("//button[@onclick='getValues();']");
	}

	public String getTitle() {
		return GetTitle();
	}

	public String getExpatedTitle() {
		return dataFromPropertyFile("radioButtonsTitle");
	}

	public void singleButton(String sex) {
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

	public void ageGroup(String ageGroup) {
		try {
			clickRadioButton(radioButtonGroup, ageGroup);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void sex(String sex) {
		try {
			clickRadioButton(radioButtonGroup, sex);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickButtonGroup() {
		try {
			clickWebElement(driver.findElement(buttonGroup));
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public boolean resultSexGroup(String sucessMessageForSex) {
		String Result = getText(driver.findElement(resultGroup));
		return Result.contains(sucessMessageForSex);
	}

	public boolean resultAgeGroup(String sucessMessageForAgeGroup) {
		String Result = getText(driver.findElement(resultGroup));
		return Result.contains(sucessMessageForAgeGroup);
	}
}
