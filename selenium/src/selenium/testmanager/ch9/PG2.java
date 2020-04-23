package selenium.testmanager.ch9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 동적 테이블 특정 컬럼 선택하기
public class PG2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_DYNAMIC_TABLE1);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement baseTable = driver.findElement(By.tagName("table"));
			
			// 테이블의 세번째 행 찾기
			WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
			String rowtext = tableRow.getText();
			System.out.println("Third row of table : " + rowtext);
			
			// 세번째 행의 두번째 열 데이터를 가져오기
			WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
			String valueIneed = cellIneed.getText();
			System.out.println("Cell value is : " + valueIneed);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
