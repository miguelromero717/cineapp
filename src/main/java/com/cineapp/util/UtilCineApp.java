package com.cineapp.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class UtilCineApp {
	
	public static List<String> generateFechas(int count){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		List<String> dates = new ArrayList<>();
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date end = cal.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		
		while (!gcal.getTime().after(end)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			dates.add(formatter.format(d));
		}
		
		return dates;
	}

}
