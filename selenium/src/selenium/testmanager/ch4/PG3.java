package selenium.testmanager.ch4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 매칭 시 대소문자 구분
public class PG3 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_NEWTOURS);
			
			String theLinkText = driver.findElement(By.partialLinkText("egis")).getText();
			System.out.println(theLinkText);
			
			theLinkText = driver.findElement(By.partialLinkText("EGIS")).getText();
			System.out.println(theLinkText);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
