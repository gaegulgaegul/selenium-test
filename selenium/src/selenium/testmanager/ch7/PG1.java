package selenium.testmanager.ch7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 데이트피커 제어
public class PG1 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(global.EX_TEST);
			
			// 날짜 시간 선택 컨트롤 찾기
			WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));
			
			// 날짜를 mm/dd/yyyy로 입력
			dateBox.sendKeys("09252013");
			
			// 탭을 눌러 포커스를 시간 필드로 이동
			dateBox.sendKeys(Keys.TAB);
			
			// 시간을 오후 2:45으로 입력
			dateBox.sendKeys("0245PM");
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
