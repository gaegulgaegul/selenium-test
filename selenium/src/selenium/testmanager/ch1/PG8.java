package selenium.testmanager.ch1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.testmanager.consts.global;

// ExpectedConditions 사용
public class PG8 {

	public static void main(String[] args) {
		System.getProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(global.NAVER);
		WebDriverWait  myWaitVar = new WebDriverWait(driver, 10);
		
		// alertsPresent() - 경고 상자가 표시될 때까지 대기
		if(myWaitVar.until(ExpectedConditions.alertIsPresent()) != null) {
			System.out.println("alert is present!");
		}
		
		// elementToBeClickable() - 요소가 표시되고 동시에 활성화 될 때까지 대기
		WebElement txtUserName = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		
		// frameToBeAvailableAndSwitchToIt() - 지정된 프레임이 이미 사용 가능할 때가지 대기한 다음 자동으로 전환
		myWaitVar.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFRAME"));
		
		driver.close();
	}

}
