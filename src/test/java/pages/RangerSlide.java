package pages;

import org.openqa.selenium.By;
import actions.ActionPage;
import utils.BrowserFactory;
import utils.Logger;

public class RangerSlide extends ActionPage {
	public RangerSlide(BrowserFactory webDriver) {
		super(webDriver);
	}

	private By slider = By.xpath("//input[@type='range']");
	private By rangerValue1 = By.xpath("//div[@id='slider1']//output");
	private String txt_slider1 = "Default value 10";
	private String txtSlider = "//h4[last()]";

	public String getTitle() {
		return GetTitle();
	}

	public String getExpatedTitle() {
		return dataFromPropertyFile("rangerSlideTitle");
	}

	public void dragSlider(int targetA, int targetB) {
		try {
			slider(txtSlider, txt_slider1, driver.findElement(slider), targetA, targetB);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public String verifySliderPosition(String sliderPosition) {
		return getText(driver.findElement(rangerValue1));
	}
}
