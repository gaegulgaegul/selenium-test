package selenium.testmanager.ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadGuru99ExcelFile {
	
	public void readExcel (String filePath, String fileName, String sheetName) throws IOException {
		// xlsx 파일을 열려면 File 클래스의 객체를 만든다.
		File file = new File(filePath+"\\"+fileName);
		
		// 엑셀 파일을 읽을 FileInputStream 클래스 객체를 만든다.
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook guru99Workbook = null;
		
		// 하위 문자열에서 파일 이름을 분리하고 확장명만 가져와 파일 확장명을 찾는다.
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		// 파일이 xlsx 파일인지 확인
		if(fileExtensionName.equals(".xlsx")) {
			// xlsx 파일이면 XSSFWorkbook 클래스 반환
			guru99Workbook = new XSSFWorkbook(inputStream);
		} else {
			guru99Workbook = new HSSFWorkbook(inputStream);
		}
		
		// 통합 문서 안의 시트를 읽는다.
		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
		
		// Excel에서 행 수 찾기
		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
		
		// 엑셀 파일의 모든 행에 루프를 작성하여 읽는다.
		for(int i=0; i<rowCount+1; i++) {
			Row row = guru99Sheet.getRow(i);
			
			// 행의 셀 값을 인쇄하는 루프를 만든다.
			for(int j=0; j<row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}
	
}
