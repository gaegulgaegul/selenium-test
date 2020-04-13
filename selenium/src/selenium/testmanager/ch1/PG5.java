package selenium.testmanager.ch1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 팝업 창 전환
public class PG5 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		String alertMessage = "";
		
		driver.get("http://jsbin.com/usidix/1");
		// input 태그 중 value가 'Go!'인 태그 클릭
		driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
		
		// 열려있는 alert으로 전환 후 텍스트 가져오기
		alertMessage = driver.switchTo().alert().getText();
		
		// alert 닫기
		driver.switchTo().alert().accept();
		
		System.out.println(alertMessage);
		driver.close();
	}

}
