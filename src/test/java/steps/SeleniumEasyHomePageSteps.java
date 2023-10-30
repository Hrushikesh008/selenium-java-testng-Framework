package steps;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import pages.HomePage;
import utils.BrowserFactory;

public class SeleniumEasyHomePageSteps {
	HomePage homePage;

	public SeleniumEasyHomePageSteps(BrowserFactory webDriver) {
		this.homePage = new HomePage(webDriver);
	}

	@Test
	@And("user is on selenium easy homePage verifying page title")
	public void user_is_on_selenium_easy_home_page_verifying_page_title() {
		String Actualtitle = homePage.getTitle();
		String ExpatedTitle = homePage.getExpatedTitle();
		assertEquals(Actualtitle, ExpatedTitle);
	}

	@And("user navigate to {string} page by clicking {string} dropdown")
	public void user_navigate_to_input_form_submit_page(String dropdown, String SubDropdown) {
		homePage.clickDropdown(dropdown, SubDropdown);
	}
}
