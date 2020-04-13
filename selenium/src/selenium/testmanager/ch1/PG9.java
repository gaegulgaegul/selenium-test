package selenium.testmanager.ch1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testmanager.consts.global;

// 예외처리
public class PG9 {
	
	public static void main(String[] args) {
		
		System.getProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		driver.get(global.NAVER);
		
		WebElement txtbox_username = driver.findElement(By.id("username"));
		try {
			if(txtbox_username.isEnabled()) {
				txtbox_username.sendKeys("tutorial");
			}
		} catch(NoSuchElementException e) {
			// isEnabled(), isDisplayed(), isSelected()를 사하는 경우 WebDriver는 요소가 이미 페이지에 있다고 가정
			// 없는 경우를 대비해 예외처리
			System.out.println(e.toString());
		} finally {
			driver.close();
		}
		
		WebDriverWait  myWaitVar = new WebDriverWait(driver, 10);
		try {
			myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			driver.findElement(By.id("username")).sendKeys("tutorial");
		} catch(TimeoutException e) {
			// 명시적 대기를 사용하는 경우 TimeoutException 예외 처리
			System.out.println(e.toString());
		} finally {
			driver.close();
		}
		
	}
	
}
