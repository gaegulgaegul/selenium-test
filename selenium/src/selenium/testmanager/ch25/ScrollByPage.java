package selenium.testmanager.ch25;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 페이지 하단의 웹 페이지를 아래로 스크롤
public class ScrollByPage {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_SCROLL1);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			driver.manage().window().maximize();
			
			js.executeScript("window.scrollTo(0,document.body.srollHegiht)");
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
