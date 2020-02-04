package com.fisco.scheduler.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NService {
	private static final Logger logger = LoggerFactory.getLogger(NService.class);

	public Map<String, Object> createScheduler(Map<String, Object> param) throws Exception {
		/*
		 * { headCount = 2, nurseCount = 3, assistCount = 4, startDate = 20200201, endDate = 20200228,
		 *   head0 = 0413, head1 = 0701, nurse0 = 0820, nurse1 = 0918,
		 *   nurse2 = 0824, assist0 = 0306, assist1 = 0213, assist2 = 0502, assist3 = 1204
		 * }
		 */
		logger.info(param.toString());
		
		
		return null;
	}
}
