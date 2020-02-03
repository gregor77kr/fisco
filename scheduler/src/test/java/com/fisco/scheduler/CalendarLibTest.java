package com.fisco.scheduler;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fisco.scheduler.common.CalendarLib;

public class CalendarLibTest {

	@Test
	public void test() {
		CalendarLib c = new CalendarLib();
		
		System.out.println(c.getDifference("20200203", "20200209"));
	}

}
