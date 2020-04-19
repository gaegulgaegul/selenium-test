package selenium.testmanager.ch5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import selenium.testmanager.consts.global;

// 키보드 및 마우스 이벤트 처리
public class PG1 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_NEWTOURS);
			
			WebElement link_name = driver.findElement(By.linkText("Home"));
			WebElement td_Home = driver
					.findElement(By
							.xpath("//html/body/div"
									+"/table/tbody/tr/td"
									+"/table/tbody/tr/td"
									+"/table/tbody/tr/td"
									+"/table/tbody/tr"
									));
			Actions builder = new Actions(driver);
			Action mouseOverHome = builder.moveToElement(link_name).build();
			
			String bgColor = td_Home.getCssValue("background-color");
			System.out.println("Before hover: " + bgColor);
			
			// 설계한 이벤트 실행
			mouseOverHome.perform();
			
			bgColor = td_Home.getCssValue("background-color");
			System.out.println("After hover: " + bgColor);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
