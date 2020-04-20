package selenium.testmanager.ch6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;
import selenium.testmanager.util.EgovProperties;

// 파일 업로
public class PG1 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		String projectFilePath = EgovProperties.getPathProperty("project.file.path");
		
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_UPLOAD);
			
			WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
			
			// 파일 선택 입력 필드에 파일 경로를 입력한다.
			uploadElement.sendKeys(projectFilePath + "selenium/page/ch6/newhtml.html");
			
			// "서비스 약관에 동의 함" 확인란을 선택한다.
			driver.findElement(By.id("terms")).click();
			
			// "uploadFile" 버튼을 클릭한다.
			driver.findElement(By.name("send")).click();
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
