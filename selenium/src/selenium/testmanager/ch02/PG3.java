package selenium.testmanager.ch02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 라디오버튼 제어
public class PG3 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = null;
		
		try {
			driver = new ChromeDriver();
			
			driver.get(global.EX_RADIO);
			
			WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
			WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
			
			// 라디오1 클릭
			radio1.click();
			
			Thread.sleep(3000);
			
			// 라디오 2 클릭
			radio2.click();
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
