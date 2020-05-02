package selenium.testmanager.ch04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// EXACT MATCH(전체 매칭)
public class PG1 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_LINKTEXT);
			
			// link text 전체가 일치하는 문자열 비교
			driver.findElement(By.linkText("click here")).click();
			System.out.println("title of page : " + driver.getTitle());
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
