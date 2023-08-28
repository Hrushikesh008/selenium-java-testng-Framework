package steps;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.cucumber.java.en.*;
import pages.InputFormSubmit;
import utils.BrowserFactory;
import io.cucumber.datatable.DataTable;

public class SeleniumEasyInputFormSubmitSteps {
	public SeleniumEasyInputFormSubmitSteps(BrowserFactory webDriver) {
		this.inputFormSubmit = new InputFormSubmit(webDriver);
	}

	InputFormSubmit inputFormSubmit;

	@Test
	@And("user verifys input form submit page title")
	public void user_verifys_input_form_submit_page_title() {
		String Actualtitle = inputFormSubmit.getTitle();
		String ExpatedTitle = inputFormSubmit.getExpatedTitle();
		assertEquals(Actualtitle, ExpatedTitle);
	}

	@When("user fills input text box from property file")
	public void user_fills_input_text_box_from_property_file(DataTable dataTable) {
		inputFormSubmit.fillTextinputFromPropertyFile(dataTable);
	}

	@When("user fills input text box from CSV files")
	public void user_fills_input_text_box_from_csv_files(DataTable dataTable) {
		inputFormSubmit.fillTextinputFromCSVFile(dataTable);
	}

	@When("user fills input in text box")
	public void user_fills_input(DataTable dataTable) {
		inputFormSubmit.fillTextinput(dataTable);
	}

	@And("user clicks send button")
	public void user_clicks_send_button() {
		inputFormSubmit.clickSend();
	}

	@Then("user verifys if input box are filled")
	public void user_verifys_if_input_box_are_filled() {
		inputFormSubmit.errorMessage();
	}

	@Then("user verifys if error message is visible")
	public void user_verifys_if_error_message_is_visible_for_firstname_and_email_input(DataTable dataTable) {
		inputFormSubmit.errorMessageVerification(dataTable);
	}
}
