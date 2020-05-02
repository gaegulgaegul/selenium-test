package selenium.testmanager.ch17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 병렬로 스크립트 실행
public class TestGuru99MultipleSession {
	
	@Test
	public void executeSessionOne() {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get(global.EX_XPATH1);
		driver.findElement(By.name("uid")).sendKeys("Driver 1");
	}
	
	@Test
	public void executeSessionTwo() {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get(global.EX_XPATH1);
		driver.findElement(By.name("uid")).sendKeys("Driver 2");
	}
	
	@Test
	public void executeSessionThree() {
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = new ChromeDriver();
		driver.get(global.EX_XPATH1);
		driver.findElement(By.name("uid")).sendKeys("Driver 3");
	}
	
}
