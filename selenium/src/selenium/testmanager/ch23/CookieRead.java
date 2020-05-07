package selenium.testmanager.ch23;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// selenium 쿠키 처리
public class CookieRead {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		File file = null;
		FileWriter fileWrite = null;
		BufferedWriter bWrite = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_COOKIE);
			
			driver.findElement(By.name("username")).sendKeys("abc123");
			driver.findElement(By.name("password")).sendKeys("123xyz");
			driver.findElement(By.name("submit")).click();
			
			file = new File("Cookies.data");
			file.delete();
			file.createNewFile();
			
			fileWrite = new FileWriter(file);
			bWrite = new BufferedWriter(fileWrite);
			
			// 쿠키정보 읽기
			for(Cookie ck : driver.manage().getCookies()) {
				bWrite.write(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
				
				bWrite.newLine();
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bWrite.close();
				fileWrite.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.close();
		}
		
	}

}
