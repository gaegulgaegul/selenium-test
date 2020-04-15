package selenium.testmanager.ch2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 값 입력하기
public class PG1 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = null;
		
		try {
			driver = new ChromeDriver();
			
			driver.get(global.EX_LOGIN);
			
			// 태그 정보 설정
			WebElement email = driver.findElement(By.id("email"));
			WebElement pw = driver.findElement(By.id("passwd"));
			
			// 텍스트 값 입력
			email.sendKeys("asdf@gmail.com");
			pw.sendKeys("123456");
			
			Thread.sleep(3000);
			
			// 태그 초기화
			email.clear();
			pw.clear();
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
