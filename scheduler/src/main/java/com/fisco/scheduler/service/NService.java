package com.fisco.scheduler.service;

import java.util.Map;

import javax.inject.Inject;

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

	public Map<String, Object> createScheduler(Map<String, Object> param) throws Exception {
		logger.info(param.toString());

		int headCount = Integer.parseInt(param.remove("headCount").toString());
		int nurseCount = Integer.parseInt(param.remove("nurseCount").toString());
		int assistCount = Integer.parseInt(param.remove("assistCount").toString());

		String startDate = param.remove("startDate").toString();
		String endDate = param.remove("endDate").toString();

		Nurse[] headArray = createNurse(param, headCount, "head", "H");
		Nurse[] nurseArray = createNurse(param, nurseCount, "nurse", "N");
		Nurse[] assistArray = createNurse(param, assistCount, "assist", "A");

		int difference = c.getDifference(startDate, endDate) + 1;
		

		return null;
	}

	public Nurse[] createNurse(Map<String, Object> param, int length, String id, String type) {
		Nurse[] nurseArray = new Nurse[length];

		for (int i = 0; i < length; i++) {
			String name = id + i;
			nurseArray[i] = new Nurse().setName(name).setBirthDate(param.get(name).toString()).setType(type);
		}
		return nurseArray;
	}

	public void print(Nurse[] nurse) {
		for (int i = 0; i < nurse.length; i++) {
			logger.info(nurse[i].toString());
		}
	}
}
