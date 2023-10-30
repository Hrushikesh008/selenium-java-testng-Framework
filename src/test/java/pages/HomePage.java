package pages;

import actions.ActionPage;
import utils.BrowserFactory;

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

	public void clickDropdown(String dropdown, String SubDropdown) {
		dropdown(dropDown, dropdown, SubDropdown);
	}
}
