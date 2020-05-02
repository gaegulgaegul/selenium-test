package selenium.testmanager.ch09;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 동적 테이블의 모든 값 가져오기
public class PG4 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		try {
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(global.EX_DYNAMIC_TABLE2);
			
			// 테이블 찾기
			WebElement mytable = driver.findElement(By.xpath("/html/body/table/tbody"));
			
			// 테이블 행 찾기
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			
			// 테이블의 행 수를 계산
			int rows_count = rows_table.size();
			for(int row=0; row<rows_count; row++) {
				// 특정 행의 열을 선택
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				
				// 선택된 특정 행에 열을 계산
				int columns_count = Columns_row.size();
				System.out.println("Number of Cells In Row " + row + " are " + columns_count);
				
				// 루프는 특정 행의 마지막 셀까지 실행
				for(int column=0; column<columns_count; column++) {
					// 특정 셀에서 텍스트를 검색
					String celtext = Columns_row.get(column).getText();
					System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
				}
				System.out.println("------------------------------------------------------");
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
