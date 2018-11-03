package com.automation.qa.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automation.qa.base.BassClass;

public class TestUtil extends BassClass {

	public static String TESTDATA_SHEET_PATH = "D:\\Eclipse\\eclipseProjects\\automationdemosite\\src\\main\\java\\com\\automation\\qa\\testdata\\DemoSite.xlsx";
	static Workbook book;
	static Sheet sheet;

	public static void scrollDown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		js.executeScript("arguments[0].scrollIntoView();", e);
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;

		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		sheet = book.getSheet("user");
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

}
