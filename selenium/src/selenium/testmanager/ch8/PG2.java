package selenium.testmanager.ch8;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 팝업 창 처리
public class PG2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_POPUP);
			
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
			
			String MainWindow = driver.getWindowHandle();
			
			// 새로 열린 모든 창을 처리
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();
			
			while(i1.hasNext()) {
				String childWindow = i1.next();
				
				if(!MainWindow.equalsIgnoreCase(childWindow)) {
					// 하위 창으로 전환
					driver.switchTo().window(childWindow);
					driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
					
					driver.findElement(By.name("btnLogin")).click();
					
					// 자식 창 닫기
					driver.close();
				}
			}
			
			// 부모 창으로 전환(메인 창)
			driver.switchTo().window(MainWindow);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
