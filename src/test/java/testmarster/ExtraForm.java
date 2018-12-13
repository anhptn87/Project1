package testmarster;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtraForm {
	@FindBy (xpath = "//input[@type='text']")
	public WebElement txt_HoVaTen;
	@FindBy (xpath = "//div[contains(text(),'Họ và tên')]/span")
	public WebElement lbl_HoVaTen_asterisk;
	@FindBy (id="ddlGender")
	public WebElement btn_Gender;
	@FindBy (xpath = "//*[@id='ddlGender']/span[@class='content-display']")
	public WebElement lbl_SelectedGender;
	@FindBy (id="ddlNewsType")
	public WebElement btn_NewsType;
	@FindBy (xpath = "//*[@id='ddlNewsType']/span[@class='content-display']")
	public WebElement lbl_SelectedNewsType;
	@FindBy (css = "#allow-button")
	public WebElement btn_allow;
	//TODO: error message
	@FindBy (xpath ="")
	public WebElement err_messOnForm; 
	//TODO: error message pop up
	@FindBy (xpath ="")
	public WebElement err_messPopup; 

	public ExtraForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}

