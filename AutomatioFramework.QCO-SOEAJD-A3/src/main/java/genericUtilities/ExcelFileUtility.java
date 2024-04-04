package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Raghunath
 * 
 */
public class ExcelFileUtility {
	

	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws IOException 
	
	/**
	 * This method will read data from excel and return the value to caller
	 * @param SheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws encyptedDocumentException
	 * Throws IOException
	 */
	
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter format=new DataFormatter();
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		String value = format.formatCellValue(cell);
		return value;
		
		
		
	}
			

}
