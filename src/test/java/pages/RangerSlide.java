package pages;

import org.openqa.selenium.By;
import actions.ActionPage;
import utils.BrowserFactory;
import utils.Logger;

public class RangerSlide extends ActionPage {
	private By slider;
	private By rangerValue;
	private String txt_slider;
	private String txtSlider;

	public RangerSlide(BrowserFactory webDriver) {
		super(webDriver);
		this.slider = By.xpath("//input[@type='range']");
		this.rangerValue = By.xpath("//div[@id='slider1']//output");
		this.txt_slider = "Default value 10";
		this.txtSlider = "//h4[last()]";
	}

	public String getTitle() {
		return GetTitle();
	}

	public String getExpatedTitle() {
		return dataFromPropertyFile("rangerSlideTitle");
	}

	public void dragSlider(int targetA, int targetB) {
		try {
			slider(txtSlider, txt_slider, driver.findElement(slider), targetA, targetB);
		} catch (Exception e) {
			Logger.logSevere(e);
		}
	}

	public String verifySliderPosition(String sliderPosition) {
		return getText(driver.findElement(rangerValue));
	}
}
