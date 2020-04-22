package selenium.testmanager.ch8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 경고 메세지 처리
public class PG1 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_DELETE_CUSTOMER);
			
			driver.findElement(By.name("cusid")).sendKeys("53920");
			driver.findElement(By.name("submit")).submit();
			
			// Alert으로 전환
			Alert alert = driver.switchTo().alert();
			
			// 경고 메시지를 캡쳐
			String alertMessage = driver.switchTo().alert().getText();
			
			// 경고 메시지 표시
			System.out.println(alertMessage);
			Thread.sleep(3000);
			
			// 알람 수신
			alert.accept();
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
