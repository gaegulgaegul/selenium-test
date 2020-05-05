package selenium.testmanager.ch20;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// executeAsyncScript()를 이용한 사용시간 대기
public class JavascriptTest1 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		JavascriptExecutor js = null;
		
		try {
			
			driver = new ChromeDriver();
			
			// 타입 캐스팅을 이용한 JavascriptExecutor 객체 생성
			js = (JavascriptExecutor) driver;
			driver.get(global.EX_PAGE);
			
			driver.manage().window().maximize();
			
			// Script Timeout을 20초로 설정
			driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
			
			// 시작 시간 선언
			Long start_Time = System.currentTimeMillis();
			
			// executeAsyncScript() 호출하여 5초간 대기
			js.executeAsyncScript("window.setTimeout(arguments[argumentslength - 1], 5000)");
			
			System.out.println("Passed Time : " + (System.currentTimeMillis() - start_Time));
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
