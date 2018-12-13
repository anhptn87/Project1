package testmarster;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ExtraFormTest {
	WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://testmaster.vn/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
//	@Test
	public void _1_initialForm () {
		try {
			HomePage hp = new HomePage(driver);
			ExtraForm ex = new ExtraForm(driver);
			Date date = new Date(); date.toString();
			
			SubscriberTest st = new SubscriberTest();
			st.enterEmail(hp, "anhptn"+date.getTime()+"@qa.team");
			
			Thread.sleep(500);
			System.out.println(ex.lbl_HoVaTen_asterisk.getText());
			assertTrue(ex.lbl_HoVaTen_asterisk.getText().contains("*"));
			System.out.println(ex.lbl_SelectedGender.getText());
			assertTrue(ex.lbl_SelectedGender.getText().equalsIgnoreCase("Không xác định"));
			System.out.println(ex.lbl_SelectedNewsType.getText());
			assertTrue(ex.lbl_SelectedNewsType.getText().equalsIgnoreCase("Nhận tất cả các loại tin"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void enterFullName (ExtraForm ex, String fullname) {
		ex.txt_HoVaTen.clear();
		ex.txt_HoVaTen.sendKeys(fullname);
		ex.btn_allow.click();

	}
//	@Test
//	@Ignore
	public void _2_invalidFullname () {
		
		_1_initialForm();
		
		ExtraForm ex = new ExtraForm(driver);
		// full name co ky tu dac biet
		enterFullName(ex, "phan anh @@@");

		//TODO sua erro mess
		Alert alert = driver.switchTo().alert();
		assertTrue(alert.getText().toLowerCase().contains("ký tự đặc biệt"));
		alert.accept();

		// full name co chu so
		enterFullName(ex, "phan anh 1213");
		//TODO sua erro mess
		assertTrue(alert.getText().toLowerCase().contains("số"));
		alert.accept();

	}
	@Test
	@Ignore
	public void _3_registerSuccessfullly() {
		_1_initialForm();
		
		ExtraForm ex = new ExtraForm(driver);

		enterFullName(ex, "phan anh");

		// TODO: 3.	Thông báo người dùng đã đăng ký thành công và cần check Email để kích hoạt
		Alert alert = driver.switchTo().alert();
		assertTrue(alert.getText().toLowerCase().contains("thành công"));
		alert.accept();
	}
	@Test
	@Ignore
	public void _4_checkLinkInEmail() {
	}

}
