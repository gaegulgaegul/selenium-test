package selenium.testmanager.ch17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 서로 다른 두개의 세션 생성
public class SessionHandling {

	public static void main(String[] args) {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver1 = null;
		WebDriver driver2 = null;
		
		try {
			driver1 = new ChromeDriver();
			driver1.get(global.EX_XPATH1);
			
			driver2 = new ChromeDriver();
			driver2.get(global.EX_XPATH1);
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver1.close();
			driver2.close();
		}
	}

}
