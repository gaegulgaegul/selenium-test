package selenium.testmanager.ch14;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// 키워드 기반 테스트 프레임워크
public class ExecuteTest {
	
	@Test
	public void testLogin() throws Exception {
		WebDriver webdriver = new ChromeDriver();
		ReadGuru99ExcelFile file = new ReadGuru99ExcelFile();
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		UIOperation operation = new UIOperation(webdriver);
		
		// 키워드 시트 읽기
		Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\", "TestCase.xlsx", "KeywordFramwork");
		
		// Excel 파일에서 행 수 찾기
		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
		// 엑셀 파일의 모든 행에 루프를 작성하여 읽는다.
		for(int i=1; i<rowCount; i++) {
			
			// 모든 행을 반복
			Row row = guru99Sheet.getRow(i);
			
			// 첫번째 셀에 값이 들어 있는지 확인.('예'면 새 테스트 사례 이름)
			if(row.getCell(0).toString().length()==0) {
				
				// 콘솔에 테스트 케이스 정보를 출력
				System.out.println(row.getCell(1).toString()+"----"+row.getCell(2).toString()+"----"+row.getCell(3).toString()+"----"+row.getCell(4).toString());
				
				// UI에서 작업을 수행하기 위해 함수 호출 수행
				operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString());
			} else {
				// 시작할 때 새로운 테스트 케이스 이름을 출력
				System.out.println("New TestCase -> " + row.getCell(0).toString() + " Started");
			}
		}
	}
	
}
