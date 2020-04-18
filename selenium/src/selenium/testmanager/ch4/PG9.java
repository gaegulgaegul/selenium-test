package selenium.testmanager.ch4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 속성을 사용하여 테이블 제어
public class PG9 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			
			driver.get(global.EX_TABLE3);
			
			// 속성 구분은 '@'를 앞에 선언하여 사용한다.
			String innerText = driver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr[4]/td")).getText();
			System.out.println(innerText);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
