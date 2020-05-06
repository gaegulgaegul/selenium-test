package selenium.testmanager.ch22;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 웹 페이지의 깨진 링크 찾기
public class BrokenLinks {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_BROKENLINKS);
			
			// 웹 페이지의 모든 링크 수집
			List<WebElement> links = driver.findElements(By.tagName("a"));
			
			Iterator<WebElement> it = links.iterator();
			
			while(it.hasNext()) {
				
				// URL 식별 확인
				url = it.next().getAttribute("href");
				System.out.println(url);
				
				if(url == null || url.isEmpty()) {
					System.out.println("URL is either not configured for anchor tag or it is Empty");
					continue;
				}
				if(!url.startsWith(global.EX_BROKENLINKS)) {
					System.out.println("URL belong to anthor admin, skipping.it.");
					continue;
				}
				
				// http 요청 보내기
				huc = (HttpURLConnection) new URL(url).openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				// 링크 유효성 검사
				respCode = huc.getResponseCode();
				if(respCode >= 400) {
					System.out.println(url + " is a borken link");
				} else {
					System.out.println(url + " is a vaild link");
				}
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		
	}

}
