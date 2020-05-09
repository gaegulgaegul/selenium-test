package selenium.testmanager.ch24;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import selenium.testmanager.consts.global;

public class DragAndDrop1 {
	
	@Test
	public void DragnDrop() {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_DRAG_AND_DROP);
			
			WebElement from = driver.findElement(By.xpath("//*[@id='credit2']/a"));
			
			Actions act = new Actions(driver);
			
			act.dragAndDropBy(from, 135, 40);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}
	
}
