package selenium.gdtbgl93;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// 다음 포털 사이트 ID, PW 입력 후 로그인 버튼 클릭
public class SeleniumTest2 {

	public static void main(String[] args) {
		
		SeleniumTest2 selTest = new SeleniumTest2();
		selTest.login();
		
	}
	
	// WebDriver
	private WebDriver driver;
	
	private WebElement webElement;
	
	// Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "driver/chromedriver";
	
	// 크롤링 할 URL
	public String base_url;
	
	public SeleniumTest2() {
		super();
		
		// System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		// Driver SetUp
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		options.addArguments("headless"); // 웹 브라우저 비활성화
		driver = new ChromeDriver(options);
		
		// 다음 포털 사이트 리뉴얼로 인해 로그인 페이지에서 테스트 진행
//		base_url = "https://www.daum.net";
		base_url = "https://logins.daum.net/accounts/signinform.do";
	}
	
	public void login() {
		
		try {
			// get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다.)
			driver.get(base_url);
			
			// iframe으로 구성된 곳은 해당 프레임으로 전환시킨다.
//			driver.switchTo().frame(driver.findElement(By.id("loginForm")));
			
			// iframe 내부에서 id 필드 탐색
			webElement = driver.findElement(By.id("id"));
			String daum_id = "your_id";
			webElement.sendKeys(daum_id);
			
			// iframe 내부에서 pw 필드 탐색
			webElement = driver.findElement(By.id("inputPwd"));
			String daum_pw = "your_pw";
			webElement.sendKeys(daum_pw);
			
			// 로그인 버튼 클릭
			webElement = driver.findElement(By.id("loginBtn"));
			webElement.submit();
			
			Thread.sleep(20000);
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			driver.close();
			
		}
		
	}
	
}
