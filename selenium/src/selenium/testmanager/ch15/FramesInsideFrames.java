package selenium.testmanager.ch15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 중첩 프레임 개념
public class FramesInsideFrames {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_XPATH1);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			// 외부 프레임에 텍스트 출력
			int size = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Total Frames -- " + size);
			driver.switchTo().frame(0);
			System.out.println(driver.findElement(By.xpath("xpath of the outer element")).getText());
			
			// 내부 프레임에 텍스트 출력
			size = driver.findElements(By.tagName("iframe")).size();
			System.out.println("Total Frames -- " + size);
			driver.switchTo().frame(0);
			System.out.println(driver.findElement(By.xpath("xpath of the inner element")).getText());
			
			driver.switchTo().defaultContent();
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}

}
