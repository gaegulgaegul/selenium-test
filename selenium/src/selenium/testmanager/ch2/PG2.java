package selenium.testmanager.ch2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 로그인 테스트
public class PG2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = null;
		
		try {
			driver = new ChromeDriver();
			
			driver.get(global.EX_LOGIN);
			
			// 태그 정보 설정
			WebElement email = driver.findElement(By.id("email"));
			WebElement pw = driver.findElement(By.id("passwd"));
			WebElement login = driver.findElement(By.id("SubmitLogin"));
			
			// 텍스트 값 입력
			email.sendKeys("abcd@gmail.com");
			pw.sendKeys("abcdefghlkjl");
			
			Thread.sleep(2000);
			
			login.click();
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}
	
}
