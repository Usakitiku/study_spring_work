package com.example.demo.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
	public class monsutohyouka {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(path = "/monsuto", method = RequestMethod.GET)
	public String monsutohyouka() {
		
		return "monsuto";
	}
	
	@RequestMapping(path = "/monsuto1", method = RequestMethod.POST)
	public String monsutohyouka2(Model model,String kensaku) {
		List<Map<String,Object>> kensakukekka;
		kensakukekka	= jdbcTemplate.queryForList("SELECT * FROM hyouka;");
		model.addAttribute("kensakupra",kensakukekka);	
		return "monsuto";
	}

}
