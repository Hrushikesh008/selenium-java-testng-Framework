package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SimpleFormDemo;
import utils.BrowserFactory;

public class SeleniumEasySimpleFormDemoSteps {
	public SeleniumEasySimpleFormDemoSteps(BrowserFactory webDriver) {
		this.simpleFormDemo = new SimpleFormDemo(webDriver);
	}

	SimpleFormDemo simpleFormDemo;

	@Test
	@And("user verifys simple form demo page title")
	public void user_verifys_simple_form_demo_page_title() {
		String Actualtitle = simpleFormDemo.getTitle();
		String ExpatedTitle = simpleFormDemo.getExpatedTitle();
		assertEquals(Actualtitle, ExpatedTitle);
	}

	@Then("user enters {string} in single input field text box")
	public void user_enters_in_single_input_field_text_box(String value) {
		simpleFormDemo.sendmessage(value);
	}

	@And("user clicks on single input field show message button")
	public void user_clicks_on_single_input_field_show_message_button() {
		simpleFormDemo.clickshowMessage();
	}

	@And("user verifys single input field sucess message is equal to {string}")
	public void user_verifys_single_input_field_sucess_message_is_equal_to(String sucessMessage) {
		String actualString = simpleFormDemo.yourMessage(sucessMessage);
		assertTrue(actualString.contains(sucessMessage));
	}

	@Then("user enters {int} and {int} in two input field text box")
	public void user_enters_and_in_two_input_field_text_box(int Message_A, int Message_B) {
		simpleFormDemo.sendMessage_A(Message_A);
		simpleFormDemo.sendMessage_B(Message_B);
	}

	@And("user clicks on two input field get total button")
	public void user_clicks_on_get_total_button() {
		simpleFormDemo.clickGetTotal();
	}

	@And("user verifys two input field total message is equal to {string}")
	public void user_verifys_two_input_field_total_message_is_equal_to(String Total) {
		String actualString = simpleFormDemo.verifyTotal(Total);
		assertTrue(actualString.contains(Total));
	}
}