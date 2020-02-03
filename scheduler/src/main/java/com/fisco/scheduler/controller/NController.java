package com.fisco.scheduler.controller;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fisco.scheduler.service.NService;

@Controller
public class NController {
	private static final Logger logger = LoggerFactory.getLogger(NController.class);

	@Inject
	NService nService;

	@RequestMapping(value = "/N1", method = RequestMethod.GET)
	public String N1() {
		return "N1";
	}

	@RequestMapping(value = "/N2", method = RequestMethod.GET)
	public ModelAndView N2(@RequestParam Map<String, Object> param, ModelAndView model) {
		logger.info(param.toString());

		model.setViewName("N2");
		model.addAllObjects(param);
		return model;
	}

	@RequestMapping(value = "/N3", method = RequestMethod.GET)
	public ModelAndView N3(@RequestParam Map<String, Object> param, ModelAndView model) throws Exception {

		model.setViewName("N3");
		model.addAllObjects(nService.createScheduler(param));
		return model;
	}
}
