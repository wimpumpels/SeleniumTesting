package testData;

import java.io.FileInputStream;
import java.text.DecimalFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtils {
	
	private static HSSFSheet ExcelWSheet;
	
	private static HSSFWorkbook ExcelWBook;
	
	private static HSSFCell Cell;
	
	//private static XSSFRow Row;
	
	/* This method sets file path and open Excel file, pass excel path and sheetname as Argument to this method */
	public static void setExcelFile(String Path, String SheetName) throws Exception
	{
		try
		{
			FileInputStream ExcelFile = new FileInputStream (Path);
			
			ExcelWBook = new HSSFWorkbook (ExcelFile);
			
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e)
		{
			throw (e);
		}
		
	}
	
	/* This method reads test data (in text format) from an Excel cell, pass parameters as Row num and Col num */
	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
		try
		{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			
			String CellData = Cell.getStringCellValue();
			
			return CellData;
		} catch (Exception e)
		{
			return "";
		}
	}
	
	/* This method reads test data (in number format) from an Excel cell while retaining trailing zeros, pass parameters as Row num and Col num */
	public static String getCellDataWithTrailingZeros(int RowNum, int ColNum) throws Exception
	{
		try
		{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			
			DecimalFormat df = new DecimalFormat("0.00");
			double CellData = Cell.getNumericCellValue();
			String CellDataWithTrailingZeros = df.format(CellData);
			
			return CellDataWithTrailingZeros;
		} catch (Exception e)
		{
			return "0.00";
		}
	}
	
}
