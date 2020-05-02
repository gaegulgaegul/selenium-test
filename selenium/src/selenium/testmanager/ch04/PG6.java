package selenium.testmanager.ch04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 이미지 링크 엑세스
public class PG6 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			
			driver.get(global.FACEBOOK_LOGIN);
			
			// 왼쪽 상단 'Facebook' 로고 클릭
			driver.findElement(By.cssSelector("a[title=\"Facebook 홈으로 이동\"]")).click();
			
			if(driver.getTitle().equals("Facebook - 로그인 또는 가입")) {
				System.out.println("We are back at Facebook's homepage");
			} else {
				System.out.println("We are Not in Facebook's homepage");
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
