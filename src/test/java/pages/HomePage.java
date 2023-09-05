package pages;

import actions.ActionPage;
import utils.BrowserFactory;
import utils.Logger;

public class HomePage extends ActionPage {
	private String dropDown;

	public HomePage(BrowserFactory webDriver) {
		super(webDriver);
		this.dropDown = "//nav//li";
	}

	public String getTitle() {
		return GetTitle();
	}

	public String getExpatedTitle() {
		return dataFromPropertyFile("homePageTitle");
	}

	public void clickSimpleFormDemo() {
		try {
			dropdown(dropDown, "Input Forms", "Simple Form Demo");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickDragandDrop() {
		try {
			dropdown(dropDown, "Progress Bars", "Drag & Drop Sliders");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickInputFormSubmit() {
		try {
			dropdown(dropDown, "Input Forms", "Input Form Submit");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public void clickRadioButton() {
		try {
			dropdown(dropDown, "Input Forms", "Radio Buttons Demo");
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}
}
