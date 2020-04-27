package selenium.testmanager.ch13;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

public class Test99GuruLogin {
	
	static WebDriver driver;
	static Guru99Login objLogin;
	static Guru99HomePage objHomePage;
	
	public static void setup() {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(global.EX_PAGE);
	}
	
	public static void test_Home_Page_Appear_Correct() {
		objLogin = new Guru99Login(driver);
		
		// 로그인 페이지 제목 확인
		String loginPageTitle = objLogin.getLoginTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		
		// 로그인
		objLogin.loginToGuru99("mgr123", "mgr123");
		
		// 다음 페이지로 이동
		objHomePage = new Guru99HomePage(driver);
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}
	
	public static void main(String[] args) {
		try {
			setup();
			test_Home_Page_Appear_Correct();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
