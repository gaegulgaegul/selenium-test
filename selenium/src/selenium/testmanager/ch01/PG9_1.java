package selenium.testmanager.ch01;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 예외처리1
public class PG9_1 {

	public static void main(String[] args) {
		
		System.getProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		driver.get(global.NAVER_LOGIN);
		
		WebElement txtbox_username = driver.findElement(By.id("id"));
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
		
	}

}
