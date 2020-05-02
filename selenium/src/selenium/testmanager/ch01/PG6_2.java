package selenium.testmanager.ch01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testmanager.consts.global;

// [대기] - 명시적 대기 : 특정 인스턴스에 대한 대기 시간만 설정
public class PG6_2 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait  myWaitVar = new WebDriverWait(driver, 10);
		
		driver.get(global.NAVER_LOGIN);
		
		// 'tutorial' 텍스트를 입력하기 전에 'id' 입력에 대한 명시적인 대기
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")));
		driver.findElement(By.id("id")).sendKeys("tutorial");
		
		driver.close();
		
	}
	
}
