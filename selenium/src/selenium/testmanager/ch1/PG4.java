package selenium.testmanager.ch1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 프레임 간 전환
public class PG4 {
	
	public static void main(String[] args) {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
		
		// 프레임의 name속성을 이용하여 전환
		driver.switchTo().frame("classFrame");
		
		// Deprecated 링크 텍스트 클릭
		driver.findElement(By.linkText("Deprecated")).click();
		
		driver.close();
	}

}
