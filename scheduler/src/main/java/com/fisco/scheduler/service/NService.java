package com.fisco.scheduler.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fisco.scheduler.common.CalendarLib;
import com.fisco.scheduler.vo.Nurse;

@Service
public class NService {
	private static final Logger logger = LoggerFactory.getLogger(NService.class);

	@Inject
	CalendarLib c;

	@SuppressWarnings("unchecked")
	public Map<String, Object> createScheduler(Map<String, Object> param) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		String startDate = param.remove("startDate").toString();
		String endDate = param.remove("endDate").toString();

		int difference = c.getDifference(startDate, endDate) + 1;

		// head 생성
		LocalDate start = c.generateDate(startDate);
		JSONArray period = new JSONArray();

		for (int i = 0; i <= difference; i++) {
			LocalDate term = start.plusDays(i);
			period.add(term.toString());
		}
		logger.info(period.toString());
		result.put("head", period);

		// body 생성
		List<Map<String, Object>> data = new LinkedList<Map<String, Object>>();
		int headCount = Integer.parseInt(param.remove("headCount").toString());
		int nurseCount = Integer.parseInt(param.remove("nurseCount").toString());
		int assistCount = Integer.parseInt(param.remove("assistCount").toString());

		return result;
	}

	public List<Nurse> createNurse(Map<String, Object> param, int length, String id, String type) {
		List<Nurse> nurseList = new ArrayList<Nurse>();

		for (int i = 0; i < length; i++) {
			String name = id + i;
			nurseList.add(new Nurse().setName(name).setBirthDate(param.get(name).toString()).setType(type));
		}
		return nurseList;
	}
}
