package selenium.testmanager.ch01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// GUI 요소 찾기
public class PG2 {
	
	public static void main(String[] args) {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://www.facebook.com";
		String tagName = "";
		
		driver.get(baseUrl);
		
		// Tag Type Name 추출
		tagName = driver.findElement(By.id("email")).getTagName();
		System.out.println(tagName);
		
		driver.close();
		System.exit(0);
	}
	
}
