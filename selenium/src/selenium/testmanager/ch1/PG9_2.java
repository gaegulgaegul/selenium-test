package selenium.testmanager.ch1;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testmanager.consts.global;

// 예외처리2
public class PG9_2 {

	public static void main(String[] args) {
		
		System.getProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		driver.get(global.NAVER_LOGIN);
		
		WebDriverWait  myWaitVar = new WebDriverWait(driver, 10);
		try {
			myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")));
			driver.findElement(By.id("id")).sendKeys("tutorial");
		} catch(TimeoutException e) {
			// 명시적 대기를 사용하는 경우 TimeoutException 예외 처리
			System.out.println(e.toString());
		} finally {
			driver.close();
		}
		
	}

}
