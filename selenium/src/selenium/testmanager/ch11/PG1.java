package selenium.testmanager.ch11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 암시적 대기
// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// 10초 동안 웹 페이지가 호출되지 않으면 throw exception
public class PG1 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(global.EX_XPATH1);
			
			String eTitle = "Demo Guru99 Page";
			String aTitle = "";
			
			// 브라우저 창을 최대화한다.
			driver.manage().window().maximize();
			
			// 제목 값을 가져온다.
			aTitle = driver.getTitle();
			
			if(aTitle.equals(eTitle)) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
