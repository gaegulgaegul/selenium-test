package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 네이버 포털 사이트 크롤링
public class SeleniumTest {

	public static void main(String[] args) {
		
		SeleniumTest selTest = new SeleniumTest();
		selTest.crawl();
		
	}
	
	// WebDriver
	private WebDriver driver;
	
	// Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "driver/chromedriver";
	
	// 크롤링 할 URL
	public String base_url;
	
	public SeleniumTest() {
		super();
		
		// System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		// Driver SetUp
		driver = new ChromeDriver();
		base_url = "https://www.naver.com";
	}
	
	public void crawl() {
		
		try {
			// get page( = 브라우져에서 url을 주소창에 넣은 후 request한 것과 같다.)
			driver.get(base_url);
			System.out.println(driver.getPageSource());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}
	
}
