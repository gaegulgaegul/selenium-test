package selenium.testmanager.ch11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testmanager.consts.global;
// 명시적 대기
// 동적으로 로드된 Ajax요소를 기다리기 때문에 암시적 대기보다 더 나은 옵션을 제공한다.
public class PG2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			String eTitle = "Demo Guru99 Page";
			String aTitle = "";
			
			driver.get(global.EX_XPATH1);
			driver.manage().window().maximize();
			
			aTitle = driver.getTitle();
			
			if(aTitle.equals(eTitle)) {
				System.out.println("Test Passed");
			} else {
				System.out.println("Test Failed");
			}
			
			WebElement  guru99seleniumlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i")));
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
