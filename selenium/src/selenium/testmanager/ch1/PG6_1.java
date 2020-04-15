package selenium.testmanager.ch1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// [대기] - 암시적 대기 : 프로그램 전체에서 기본 대기 시간을 설정
public class PG6_1 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(global.NAVER_LOGIN);
		driver.close();
		
	}

}
