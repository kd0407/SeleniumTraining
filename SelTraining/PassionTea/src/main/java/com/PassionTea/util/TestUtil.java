package com.PassionTea.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.PassionTea.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static XSSFWorkbook xlwb;
	public static XSSFSheet xlSheet;
	public static String TESTDATA_SHEETPATH="D:\\SelTraining\\PassionTea\\src\\main\\java\\com\\PassionTea\\testdata\\Checkout.xlsx";
	
	public void switchToFrame() {
		//driver.switchTo().frame("mainpanel");Since application doesn't have one...I can add it here.
		//where ever you(class) need this method,import it and create and an object in setup() ,after initialiazation()
	}
	
	public static Object[][] getTestData(String sheetName) {
		Object[][] dataTable = null;
		File file = new File(TESTDATA_SHEETPATH);
		try {
			// Create a file input stream to read Excel workbook and worksheet
			FileInputStream xlfile = new FileInputStream(file);
			 xlwb = new  XSSFWorkbook(xlfile);
			 xlSheet = xlwb.getSheet(sheetName);

			// Get the number of rows and columns
			int numRows = xlSheet.getLastRowNum();
			int numCols = xlSheet.getRow(0).getLastCellNum();

			// Create double array data table - rows x columns
			// We will return this data table
			dataTable = new Object[numRows][numCols];

			// For each row, create a XSSFRow, then iterate through the "columns"
			// For each "column" create an XSSFCell to grab the value at the specified cell (i,j)
			for (int i = 0; i < numRows; i++) {
				//XSSFRow xlRow = xlSheet.(i+1);
				for (int j = 0; j < numCols; j++) {
					//XSSFCell xlCell = xlRow.getCell(j);
					dataTable[i][j] = xlSheet.getRow(i+1).getCell(j).toString();
				}
			xlwb.close();	
			}
		} catch (IOException e) {
			System.out.println("ERROR FILE HANDLING " + e.toString());
		}
		return dataTable;
	}		
		
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	

}
