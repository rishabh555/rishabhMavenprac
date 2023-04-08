package com.rbhprac.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is the generic class for data driver testing
 * @author sandeep
 *
 */
public class FileLib {
/**
* Reading the data from property file
* @param key
* @return value
* @throws IOException
*/
public String getPropertyValue(String key) throws IOException {
FileInputStream fis=new FileInputStream("./src/test/resources/data/commondata.property");
Properties p=new Properties();
p.load(fis);
String value = p.getProperty(key);
return value;
}
/**
* this method is used to read the data from excel file
* @param sheetname
* @param rownum
* @param cellnum
* @return String Cell Value
* @throws IOException
*/
public String getExcelValue(String sheetname,int rownum,int cellnum) throws IOException{
FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
Workbook wb = WorkbookFactory.create(fis);
String value = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
return value;
}
/**
* used to write the data back to excel
* @param sheetname
* @param rownum
* @param cellnum
* @param setvalue
* @throws IOException
*/
public void setExcelValue(String sheetname, int rownum,int cellnum,String setvalue) throws IOException {
FileInputStream fis=new FileInputStream("./data/TestScript.xlsx");
Workbook wb = WorkbookFactory.create(fis);
wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).setCellValue(setvalue);
FileOutputStream fos=new FileOutputStream("./data/TestScript.xlsx");
wb.write(fos);
wb.close();
}
}