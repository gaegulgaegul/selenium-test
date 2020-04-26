package selenium.testmanager.ch12;

import java.io.IOException;

public class PG2 {

	public static void main(String[] args) throws IOException {
		
		// Excel 파일에 채울 것으로 예상되는 순서와 동일한 순서로 데이터로 배열을 만든다.
		String[] valueToWrite = {"Mr. E", "Noida"};
		
		WriteGuru99ExcelFile objExcelFile = new WriteGuru99ExcelFile();
		
		objExcelFile.writeExcel(System.getProperty("user.dir")+"\\src\\excelExportAndFileIO", "ExportExcel.xlsx", "ExcelGuru99Demo", valueToWrite);
	}

}
