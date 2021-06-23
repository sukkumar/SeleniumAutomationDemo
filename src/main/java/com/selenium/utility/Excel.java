package com.selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static String excelPathLoc;
	public  XSSFWorkbook wb;
    public  XSSFSheet sheet;
    public  FileInputStream fis;
    public  FileOutputStream fout;
   
    
    public Excel(String excelPath)
    {
    	excelPathLoc = excelPath;
            try {
                 fis = new FileInputStream(excelPathLoc);
                  wb = new XSSFWorkbook(fis);             
            } 
            catch (Exception e) {
                System.out.println(e.getMessage()); 
            }                   
        }   
    public String readData (String sheetName,int row, int column )
    {
        sheet = wb.getSheet(sheetName);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;            
    }
	
    public ArrayList<String> readData(String sheetName) {
    	ArrayList<String> products = new ArrayList<String>();
    	sheet = wb.getSheet(sheetName);
    	for(int i=1;i<=sheet.getLastRowNum();i++) {
    		products.add(sheet.getRow(i).getCell(0).getStringCellValue());
    	}
		return products;      
    }
   
}

