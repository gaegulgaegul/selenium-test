package selenium.testmanager.ch01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// Selenium WebDriver
public class PG1 {
	
	public static void main(String[] args) {
		// 객체 / 변수 선언 및 인스턴스 화
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://demo.gur99.com/test/newtours/";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		
		// Chrome 을 시작하고 기본 URL로 연결
		driver.get(baseUrl);
		
		// 제목의 실제 값을 얻는다.
		actualTitle = driver.getTitle();
		
		// Title 비교
		if(actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
		
		driver.close();
	}
	
}
