package selenium.testmanager.ch1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 조건
public class PG7 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(global.NAVER);
		
		// isEnabled() - 명령을 실행하기 전에 특정 요소가 활성화되었는지 여부 체크
		WebElement txtbox_username = driver.findElement(By.id("username"));
		if(txtbox_username.isEnabled()) {
			txtbox_username.sendKeys("tutorial");
		}
		
		// isDeployed() - 명령을 실행하기 전에 특정 요소가 표시되는지 여부 체크
		if(driver.findElement(By.id("username")).isDisplayed()) {
			System.out.println(driver.findElement(By.id("username")).getTagName());
		}
		
		// isSelected() - 드롭 다운 상자에서 특정 확인란, 라디오버튼 또는 옵션의 선택여부를 체크
		if(driver.findElement(By.id("one-way")).isSelected()) {
			driver.findElement(By.id("two-way")).click();
		}
		
		driver.close();
		
	}
	
}
