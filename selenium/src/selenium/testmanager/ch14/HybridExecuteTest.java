package selenium.testmanager.ch14;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 하이브리드 기반 프레임워크
public class HybridExecuteTest {
	
	WebDriver driver = null;
	
//	@Test(dataProvider="hybridData")
	public void testLogin(String testcaseName, String keyword, String  objectName, String objectType, String value) throws Exception {
		if(testcaseName != null && testcaseName.length() != 0) {
			driver = new ChromeDriver();
		}
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(driver);
		
		// UI에서 작업을 수행하기 위해 함수 호출 수행
		operation.perform(allObjects, keyword, objectName, objectType, value);
	}
	
//	@DataProvider(name="hybridData")
	public Object[][] getDataFormDataprovider() throws IOException {
		Object[][] object = null;
		ReadGuru99ExcelFile file = new ReadGuru99ExcelFile();
		
		// 키워드 시트 읽기
		Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\", "TestCase.xlsx", "KeywordFramework");
		
		// Excel 파일에서 행 수 찾기
		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
		object = new Object[rowCount][5];
		for(int i=0; i<rowCount; i++) {
			Row row = guru99Sheet.getRow(i+1);
			for(int j=0; j<row.getLastCellNum(); j++) {
				object[i][j] = row.getCell(j).toString();
			}
		}
		System.out.println("");
		return object;
	}
	
}
