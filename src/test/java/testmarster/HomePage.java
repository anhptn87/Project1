package testmarster;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//	WebDriver driver;
	@FindBy (xpath="//input")
	public WebElement txtSubEmail;
	@FindBy (xpath = "//input/../following-sibling::div[2]/span")
	public WebElement errorOnPage;
	@FindBy (css = "#allow-button")
	public WebElement btn_allow;
	@FindBy(xpath="//div[@class='body-message']")
	public WebElement popUpMess;


	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
