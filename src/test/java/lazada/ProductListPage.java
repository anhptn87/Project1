package lazada;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
	@FindBy(xpath ="//div[@data-qa-locator='product-item']")
	public WebElement products;
	

	public ProductListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
