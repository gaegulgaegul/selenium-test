package selenium.testmanager.ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteGuru99ExcelFile {
	
	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite) throws IOException {
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
		Sheet sheet = guru99Workbook.getSheet(sheetName);
		
		// Excel에서 행 수 찾기
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		// 시트에서 첫번째 행 가져오기
		Row row = sheet.getRow(0);
		
		// 새 행을 만들고 마지막 행에 추가
		Row newRow = sheet.createRow(rowCount+1);
		
		// 새로 생성된 Row의 셀 위에 루프를 만든다.
		for(int i=0; i<rowCount+1; i++) {
			// 행으로 데이터 채우기
			Cell cell = newRow.createCell(i);
			cell.setCellValue(dataToWrite[i]);
		}
		
		// 입력 스트림을 닫는다.
		inputStream.close();
		
		// FileOutputStream 클래스의 객체를 생성하여 Excel 데이터에 쓰기 데이터를 만든다.
		FileOutputStream outputStream = new FileOutputStream(file);
		
		// 엑셀 파일에 데이터 쓰기
		guru99Workbook.write(outputStream);
		
		// 출력 스트림을 닫는다.
		outputStream.close();
		
	}
	
}
