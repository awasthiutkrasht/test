package com.actitime.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelib 
{
	
	public String getPopKeyvalue(String path, String key) throws Throwable 
	{
		
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties ();
		prop.load(fis);
		String PropValue = prop.getProperty(key , "Incorrect Value");
		return PropValue;
	}
	public String getCellData(String excelPath,int cell,int row,String Sheet) throws Throwable
	{
	  
		FileInputStream fis = new FileInputStream(excelPath);
		  Workbook wb = WorkbookFactory.create(fis);
		
		String CellValue = wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
		return CellValue;
	}
    
	public int getRowCount(String excelPath,String Sheet) throws Throwable {
		FileInputStream fis = new FileInputStream(excelPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  
		  int rc = wb.getSheet(Sheet).getLastRowNum();
		  return rc;
		  
	}
	public void setCellData(String excelPath,String SheetName, int row,int cell,String data) throws Throwable {
		FileInputStream fis = new FileInputStream(excelPath);
		  Workbook wb = WorkbookFactory.create(fis);
		  wb.getSheet(SheetName).getRow(row).getCell(cell).setCellValue(data);
		  
			FileOutputStream fos =new FileOutputStream(excelPath);
			wb.write(fos);
	System.out.println("Written successfully");
		  
	}
	
}
