package selenium.testmanager.ch19;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testmanager.consts.global;

// Ajax 처리
public class AjaxDemo {

	@Test
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		WebDriverWait wait = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(global.EX_AJAX);
			
			By container = By.cssSelector(".container");
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(container));
			
			// ajax 호출을 수행하기 전에 텍스트를 가져온다.
			WebElement noTextElement = driver.findElement(By.className("radiobutton"));
			
			String textBefore = noTextElement.getText().trim();
			
			// 라디오 버튼 클릭
			driver.findElement(By.id("yes")).click();
			
			// Check Button 클릭
			driver.findElement(By.id("buttoncheck")).click();
			
			// ajax 호출 후 텍스트를 얻는다.
			WebElement textElement = driver.findElement(By.className("radiobutton"));
			wait.until(ExpectedConditions.visibilityOf(textElement));
			String textAfter = textElement.getText().trim();
			
			Assert.assertNotEquals(textBefore, textAfter);
			System.out.println("Ajax Call Performed");
			
			String expectedText = "Radio button is checked and it's value is Yes";
			
			// 	ajax 호출 후 텍스트가 업데이트 된 예상 텍스트 확인
			Assert.assertEquals(textAfter, expectedText);
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
