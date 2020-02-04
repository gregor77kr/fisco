package com.fisco.scheduler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fisco.scheduler.common.CalendarLib;

public class CalendarLibTest {

	@Test
	public void test() {
		CalendarLib c = new CalendarLib();

		String startDate = "20200202";
		String endDate = "20200209";

		assertEquals(8, c.getDifference(startDate, endDate) + 1);
		assertEquals(3, c.countHoliday(startDate, endDate));

	}

}
