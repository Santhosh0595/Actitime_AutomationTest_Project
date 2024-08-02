package com.actitime.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

public String getPropertyData(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./data/testdata.properties");
	Properties data=new Properties();
	data.load(fis);
	String testdata = data.getProperty(key);
	return testdata;
}
public String getExcelData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./data/ActitimeProject1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data = wb.getSheet("newcustomer").getRow(row).getCell(cell).getStringCellValue();	
	return data;
	
}
public String getExcelDataScript2(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream project=new FileInputStream("./data/AutomationProject2.xlsx");
	Workbook wb = WorkbookFactory.create(project);
	String data = wb.getSheet("CreateCustomer").getRow(row).getCell(cell).getStringCellValue();	
	return data;
	
}
public String getExcelDataScript3(String sheet,int row,int cell) throws IOException{
	FileInputStream task=new FileInputStream("./data/AutomationProject3.xlsx");
	Workbook wb = WorkbookFactory.create(task);
	String data = wb.getSheet("CreateTask").getRow(row).getCell(cell).getStringCellValue();
	return data;
	
}


}
