package selenium.testmanager.ch3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.testmanager.consts.global;

//selectbox option 값 선택2
public class PG2 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get("http://jsbin.com/osebed/2");
			
			// selectbox Tag 선택
			Select fruits = new Select(driver.findElement(By.id("fruits")));
			
			// selectbox의 option text를 비교하여 선택
			fruits.selectByVisibleText("Banana");
			
			// selectbox의 인덱스를 통해 선택
			fruits.selectByIndex(1);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
