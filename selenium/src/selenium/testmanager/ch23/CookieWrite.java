package selenium.testmanager.ch23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 저장된 쿠키를 사용하여 로그인
public class CookieWrite {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferReader = null;
		
		String strline = "";
		String val = "";
		
		String name = "";
		String value = "";
		String domain = "";
		String path = "";
		Date expiry = null;
		Boolean isSecure = null;
		
		Cookie ck = null;
		
		try {
			
			driver = new ChromeDriver();
			
			file = new File("Cookies.data");
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
			
			while((strline=bufferReader.readLine())!=null) {
				StringTokenizer token = new StringTokenizer(strline,";");
				while(token.hasMoreTokens()) {
					name = token.nextToken();
					value = token.nextToken();
					domain = token.nextToken();
					path = token.nextToken();
					expiry = null;
					
					if(!(val=token.nextToken()).equals("null")) {
						expiry = new Date(val);
					}
					isSecure = new Boolean(token.nextToken());
//					booleanValue();
					ck = new Cookie(name,value,domain,path,expiry,isSecure);
					System.out.println(ck);
					driver.manage().addCookie(ck);
					driver.get(global.EX_COOKIE);
				}
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
