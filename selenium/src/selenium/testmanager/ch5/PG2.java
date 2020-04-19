package selenium.testmanager.ch5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import selenium.testmanager.consts.global;

// 여러 이벤트 작성
public class PG2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.FACEBOOK);
			
			WebElement txtUsername = driver.findElement(By.id("email"));
			
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
					.moveToElement(txtUsername)			// email 태그로 이동
					.click()							// 해당 태그 클릭
					.keyDown(txtUsername, Keys.SHIFT)	// email 태그에서 shift를 누른 상태
					.sendKeys(txtUsername, "hello")		// email 태그에 'hello' 입력
					.keyUp(txtUsername, Keys.SHIFT)		// email 태그에서 shift를  상태
					.doubleClick()						// 해당 태그 더블 클릭
					.build();
			
			seriesOfActions.perform();
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
