package selenium.testmanager.ch12;

import java.io.IOException;

public class PG1 {

	public static void main(String[] args) throws IOException {
		
		ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFile();
		
		String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		
		objExcelFile.readExcel(filePath, "ExportExcel.xlsx", "ExcelGuru99Demo");
		
	}

}
