package selenium.testmanager.ch9;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.testmanager.consts.global;

// 동적 테이블의 열에 있는 모든 값의 최대값 얻기
public class PG3 {

	public static void main(String[] args) {
		
		System.setProperty(global.WEB_DRIVER_ID, global.WEB_DRIVER_PATH);
		WebDriver driver = null;
		
		String max;
		double m = 0;
		double r = 0;
		
		try {
			
			driver = new ChromeDriver();
			driver.get(global.EX_DYNAMIC_TABLE1);
			
			List<WebElement> col = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/td"));
			System.out.println("Total No of columns are : " + col.size());
			
			List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
			System.out.println("Total No of rows are : " + rows.size());
			
			for(int i=1; i<rows.size(); i++) {
				max = driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + (i+1) + "]/td[4]")).getText();
				NumberFormat f = NumberFormat.getNumberInstance();
				Number num = f.parse(max);
				max = num.toString();
				m = Double.parseDouble(max);
				if(m>r) {
					r = m;
				}
			}
			System.out.println("Maximum current price is " + r);
			
			Thread.sleep(3000);
			
		} catch (InterruptedException | ParseException e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
		
	}

}
