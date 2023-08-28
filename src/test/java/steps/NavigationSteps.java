package steps;

import actions.ActionPage;
import io.cucumber.java.en.Given;
import utils.BrowserFactory;

public class NavigationSteps {
	ActionPage actionPage;

	public NavigationSteps(BrowserFactory webDriver) {
		this.actionPage = new ActionPage(webDriver);
	}

	@Given("I navigate to the {string} page")
	public void iNavigateToThePage(String pageUrl) {
		this.actionPage.visit(pageUrl);
	}
}
