package steps;

import actions.ActionPage;
import io.cucumber.java.en.Given;
import utils.BrowserFactory;

public class NavigationSteps {
	ActionPage actionPage;

	public NavigationSteps(BrowserFactory webDriver) {
		this.actionPage = new ActionPage(webDriver);
	}

	@Given("user navigate to the {string} page")
	public void userNavigateToThePage(String pageUrl) {
		this.actionPage.visit(pageUrl);
	}
}
