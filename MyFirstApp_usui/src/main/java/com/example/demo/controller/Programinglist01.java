package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Programinglist01 {
	String[][] kousinrireki = {
			{ "隠しコマンド追加", "ver.1.2" },{ "検索結果詳細追加", "ver.1.1" } ,
			{ "β版サービス開始", "ver.1.0" } ,{ "全検索機能追加", "ver.0.9" },
			{ "追加機能追加", "ver.0.8" },{ "検索機能追加", "ver.0.5" } };
	String[][] kensakurireki = new String[10][2];

	@Autowired
	JdbcTemplate jdbcTemplate;

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/yougo", method = RequestMethod.GET)
	public String dbpr(HttpSession session) {
		session.setAttribute("tc", "n");
session.setAttribute("kousinrireki",kousinrireki );
		return "programinglist";
	}

	//用語検索
	@RequestMapping(path = "/yougo", method = RequestMethod.POST)
	public String dbprken(Model model, HttpSession session, String prog, String code, String id) {

		List<Map<String, Object>> kensakukekka;

		if (id != "" && id != null) {

			kensakukekka = jdbcTemplate.queryForList(
					"SELECT * FROM programmingdb where id=?", id);
			model.addAttribute("kensuu", kensakukekka.size());
			model.addAttribute("kensakupra", kensakukekka);
			model.addAttribute("kensakuh", "ok");
			return "programinglist";
		}
		if ((prog != "" && code == "") || (prog == "" && code != "") || (prog != "" && code != "")) {
			if( prog.equals("しね")||prog.equals("死ね")||prog.equals("シネ") ){
				model.addAttribute("kekkallnot", "おめぇがな");
			}else {
			String prog2 = "%" + prog + "%";
			String code2 = "%" + code + "%";
			kensakukekka = jdbcTemplate.queryForList(
					"SELECT * FROM programmingdb where progname like ? and progtext like ?",
					prog2, code2);
			int kensuu = kensakukekka.size();

			model.addAttribute("kensakuh", "ok");
			model.addAttribute("kensuu", kensuu);
			model.addAttribute("kensakupra", kensakukekka);
			if (kensuu == 0) {
				model.addAttribute("kekkallnot", "一致する情報は見つかりませんでした。");
			}

			//履歴追加
			if (prog == "") {
				prog = "nodata";
			}
			if (code == "") {
				code = "nodata";
			}
			for (int n = 8; n >= 0; n--) {
				if (kensakurireki[n + 1][0] != null || kensakurireki[n][0] != null) {
					kensakurireki[n + 1][0] = kensakurireki[n][0];
					kensakurireki[n + 1][1] = kensakurireki[n][1];
				}

			}

			kensakurireki[0][0] = prog;
			kensakurireki[0][1] = code;
		}
		}
		return "programinglist";
	}

	@RequestMapping(path = "/yougokaihatu", method = RequestMethod.GET)
	public String dbprken(Model model, HttpSession session) {
		if (session.getAttribute("tc") == null) {
			session.setAttribute("tc", "n");
		} else if (session.getAttribute("tc").equals("n")) {
			session.setAttribute("tc", "ex");
		} else {
			session.setAttribute("tc", "n");
		}
		return "programinglist";
	}

	@RequestMapping(path = "/yoyakurireki", method = RequestMethod.GET)
	public String dbprrireki(Model model, HttpSession session) {
		model.addAttribute("kensakurireki", kensakurireki);
		session.setAttribute("tc", "ri");
		return "programinglist";
	}

	@RequestMapping(path = "/yougokaihatu2", method = RequestMethod.GET)
	public String dbprzenken(Model model) {
		List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM programmingdb ");
		model.addAttribute("kensakupra", kensakukekka);
		model.addAttribute("kensakuh", "ok");
		model.addAttribute("kensuu", kensakukekka.size());
		return "programinglist";
	}

	@RequestMapping(path = "/dbprtouroku", method = RequestMethod.GET)
	public String dbprtrget(Model model, String prog, String code, String prtext) {

		return "programingtouroku";
	}

	@RequestMapping(path = "/dbprtouroku", method = RequestMethod.POST)
	public String dbprtrpost(Model model, String prog, String code, String prtext) {
		if (!(code.equals(""))) {
			List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM programmingdb");
			int id = kensakukekka.size();
			String ID = Integer.toString(id + 1);

			//データ登録
			List<Map<String, Object>> kensakukekka2;
			kensakukekka2 = jdbcTemplate.queryForList("SELECT * FROM programmingdb where progname=? and progtext=?",
					prog, code);

			if (kensakukekka2.size() == 0) {
				jdbcTemplate.update("INSERT INTO programmingdb  VALUES (?,?,?,?);", ID, prog, code, prtext);
				model.addAttribute("out", "good");
				List<Map<String, Object>> kensakukekka3;
				kensakukekka3 = jdbcTemplate.queryForList("SELECT * FROM programmingdb where progname=? and progtext=?",
						prog, code);
				model.addAttribute("newcode", kensakukekka3);
				model.addAttribute("ins", "ok");
			} else {
				model.addAttribute("out", "out");
			}
		}

		return "programingtouroku";
	}

}