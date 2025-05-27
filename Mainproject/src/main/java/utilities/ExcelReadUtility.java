package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelReadUtility {
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	public static String readStringData(int row,int column,String sheet) throws IOException
	{
	f=new FileInputStream(Constants.LOGIN_EXCELFILE);
	w=new XSSFWorkbook(f);
	sh=w.getSheet(sheet);
	XSSFRow r=sh.getRow(row);
	XSSFCell c=r.getCell(column);
	return c.getStringCellValue();
	}
	public static String readIntegerData(int row,int column,String sheet) throws IOException
	{
		f=new FileInputStream(Constants.LOGIN_EXCELFILE);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheet);
		XSSFRow r=sh.getRow(row);
		XSSFCell c=r.getCell(column);	
		int val=(int) c.getNumericCellValue();
		return String.valueOf(val);
		
		
	}


}
