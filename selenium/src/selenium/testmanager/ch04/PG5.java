package selenium.testmanager.ch04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 블록 외부 및 내부 링크
public class PG5 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_BLOCK);
			
			// 내부 링크 선택
			driver.findElement(By.partialLinkText("Inside")).click();
			System.out.println(driver.getTitle());
			
			// 페이지 뒤로가기
			driver.navigate().back();
			
			// 외부 링크 선택
			driver.findElement(By.partialLinkText("Outside")).click();
			System.out.println(driver.getTitle());
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
