package steps;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.*;
import pages.RadioButtons;
import utils.BrowserFactory;

public class SeleniumEasyInputRadioButtonsSteps {
	RadioButtons radioButtons;

	public SeleniumEasyInputRadioButtonsSteps(BrowserFactory webDriver) {
		this.radioButtons = new RadioButtons(webDriver);
	}

	@Test
	@When("user verifys radio buttons page title")
	public void user_verifys_radio_buttons_page_title() {
		String Actualtitle = radioButtons.getTitle();
		String ExpatedTitle = radioButtons.getExpatedTitle();
		assertEquals(Actualtitle, ExpatedTitle);
	}

	@Then("user clicks {string} and {string} in radio buttons page")
	public void user_clicks_ageGroup_and_sex_in_radio_buttons_page(String ageGroup, String sex) {
		radioButtons.sex(sex);
		radioButtons.ageGroup(ageGroup);
	}

	@And("user clicks on get value button")
	public void user_clicks_on_get_value_button() {
		radioButtons.clickButton();
	}

	@And("user verifys {string} and {string}")
	public void user_verifys_generated_value(String sucessMessageForSex, String sucessMessageForAgeGroup) {
		boolean MessageForSex = radioButtons.resultSex(sucessMessageForSex);
		boolean MessageForAgeGroup = radioButtons.resultAgeGroup(sucessMessageForAgeGroup);
		Assert.assertEquals(true, MessageForSex);
		Assert.assertEquals(true, MessageForAgeGroup);
	}
}
