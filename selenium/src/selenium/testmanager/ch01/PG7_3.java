package selenium.testmanager.ch01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// [조건] - isSelected(): 드롭 다운 상자에서 특정 확인란, 라디오버튼 또는 옵션의 선택여부를 체크
public class PG7_3 {
	
	public static void main(String[] args) {
		
		WebDriver driver = null;
		
		try {
			System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
			
			driver = new ChromeDriver();
			
			driver.get(global.EX_SELECTBOX);
			
			if(!driver.findElement(By.name("job")).isSelected()) {
				System.out.println(driver.findElement(By.name("job")).findElement(By.cssSelector("option[value=학생")).getText());
			}
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}
	
}
