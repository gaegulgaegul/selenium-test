package selenium.testmanager.ch11;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import selenium.testmanager.consts.global;

public class PG3 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
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
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(30, TimeUnit.SECONDS)
									.pollingEvery(5, TimeUnit.SECONDS)
									.ignoring(NoSuchElementException.class);
			WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
				}
			});
			
			clickseleniumlink.click();
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
