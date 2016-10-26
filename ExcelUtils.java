package utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils {

	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;

	// This method is to set the File path and to open the Excel file
	// Pass Excel Path and SheetName as Arguments to this method
	public static void setExcelFile(final String Path, final String SheetName) throws Exception {
		
		final File src = new File(Path);
		final FileInputStream ExcelFile = new FileInputStream(src);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}

	// This method is to read the test data from the Excel cell
	// In this we are passing parameters/arguments as Row Num and Col Num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		String CellData = null;
		if (ExcelWSheet.getRow(RowNum).getCell(ColNum) !=null) {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			CellData = Cell.getStringCellValue();
			//System.out.println(CellData);
		}
		
		return CellData;
	}
	


}

	