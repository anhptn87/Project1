package lazada;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProductDetailPage {
	@FindBy (xpath ="//div[@class='pdp-cart-concern']//button[2]")
	public WebElement btn_addToCart;
	@FindBy(xpath="//span[@class='cart-message-text']")
	public WebElement lb_cartMess;
	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
