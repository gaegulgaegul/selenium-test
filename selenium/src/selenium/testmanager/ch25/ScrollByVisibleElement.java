package selenium.testmanager.ch25;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 요소의 가시성에 따라 웹 페이지를 아래로 스크롤
public class ScrollByVisibleElement {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_SCROLL1);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			driver.manage().window().maximize();
			
			WebElement element = driver.findElement(By.linkText("Linux"));
			
			js.executeScript("arguments[0].scrollIntoView();", element);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
