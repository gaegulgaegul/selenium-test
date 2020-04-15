package selenium.testmanager.ch2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 체크박스 제어2
public class PG5 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = null;
		
		try {
			driver = new ChromeDriver();
			
			driver.get(global.EX_RADIO);
			
			WebElement option1 = driver.findElement(By.id("vfb-6-0"));
			
			option1.click();
			
			if(option1.isSelected()) {
				System.out.println("CheckBox is toggled on!");
			} else {
				System.out.println("CheckBox is toggled off!");
			}
			
			Thread.sleep(2000);
			
			option1.click();
			if(!option1.isSelected()) {
				System.out.println("CheckBox is now toggled off!");
			}
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
