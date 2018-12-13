package lazada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (xpath="//div[contains(@class,'mod-input-loginName')]/input[@type='text']")
	public WebElement txt_username;
	@FindBy (xpath = "//input[@type='password']")
	public WebElement txt_password;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement btn_login;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
