package com.atmecs.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class NewCalendar {
	public static void main(String[] args) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.MONTH, -1);
		System.out.println(dateFormat.format(c.getTime()));
		System.out.println(dateFormat.format(c1.getTime()));
		
		DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime l = LocalDateTime.now();
		System.out.println(dateFormater.format(l));

		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];

		System.out.println("Month name: " + month);
		
		Calendar calendar = Calendar.getInstance();
		String dayName = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		System.out.println("MonthName = " + dayName);
		
		DateFormat dateFormat1 = new SimpleDateFormat("dd MMMM yyyy");
		
		System.out.println(dateFormat1.format(c.getTime()));

	}
}
//(//div[@data-date='26' and @data-month='10' and @data-year='2019']) [8]