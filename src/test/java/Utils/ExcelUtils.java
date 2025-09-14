package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	/*public static Object[][] getExcelData(String filepath, String sheetname) throws IOException
	{
		Object[][] data = null;
		FileInputStream fi = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int total_rows = sheet.getLastRowNum();
		int total_columns = sheet.getRow(0).getLastCellNum();
		data = new Object[total_rows-1][total_columns];
		for(int i=1; i<total_rows; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<total_columns; j++)
			{
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.toString();
			}
		}
		workbook.close();
		fi.close();
		return data;
	}*/
	
	
}
