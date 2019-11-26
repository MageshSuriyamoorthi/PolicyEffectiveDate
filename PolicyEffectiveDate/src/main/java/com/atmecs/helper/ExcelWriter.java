package com.atmecs.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	Cell ColOne, ColTwo;
	Row row;
	Sheet sheet;
	File file;
	FileInputStream FileIS = null;
	Workbook book = null;

	private void loadFile(String pathfile) {
		try {
			file = new File(pathfile);
			FileIS = new FileInputStream(file);
			book = new XSSFWorkbook(FileIS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = book.getSheet("PolicySheets");
		if (sheet != null) {
			int index = book.getSheetIndex(sheet);
			book.removeSheetAt(index);
			sheet = book.createSheet("PolicySheets");
		} else {
			sheet = book.createSheet("PolicySheets");
		}
	}

	public void writeIntoExcel(String file, List<String> list) {
		loadFile(file);
		for (int totalList = 0; totalList < list.size(); totalList++) {
			String Date = list.get(totalList);
			String[] NewDate = Date.split(":");

			row = sheet.createRow(totalList);

			ColOne = row.createCell(0);
			ColOne.setCellValue(NewDate[0]);
			sheet.autoSizeColumn(0);

			ColTwo = row.createCell(1);
			ColTwo.setCellValue(NewDate[1]);
			sheet.autoSizeColumn(1);
		}

		try {
			book.write(new FileOutputStream(file));
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
