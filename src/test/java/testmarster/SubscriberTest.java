package testmarster;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SubscriberTest {
	WebDriver driver;
	@Before
	public void setUp () {
		driver =  new ChromeDriver();
		driver.get("http://testmaster.vn/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);

	}

	public void enterEmail (HomePage homep, String email) {
		homep.txtSubEmail.clear();
		homep.txtSubEmail.sendKeys(email);
		homep.txtSubEmail.sendKeys(Keys.ENTER);
	}
	@Test
//	@Ignore
	public void _1_invalidEmail () {
		String expectErr = "Email không đúng định dạng";
		try {
			HomePage homep = new HomePage(driver);

			enterEmail(homep,"anh@anh");

			String actualErr = homep.errorOnPage.getText();
			if(actualErr!=null )
				assertTrue(actualErr.contains(expectErr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
//	@Ignore
	public void _2_usedEmail () throws InterruptedException {
		HomePage homep = new HomePage(driver);
		String expectErr ="đã được sử dụng";

		enterEmail(homep,"anhptn@qa.team");

		Thread.sleep(500); // da su dung waith 
		System.out.println(homep.popUpMess.getText());
		assertTrue (homep.popUpMess.getText().toLowerCase().contains(expectErr));
	}
	@Test
//	@Ignore
	public void _3_validEmail () {
		HomePage homep = new HomePage(driver);
		Date date = new Date(); date.toString();

		enterEmail(homep,"anhptn"+date.getTime()+"@qa.team");
		ExtraForm ex = new ExtraForm(driver);
		ex.txt_HoVaTen.isEnabled();

		assertTrue(ex.txt_HoVaTen.isEnabled());

	}
	public void test() {
		Date date = new Date(); date.getTime();
		System.out.println(date.getTime());
	}
	@After
	//@Ignore
	public void endTest() {
		driver.quit();
	}



}
