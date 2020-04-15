package selenium.testmanager.ch1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// [조건] - isDeployed(): 명령을 실행하기 전에 특정 요소가 표시되는지 여부 체크
public class PG7_2 {

	public static void main(String[] args) {
		
		WebDriver driver = null;
		
		try {
			System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
			
			driver = new ChromeDriver();
			
			driver.get(global.NAVER_LOGIN);
			
			if(driver.findElement(By.id("id")).isDisplayed()) {
				System.out.println(driver.findElement(By.id("id")).getTagName());
			}
		
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
