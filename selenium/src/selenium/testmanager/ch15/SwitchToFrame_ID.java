package selenium.testmanager.ch15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// ID를 통해 iframe 전환
public class SwitchToFrame_ID {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_XPATH1);
			
			driver.manage().window().maximize();
			driver.switchTo().frame("a077aa5e");
			
			System.out.println("*******We are switch to the iframe*******");
			driver.findElement(By.xpath("html/body/a/img")).click();
			System.out.println("*******We are done*******");
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}

}
