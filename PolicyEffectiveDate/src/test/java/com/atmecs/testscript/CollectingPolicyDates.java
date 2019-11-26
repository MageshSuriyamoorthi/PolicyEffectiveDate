package com.atmecs.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.helper.Classpaths;
import com.atmecs.helper.CollectPolicyDate;
import com.atmecs.helper.ExcelReader;
import com.atmecs.helper.ExcelWriter;

public class CollectingPolicyDates {

	private CollectPolicyDate dates = new CollectPolicyDate();
	private ExcelReader reader = new ExcelReader();
	private ExcelWriter writer = new ExcelWriter();
	String Data = "EffectiveDate:Date";

	@BeforeTest
	public void collectingDatesIntoExcel() {
		List<String> list = new ArrayList<String>();

		list.add(Data);
		Data = dates.getPolicyDateForDays(reader.getdata(Classpaths.filePath, "PolicySheetCondition", "Data", "Days"));
		list.add(Data);
		Data = dates.getPolicyDateMonthAfter(reader.getdata(Classpaths.filePath, "PolicySheetCondition", "Data", "MonthAfter"));
		list.add(Data);
		Data = dates.getPolicyDateMonthEarlier(reader.getdata(Classpaths.filePath, "PolicySheetCondition", "Data", "MonthEarlier"));
		list.add(Data);

		writer.writeIntoExcel(Classpaths.filePath, list);

	}

	@Test
	public void gettingDatesFromExcel() throws Exception {
		String PDfor10days = reader.getdata(Classpaths.filePath, "PolicySheets", "Date", "TenDays");
		String PDforBeforeOneMonth = reader.getdata(Classpaths.filePath, "PolicySheets", "Date", "MonthAfter");
		String PDforAfterOneMonth = reader.getdata(Classpaths.filePath, "PolicySheets", "Date", "MonthEarlier");

		System.out.println("policy effective date should be 1 month later than the current date is "
				+ PDforAfterOneMonth + "\r\n"
				+ "policy effective date should be exactly 10 days from the current date is " + PDfor10days + "\r\n"
				+ "policy effective date should be 1-month earlier than the current date is " + PDforBeforeOneMonth);

	}

}
