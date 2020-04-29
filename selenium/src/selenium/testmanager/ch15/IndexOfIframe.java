package selenium.testmanager.ch15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 웹 요소를 기준으로 프레임 전환
public class IndexOfIframe {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_XPATH1);
			
			driver.manage().window().maximize();
			
			int size = driver.findElements(By.tagName("iframe")).size();
			
			for(int i=0; i<=size; i++) {
				driver.switchTo().frame(i);
				int total = driver.findElements(By.xpath("html/body/a/img")).size();
				System.out.println(total);
				driver.switchTo().defaultContent();
			}
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}

}
