package selenium.testmanager.ch7;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

public class PG2 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		String dateTime = "12/07/2014 2:00 PM";
		
		try {
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(global.EX_DATEPICKER);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// 캘린더를 여는 버튼
			WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
			selectDate.click();
			
			// 캘린더에서 다음으로 이동하는 버튼
			WebElement nextLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
			
			// 캘린더 헤더 가운데에 있는 버튼을 클릭
			WebElement midLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));
			
			// 캘린더에서 이전 달로 이동하는 버튼
			WebElement previousLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]"));
			
			// 날짜 부분만 나누기 위해 날짜/시간을 분할
			String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
			
			// 현재 년도와 년도의차이를 계산하여 달력으로 설정
			int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
			
			midLink.click();
			
			if(yearDiff != 0) {
				// 다음 년도로 이동
				if(yearDiff > 0) {
					for(int i=0; i<yearDiff; i++) {
						System.out.println("Year Diff -> " + i);
						nextLink.click();
					}
				}
				// 이전 년도로 이동
				else if(yearDiff < 0) {
					for(int i=0;i<(yearDiff*(-1)); i++) {
						System.out.println("Year Diff -> " + i);
						previousLink.click();
					}
				}
			}
			
			Thread.sleep(1000);
			
			// 캘린더에서 모든 달을 가져와 올바른 달을 선택한다.
			List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
			list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
			
			Thread.sleep(1000);
			
			// 캘린더에서 모든 날짜를 가져와 올바른 날짜를 선택한다.
			List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
			list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
			
			// 시간 선택 도구 클릭
			WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));
			selectTime.click();
			
			// 시간 목록 가져오기
			List<WebElement> allTime = driver.findElements(By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));
			dateTime = dateTime.split(" ")[1] + " " + dateTime.split(" ")[2];
			
			// 시간 입력
			for(WebElement webElement : allTime) {
				if(webElement.getText().equalsIgnoreCase(dateTime)) {
					webElement.click();
				}
			}
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
