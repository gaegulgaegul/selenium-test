package selenium.testmanager.ch06;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 파일 다운로드
public class PG2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_DOWNLOAD);
			
			// 파일 다운로드 커맨드 생성
			WebElement downloadButton = driver.findElement(By.id("messenger-download"));
			String sourceLocation = downloadButton.getAttribute("href");
			String wget_command = "curl -O ./" + sourceLocation;
			
			// 콘솔 창에서 커맨드 실행
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit val : " + exitVal);
			
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
