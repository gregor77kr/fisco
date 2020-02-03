package com.fisco.scheduler.common;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

@Component
public class CalendarLib {

	public LocalDate setDate(String date) {

		return LocalDate.of(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)),
				Integer.parseInt(date.substring(6)));
	}

	public int getDifference(String startDate, String endDate) {
		LocalDate start = setDate(startDate);
		LocalDate end = setDate(endDate);

		return Period.between(start, end).getDays();
	}
}
