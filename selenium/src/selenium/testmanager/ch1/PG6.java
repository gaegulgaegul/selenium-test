package selenium.testmanager.ch1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testmanager.consts.global;

// 대기
public class PG6 {

	public static void main(String[] args) {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		// 암시적 대기 : 프로그램 전체에서 기본 대기 시간을 설정
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naver.com");
		driver.close();
		
		// 명시적 대기 : 특정 인스턴스에 대한 대기 시간만 설정
		WebDriverWait  myWaitVar = new WebDriverWait(driver, 10);
		
		driver.get(global.NAVER);
		
		// 'tutorial' 텍스트를 입력하기 전에 'username' 입력에 대한 명시적인 대기
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("tutorial");
		
		driver.close();
		
	}

}
