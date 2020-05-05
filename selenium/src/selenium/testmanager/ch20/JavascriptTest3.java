package selenium.testmanager.ch20;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// Scrape Site & 다른 페이지 이동
public class JavascriptTest3 {
	
	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		JavascriptExecutor js = null;
		
		try {
			
			driver = new ChromeDriver();
			js = (JavascriptExecutor) driver;
			driver.get(global.EX_PAGE);
			
			String domainName = js.executeScript("return document.domain;").toString();
			System.out.println("Domain name of the site : " + domainName);
			
			String url = js.executeScript("return document.URL;").toString();
			System.out.println("URL of the site : " + url);
			
			String titleName = js.executeScript("return document.title;").toString();
			System.out.println("Title of the page : " + titleName);
			
			js.executeScript("window.location = 'http://demo.guru99.com/'");
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
