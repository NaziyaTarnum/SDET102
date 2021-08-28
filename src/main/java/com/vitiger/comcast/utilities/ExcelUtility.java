package com.vitiger.comcast.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * its developed
 * 
 * @author Naziya
 *
 */

public class ExcelUtility {
	
	public String getDataFromExcel(String SheetName,int rowNum,int celnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celnum).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	
	public int getDataFromExcelCount(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		wb.close();
	return sh.getLastRowNum();
	}
	
	
	
	public String setDataFromExcel(String SheetName,int rowNum,int celnum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
	Cell cel=row.createCell(celnum);
	cel.setCellValue(data);
FileOutputStream fos=new FileOutputStream("./data/Book1.xlsx");
wb.write(fos);
wb.close();
return data;
	
	
	}


	
	
	
	
	

}
