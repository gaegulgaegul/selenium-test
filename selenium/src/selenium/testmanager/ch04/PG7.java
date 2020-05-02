package selenium.testmanager.ch04;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// XPath를 이용하여 테이블 제어
public class PG7 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		// 파일을 읽어 브라우저에서 생성
		Path filePath = Paths.get(global.EX_TABLE1);
		
		try {
			
			driver = new ChromeDriver();
			
			driver.get(filePath.toUri().toString());
			
			// XPath
			// 1. 위치 지정자는 항상 '//'으로 시작하며 다음에는 부모 요소(table)가 온다.
			// 2. 다음에는 바로 다음 요소(tbody)들이 온다.
			// 3. 형제 요소는 동일한 부모를 값는 자식 요소를 참조한다.
			// 4. 형제와 자식 요소를 구별하는 '[]'로 묶인 숫자로 구별한다.
			String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
			System.out.println(innerText);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
