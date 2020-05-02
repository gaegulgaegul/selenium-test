package selenium.testmanager.ch04;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 모든 링크 조회
public class PG4 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_NEWTOURS);
			
			String underConsTitle = "Under Construction: Mercury Tours";
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.get(global.EX_NEWTOURS);
			
			List<WebElement> linkElements = driver.findElements(By.tagName("a"));
			String[] linkTexts = new String[linkElements.size()];
			int i = 0;
			
			// 각 링크 요소의 링크 텍스트를 추출한다.
			for(WebElement e : linkElements) {
				linkTexts[i] = e.getText();
				i++;
			}
			
			// 각 링크를 테스트한다.
			for(String t : linkTexts) {
				if(!"".equals(t) && null != t) {
					driver.findElement(By.linkText(t)).click();
					if(driver.getTitle().equals(underConsTitle)) {
						System.out.println("\"" + t + "\"" + " is under construction.");
					} else {
						System.out.println("\"" + t + "\"" + " is working.");
					}
					driver.navigate().back();
				}
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
