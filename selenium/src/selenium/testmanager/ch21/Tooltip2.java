package selenium.testmanager.ch21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import selenium.testmanager.consts.global;

// 버튼 속성을 통해 Text를 추출
public class Tooltip2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_TOOLTIP2);
			
			String expectedTooltip = "What's new in 3.2";
			
			WebElement download = driver.findElement(By.xpath(".//*[@id='download_now']"));
			Actions builder = new Actions(driver);
			
			builder.clickAndHold().moveToElement(download);
			builder.moveToElement(download).build().perform();
			
			WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
			
			String actualTooltip = toolTipElement.getText();
			
			System.out.println("Actual Title of Tool Tip " + actualTooltip);
			if(actualTooltip.equals(expectedTooltip)) {
				System.out.println("Test Case Passed");
			}
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
