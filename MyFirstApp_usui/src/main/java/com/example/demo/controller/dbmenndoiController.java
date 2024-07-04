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
public class dbmenndoiController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@RequestMapping(path = "/dbmenndoi", method = RequestMethod.GET)
	public String dbsg1(Model model ) {
		return "dbmendo";
	}
	@RequestMapping(path = "/dbmenndoi", method = RequestMethod.POST)
	public String dbsg1(Model model ,String aa ,String bb) {
		//検索処理(secondtable用)
			
		List<Map<String,Object>> kensakukekkaSecond;
				kensakukekkaSecond = jdbcTemplate.queryForList("SELECT * FROM secondsoutable WHERE gaiyo=? or setumei=?",aa,bb);
				model.addAttribute("kensakupraSecond",kensakukekkaSecond);	
		
				return "dbmendo";
				
	}
	@RequestMapping(path = "/dbmenndoi2", method = RequestMethod.POST)
	public String dbsg2(Model model ,String cc,String dd) {
		jdbcTemplate.update("INSERT INTO secondsoutable (gaiyo,setumei) VALUES (?,?);",cc,dd);
		
		return "dbmendo";}
	
	}
