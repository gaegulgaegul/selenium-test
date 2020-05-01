package selenium.testmanager.ch16;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;
import selenium.testmanager.util.EgovProperties;

// 화면 스크린샷 만들기
public class Guru99TakeScreenshot {
	
	@SuppressWarnings("static-access")
	@Test
	public void testGuru99TakeScreenShot() throws Exception {
		WebDriver driver = new ChromeDriver();
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		driver.get(global.EX_PAGE);
		this.takeSnapShot(driver, EgovProperties.getPathProperty("project.file.path")+"//test.png");
		
	}
	
	// 스크린샷 캡쳐 기능
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// 웹 드라이버 객체를 TakeScreenshot으로 변환
		TakesScreenshot srcShot = (TakesScreenshot) webdriver;
		
		// getScreenshotAs 메서드를 호출하여 이미지 파일 생성
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		
		// 이미지 파일을 새 경로로 이동
		File DestFile = new File(fileWithPath);
		
		// 대상 파일 복사
		FileUtils.copyFile(srcFile, DestFile);
	}
	
}
