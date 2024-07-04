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
public class DomeController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/dome1", method = RequestMethod.GET)
	public String domea(Model model) {
		return "dome";
	}

	@RequestMapping(path = "/Insdda", method = RequestMethod.POST)
	public String domeb(Model model, String coat, String name, String clas, String bi) {

		// データ更新
		List<Map<String, Object>> kensakukekka = jdbcTemplate
				.queryForList("SELECT * FROM domeyoyaku WHERE  yoyakubi= ? and yoyakucoat=?", bi, coat);
		if ((kensakukekka.size() == 0)) {
			jdbcTemplate.update("INSERT INTO domeyoyaku  VALUES (?,?,?,?);", bi, clas, name, coat);
		} else {
			model.addAttribute("out", "out");
		}
		List<Map<String, Object>> kensakukekka2 = jdbcTemplate.queryForList("SELECT* FROM domeyoyaku ");
		model.addAttribute("kensaku", kensakukekka2);
		return "dome";
	}

	@RequestMapping(path = "/henkou1", method = RequestMethod.POST)
	public String dome3(Model model, String name, String bi, String bi2) {

		jdbcTemplate.update("UPDATE domeyoyaku SET yoyakubi = ?  WHERE yoyakubi=?  and yoyakuname= ?;", bi, bi2, name);
		List<Map<String, Object>> kensakukekka2 = jdbcTemplate.queryForList("SELECT* FROM domeyoyaku ");
		model.addAttribute("kensaku", kensakukekka2);
		return "dome";
	}

	@RequestMapping(path = "/del", method = RequestMethod.POST)
	public String dbdome4(Model model, String name, String bi) {

		// データ更新
		jdbcTemplate.update("DELETE FROM domeyoyaku WHERE yoyakubi = ? and yoyakuname= ?;", bi, name);
		List<Map<String, Object>> kensakukekka2 = jdbcTemplate.queryForList("SELECT* FROM domeyoyaku ");
		model.addAttribute("kensaku", kensakukekka2);
		return "dome";
	}

}
