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
public class MyDbFirstController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/mydbfirst", method = RequestMethod.GET)
	public String dbfg(Model model) {

		//検索処理
		List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM firsttable");

		//検索結果のリストをmodelに格納
		model.addAttribute("kensakukekka", kensakukekka);

		return "mydbfirst";
	}

	//練習問題用
	@RequestMapping(path = "/mydbfirstpra", method = RequestMethod.GET)
	public String dbfgpra(Model model, String mozi) {
		List<Map<String, Object>> kensakupra = jdbcTemplate.queryForList("SELECT * FROM firstpratable where title=?",
				mozi);
		//検索処理
		model.addAttribute("kensakupra", kensakupra);
		//検索結果のリストをmodelに格納する。

		return "mydbfirst";
	}

}