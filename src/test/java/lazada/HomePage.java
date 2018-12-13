package lazada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath="//input[@type='search']")
	WebElement searchingBar;
	@FindBy (xpath = "//div[contains(@class,'suggest-list')]")
	WebElement suggestList;
	@FindBy (xpath = "//div[contains(@class,'suggest-list')]/a")
	WebElement suggestItems;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
