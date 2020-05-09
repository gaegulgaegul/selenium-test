package selenium.testmanager.ch24;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import selenium.testmanager.consts.global;

public class DragAndDrop2 {
	
	@Test
	public void DragnDrop() {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_DRAG_AND_DROP);
			
			WebElement from1 = driver.findElement(By.xpath("//*[@id='credit2']/a"));
			WebElement to1 = driver.findElement(By.xpath("//*[@id='bank']/li"));
			WebElement from2 = driver.findElement(By.xpath("//*[@id='credit1']/a"));
			WebElement to2 = driver.findElement(By.xpath("//*[@id='loan']/li"));
			WebElement from3 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
			WebElement to3 = driver.findElement(By.xpath("//*[@id='amt7']/li"));
			WebElement from4 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
			WebElement to4 = driver.findElement(By.xpath("//*[@id='amt8']/li"));
			
			Actions act = new Actions(driver);
			
			act.dragAndDrop(from1, to1).build().perform();
			act.dragAndDrop(from2, to2).build().perform();
			act.dragAndDrop(from3, to3).build().perform();
			act.dragAndDrop(from4, to4).build().perform();
			
			if(driver.findElement(By.xpath("//a[contains(test(),'Perfect')]")).isDisplayed()) {
				System.out.println("Perfect Displayed!!!");
			} else {
				System.out.println("Perfect not Displayed!!!");
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}
	
}
