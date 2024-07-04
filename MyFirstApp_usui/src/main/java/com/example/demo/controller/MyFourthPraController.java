package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyFourthPraController {
	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/fourthprapra", method = RequestMethod.GET)
	public String fourthget() {
		return "myfourthpra";
	}

	@RequestMapping(path = "/fourthprapra", method = RequestMethod.POST)
	public String fourthpost(String dekita, Model model) {
		model.addAttribute("dk", dekita);
		return "myfourthpra";
	}
}
