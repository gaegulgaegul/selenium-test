package selenium.testmanager.ch20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// executeScript()를 이용하여 로그인 테스트
public class JavascriptTest2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		JavascriptExecutor js = null;
		
		try {
			
			driver = new ChromeDriver();
			js = (JavascriptExecutor) driver;
			driver.get(global.EX_PAGE);
			
			WebElement button = driver.findElement(By.name("btnLogin"));
			
			driver.findElement(By.name("uid")).sendKeys("mngr34926");
			driver.findElement(By.name("password")).sendKeys("amUpenu");
			
			js.executeScript("argument[0].click();", button);
			
			js.executeScript("alert('Welcome to Guru99');");
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}

}
