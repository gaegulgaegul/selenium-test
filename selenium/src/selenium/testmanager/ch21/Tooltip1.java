package selenium.testmanager.ch21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// Title 속성을 통해 ToolTip 추출
public class Tooltip1 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_TOOLTIP1);
			
			String expectedTooltip = "Github";
			
			WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));
			
			String actualTooltip = github.getAttribute("title");
			
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
