package pages;

import actions.ActionPage;
import utils.BrowserFactory;
import utils.Logger;

public class HomePage extends ActionPage {
	public HomePage(BrowserFactory webDriver) {
		super(webDriver);
	}

	private String xpath = "//nav//li";

	public String getTitle() {
		return GetTitle();
	}

	public String getExpatedTitle() {
		return dataFromPropertyFile("homePageTitle");
	}

	public void clickSimpleFormDemo() {
		try {
			dropdown(xpath, "Input Forms", "Simple Form Demo");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickDragandDrop() {
		try {
			dropdown(xpath, "Progress Bars", "Drag & Drop Sliders");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickInputFormSubmit() {
		try {
			dropdown(xpath, "Input Forms", "Input Form Submit");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickRadioButton() {
		try {
			dropdown(xpath, "Input Forms", "Radio Buttons Demo");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}
}
