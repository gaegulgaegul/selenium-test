package selenium.testmanager.ch04;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 중첩 테이블 제어
public class PG8 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		// 파일을 읽어 브라우저에서 생성
		Path filePath = Paths.get(global.EX_TABLE2);
		
		try {
			
			driver = new ChromeDriver();
			
			driver.get(filePath.toUri().toString());
			
			String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText();
			System.out.println(innerText);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
