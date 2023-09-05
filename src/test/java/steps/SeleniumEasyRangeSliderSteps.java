package steps;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import utils.BrowserFactory;
import io.cucumber.java.en.*;
import pages.RangerSlide;

public class SeleniumEasyRangeSliderSteps {
	RangerSlide rangerSlide;

	public SeleniumEasyRangeSliderSteps(BrowserFactory webDriver) {
		this.rangerSlide = new RangerSlide(webDriver);
	}

	@Test
	@Given("user verifys range slider page title")
	public void user_verifys_range_slider_page_title() {
		String Actualtitle = rangerSlide.getTitle();
		String ExpatedTitle = rangerSlide.getExpatedTitle();
		assertEquals(Actualtitle, ExpatedTitle);
	}

	@Then("user drages slider from position {int} to {int}")
	public void user_drages_slider_from_position(Integer targetA, Integer targetB) {
		rangerSlide.dragSlider(targetA, targetB);
	}

	@And("user verifys range slider position {string}")
	public void user_verifys_range_slider_position(String sliderPosition) {
		String output = rangerSlide.verifySliderPosition(sliderPosition);
		assertEquals(sliderPosition, output);
	}
}