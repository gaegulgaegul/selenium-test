package selenium.testmanager.ch1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 브라우처 윈도우 종료
public class PG3 {

	public static void main(String[] args) {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.popuptest.com/popuptest2.html");
		
		driver.quit(); // 모든 윈도우 창이 닫힌다.
	}

}
