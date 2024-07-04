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
public class yoyaku2 {
int n=0;
	@Autowired
	JdbcTemplate jdbcTemplate;

	//一覧、登録画面表示用
	@RequestMapping(path = "/sheetreserv", method = RequestMethod.GET)
	public String sheet1(Model model, HttpSession session) {

		//検索処理
		List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM sheetreserve ");
		
		//検索結果のリストをmodelに格納
		model.addAttribute("kensakupra", kensakukekka);
		if (n==0) {
		session.setAttribute("tc","no");
		n++;}
		return "yoyaku2ken";
	}

	@RequestMapping(path = "/sheetpass", method = RequestMethod.POST)
	public String sheet2(HttpSession session, String id, String pass) {

		//検索処理
		List<Map<String, Object>> kensakukekka = jdbcTemplate
				.queryForList("SELECT * FROM sheetuser where userid=? and userpass=?", id, pass);
		if (kensakukekka.size() != 0) {
			//検索結果のリストをmodelに格納
			session.setAttribute("name",id);
			session.setAttribute("tc", "ok");
		}
		return "yoyaku2ken";
	}

	@RequestMapping(path = "/sheetSer", method = RequestMethod.POST)
	public String sheet1(Model model, String mei) {
		if (mei != "") {
			mei = "%" + mei + "%";

			//検索処理
			List<Map<String, Object>> kensakukekka = jdbcTemplate
					.queryForList("SELECT * FROM sheetreserve where yoyakuname like ?", mei);

			//検索結果のリストをmodelに格納
			model.addAttribute("kensakupra", kensakukekka);
		}

		return "yoyaku2ken";
	}

	//編集、削除画面表示用
	@RequestMapping(path = "/reservmodify", method = RequestMethod.GET)
	public String sheet11() {

		/**returnの後ろのhtml名以外は変更の必要無し**/

		return "yoyaku2hensakuzyo";
	}

	//登録用
	@RequestMapping(path = "/sheetIns", method = RequestMethod.POST)
	public String sheet2(HttpSession session,String ban, String bi, String mei) {

		//登録処理
		mei=(String) session.getAttribute("name");
		jdbcTemplate.update("INSERT INTO sheetreserve  VALUES (?,?,?);", ban, bi, mei);

		return "redirect:/sheetreserv";
	}

	//更新用(ヒント無し)
	@RequestMapping(path = "/sheetUpd", method = RequestMethod.POST)
	public String sheet3(HttpSession session,String ban, String mei) {
		mei=(String) session.getAttribute("name");
		// 更新処理
		jdbcTemplate.update("UPDATE sheetreserve SET  yoyakuname=? WHERE yoyakubango=?", ban, mei);

		return "redirect:/sheetreserv";
	}

	//削除用(ヒント無し)
	@RequestMapping(path = "/sheetDel", method = RequestMethod.POST)
	public String sheet4(String ban) {

		//削除処理
		jdbcTemplate.update("DELETE FROM sheetreserve WHERE  yoyakubango= ?;", ban);
		return "redirect:/sheetreserv";
	}
	@RequestMapping(path = "/sheetrank", method = RequestMethod.GET)
	public String sheetrank(HttpSession session,Model model) {
		String names=(String)session.getAttribute("name");
		System.out.println(names);
		List<Map<String, Object>> kensakukekka 
		=jdbcTemplate.queryForList("SELECT * FROM sheetreserve where yoyakuname = ?",names);
int rankdata=kensakukekka .size();
String rankname=(String)kensakukekka.get(0).get("yoyakuname");
String rank="";
if(rankdata>=12) {
	rank="石油王";
}else if(rankdata>=8){
	rank="大御所ユーザ";
}else  if(rankdata>=4) {
	rank="ベテランユーザ";
}else if(rankdata>=1) {
	rank="初心者ユーザ";
}else {
	rank="ひよこユーザ";	
}
model.addAttribute("rank",rank);
model.addAttribute("rankdata",rankdata);
model.addAttribute("rankname",rankname);
model.addAttribute("kensakukekka",kensakukekka);

		return "yoyakurank";
	}
	@RequestMapping(path = "/sheetranking", method = RequestMethod.GET)
	public String sheetranking(HttpSession session,Model model) {
		String names=(String)session.getAttribute("name");
		System.out.println(names);
		List<Map<String, Object>> kensakukekka 
		=jdbcTemplate.queryForList("SELECT yoyakuname, COUNT(yoyakuname) AS count FROM sheetreserve GROUP BY yoyakuname ORDER BY count DESC LIMIT 3;"
);

String rankname1=(String)kensakukekka.get(0).get("yoyakuname");
String rankname2=(String)kensakukekka.get(1).get("yoyakuname");
String rankname3=(String)kensakukekka.get(2).get("yoyakuname");
model.addAttribute("rankname1",rankname1);
model.addAttribute("rankname2",rankname2);
model.addAttribute("rankname3",rankname3);

		return "yoyakuranking";
	}
}
