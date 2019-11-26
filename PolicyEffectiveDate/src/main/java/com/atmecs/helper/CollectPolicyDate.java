package com.atmecs.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CollectPolicyDate {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calender;
	int newValue;

	public String getPolicyDateForDays(String value) {
		newValue = Integer.parseInt(value);
		calender = Calendar.getInstance();
		calender.add(Calendar.DATE, newValue);
		String date = dateFormat.format(calender.getTime());

		return "Days:" + date;

	}

	public String getPolicyDateMonthAfter(String value) {
		newValue = Integer.parseInt(value);
		calender = Calendar.getInstance();
		calender.add(Calendar.MONTH, newValue);
		String date = dateFormat.format(calender.getTime());

		return "MonthAfter:" + date;
	}

	public String getPolicyDateMonthEarlier(String value) {
		newValue = Integer.parseInt(value);
		calender = Calendar.getInstance();
		calender.add(Calendar.MONTH, -(newValue));
		String date = dateFormat.format(calender.getTime());

		return "MonthEarlier:" + date;
	}
}
