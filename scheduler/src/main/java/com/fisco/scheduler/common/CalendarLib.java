package com.fisco.scheduler.common;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class CalendarLib {

	public Calendar setDate(String date) {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)),
				Integer.parseInt(date.substring(6)));
		return c;
	}

	public int getDifference(String startDate, String endDate) {
		Calendar start = setDate(startDate);
		Calendar end = setDate(endDate);

		return (int) ((end.getTimeInMillis() - start.getTimeInMillis()) / (1000 * 60 * 60 * 24));
	}
}
