package Utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Commons {
	
	public WebDriver driver;
	
	public Commons(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public boolean isPriceSortedAscending()
	{
		List<WebElement> all_prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		double prices[] = new double[all_prices.size()];
		for(int i=0; i<all_prices.size(); i++)
		{
			prices[i] = Double.parseDouble(all_prices.get(i).getText().replace("$", "").trim());
		}
		for(int i=0; i<prices.length-1; i++)
		{
			if(prices[i] > prices[i+1])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isPriceSortedDescending()
	{
		List<WebElement> all_prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		double prices[] = new double[all_prices.size()];
		for(int i=0; i<all_prices.size(); i++)
		{
			prices[i] = Double.parseDouble(all_prices.get(i).getText().replace("$", "").trim());
		}
		for(int i=0; i<prices.length-1; i++)
		{
			if(prices[i] < prices[i+1])
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isNameSortedAscending()
	{
		List<WebElement> all_names = driver.findElements(By.xpath("//div[@class='inventory_item_label']/a"));
		String names[] = new String[all_names.size()];
		for(int i=0; i<names.length; i++)
		{
			names[i] = all_names.get(i).getText();
		}
		for(int i=0; i<names.length-1; i++)
		{
			if(names[i].compareTo(names[i+1]) > 0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isNameSortedDescending()
	{
		List<WebElement> all_names = driver.findElements(By.xpath("//div[@class='inventory_item_label']/a"));
		String names[] = new String[all_names.size()];
			for(int i=0; i<names.length; i++)
			{
				names[i] = all_names.get(i).getText();
			}
			for(int i=0; i<names.length-1; i++)
			{
				if(names[i].compareTo(names[i+1]) < 0)
				{
					return false;
				}
			}
		
		return true;
	}
	
	public List<HashMap<String, String>> getExcelData(String filepath, String sheetname) throws IOException
	{
		List<HashMap<String,String>> mylist = new ArrayList<>();
		FileInputStream fi = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int total_rows = sheet.getLastRowNum();
		XSSFRow header_row = sheet.getRow(0);
		for(int i=1; i<=total_rows; i++)
		{
			XSSFRow current_row = sheet.getRow(i);
			HashMap<String, String> currenthash = new HashMap<>();
			for(int j=0; j<current_row.getLastCellNum(); j++)
			{
				XSSFCell current_cell = current_row.getCell(j);
				currenthash.put(header_row.getCell(j).toString(), current_cell.toString());
			}
			mylist.add(currenthash);
		}
		workbook.close();
		return mylist;
	}

	

}
