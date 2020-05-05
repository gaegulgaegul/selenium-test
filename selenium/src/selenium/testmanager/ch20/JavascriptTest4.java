package selenium.testmanager.ch20;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// JavascriptExecutor를 이용하여 아래로 스크롤
public class JavascriptTest4 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		JavascriptExecutor js = null;
		
		try {
			
			driver = new ChromeDriver();
			js = (JavascriptExecutor) driver;
			driver.get(global.EX_JS);
			
			driver.manage().window().maximize();
			
			js.executeScript("window.scrollBy(0, 600)");
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
