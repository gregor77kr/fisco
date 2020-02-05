package com.fisco.scheduler.common;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

@Component
public class CalendarLib {

	public LocalDate generateDate(String date) {
		return LocalDate.of(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)),
				Integer.parseInt(date.substring(6)));
	}

	public Period getPeriod(String startDate, String endDate) {
		LocalDate start = generateDate(startDate);
		LocalDate end = generateDate(endDate);

		return Period.between(start, end);
	}

	public int getDifference(String startDate, String endDate) {
		return getPeriod(startDate, endDate).getDays();
	}

	public int countHoliday(String startDate, String endDate) {
		int difference = getDifference(startDate, endDate);
		int result = 0;

		LocalDate start = generateDate(startDate);

		for (int i = 0; i <= difference; i++) {
			result = isHoliday(start.plusDays(i)) ? result + 1 : result;
		}

		return result;
	}

	public boolean isHoliday(LocalDate date) {
		int dayofWeek = date.getDayOfWeek().getValue();
		return (dayofWeek == 6 || dayofWeek == 7) ? true : false;
	}

	public boolean isHoliday(String date) {
		return isHoliday(generateDate(date));
	}

	/**
	 * Returns int value for a day of week
	 * 
	 * @param date String of 'yyyymmdd' format
	 * @return from 1 (Monday) to 7 (Sunday)
	 */
	public int getDay(String date) {
		return generateDate(date).getDayOfWeek().getValue();
	}
}
