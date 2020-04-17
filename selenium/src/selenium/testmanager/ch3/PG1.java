package selenium.testmanager.ch3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.testmanager.consts.global;

// selectbox option 값 선택1
public class PG1 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get("http://demo.guru99.com/test/newtours/register.php");
			
			// selectbox Tag 선택
			Select drpCountry = new Select(driver.findElement(By.name("country")));
			
			// selectbox의 option text를 비교하여 선택
			drpCountry.selectByVisibleText("ANTARCTICA");
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
