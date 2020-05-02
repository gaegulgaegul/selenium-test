package selenium.testmanager.ch02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 체크박스 제어1
public class PG4 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = null;
		
		try {
			driver = new ChromeDriver();
			
			driver.get(global.EX_RADIO);
			
			WebElement chkFBPersist = driver.findElement(By.id("vfb-6-2"));
			
			for(int i=0; i<2; i++) {
				chkFBPersist.click();
				System.out.println(chkFBPersist.isSelected());
			}
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
