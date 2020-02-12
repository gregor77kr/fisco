package com.fisco.scheduler.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fisco.scheduler.common.CalendarLib;
import com.fisco.scheduler.type.WorkTime;
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

		for (int i = 0; i < difference; i++) {
			LocalDate term = start.plusDays(i);
			period.add(term.toString());
		}
		result.put("head", period);

		// body 생성
		JSONArray data = new JSONArray();

		int headCount = Integer.parseInt(param.remove("headCount").toString());
		int nurseCount = Integer.parseInt(param.remove("nurseCount").toString());
		int assistCount = Integer.parseInt(param.remove("assistCount").toString());

		// 수간호사 data 생성
		List<Nurse> headList = createNurse(param, headCount, "head", "H");
		WorkTime[] workTime = WorkTime.values();

		for (int i = 0; i < headCount; i++) {
			JSONArray workData = new JSONArray();
			Nurse head = headList.get(i);
			workData.add(head.getName());

			int index = 0;

			for (int j = 0, length = period.size(); j < length; j++) {
				String date = period.get(j).toString().replace("-", "");

				if (index >= headCount) {
					index = 0;
				}

				if (c.isHoliday(date)) {
					workData.add("주말");
					continue;
				}

				String birthDate = date.substring(4);
				if (head.getBirthDate().equals(birthDate)) {
					workData.add("생일");
					continue;
				}

				workData.add(index == i ? workTime[1].name() : "휴일");
				index++;
			}
			data.add(workData);
		}

		List<Nurse> nurseList = createNurse(param, nurseCount, "nurse", "N");
		// 간호사
		for (int i = 0; i < nurseCount; i++) {
			JSONArray workData = new JSONArray();
			Nurse nurse = nurseList.get(i);
			workData.add(nurse.getName());

			for (int j = 0, length = period.size(); j < length; j++) {
				String date = period.get(j).toString().replace("-", "");

				String birthDate = date.substring(4);
				if (nurse.getBirthDate().equals(birthDate)) {
					workData.add("생일");
					continue;
				}

				String nurseLastWorkTime = nurse.getLastWorkTime();
				String nurseWorkTime = (nurseLastWorkTime.isEmpty()) ? workTime[i % 3].name() : nurseLastWorkTime;

				// switching on monday
				if (c.getDay(date) == 1 && !nurseLastWorkTime.isEmpty()) {
					nurseWorkTime = workTime[(WorkTime.valueOf(nurseLastWorkTime).ordinal() + 1) % 3].name();
				}

				workData.add(nurseWorkTime);
				nurse.setLastWorkTime(nurseWorkTime);
			}
			data.add(workData);
		}

		result.put("body", data);
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
