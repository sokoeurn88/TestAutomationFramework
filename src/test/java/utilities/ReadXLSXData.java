package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSXData {

	@DataProvider(name="testdata")
	public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException {
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata2.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int totalRow = sheetName.getLastRowNum();
		Row rowCell = sheetName.getRow(0);
		int totalCols = rowCell.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRow][totalCols];
		
		for(int i=1;i<=totalRow;i++) {
			for(int j= 0;j<=totalCols;j++) {
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		
		return testData;
	}

}
