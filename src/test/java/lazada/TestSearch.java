package lazada;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSearch{  
	WebDriver driver;
	@Before
	public void setUp(){
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.get("https://www.lazada.vn/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		this.login(driver);
	}
	public void login(WebDriver driver) {
		driver.navigate().to("https://member.lazada.vn/user/login");
		LoginPage li = new LoginPage(driver);
		li.txt_username.sendKeys("0915120564");
		li.txt_password.sendKeys("a11111111@");
		//TODO: Chưa xử lý slide action
		li.btn_login.click();

	}
//	@Test
	public void _1_display10TrueSuggestions() {
		HomePage homep = new HomePage(driver);
		String keyword = "áo";

		homep.searchingBar.clear();
		homep.searchingBar.sendKeys(keyword);

		List<WebElement> itemList = homep.suggestList.findElements(By.xpath("./a//b"));
		// there should be 10 suggestion
		assertTrue(itemList.size()==10);

		// each suggestion should contain the keyword
		for (WebElement item : itemList) {
			assertTrue(item.getText().equalsIgnoreCase(keyword));
		}
	}

	@Test
	public void _2_choose1andBuy() {
		HomePage hp = new HomePage(driver);
		hp.searchingBar.clear();
		hp.searchingBar.sendKeys("áo");
		// choose the first suggestion
		hp.suggestItems.click();
		ProductListPage plp = new ProductListPage(driver);
		// choose the first product on the PLP
		plp.products.click();
		
		ProductDetailPage pdp = new ProductDetailPage(driver);
		// click on add to cart button
		/*Actions actions = new Actions(driver);
		actions.moveToElement(pdp.btn_addToCart);
		actions.perform();*/
		
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pdp.btn_addToCart);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250);");
		
		pdp.btn_addToCart.click();
		
		// Assert message: 1 new item(s) have been added to your cart
		assertTrue(pdp.lb_cartMess.getText().contains("1"));
	}

}
