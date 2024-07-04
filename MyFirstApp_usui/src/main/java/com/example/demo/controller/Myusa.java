package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Myusa {

	@RequestMapping(path = "/userLogin", method = RequestMethod.GET)

	public String usarog() {
		return "rog";
	}

	@RequestMapping(path = "/userLogin", method = RequestMethod.POST)
	public String fourthpost(String LoginId,String LoginName , Model model) {
		if ( LoginId.equals("userlogin") &&LoginName.equals("userpass")) {
		
			return "out";
		} else {
			model.addAttribute("sousin01", "失敗");
			return "rog";
		}

	}

	@RequestMapping(path = "/userLogin02", method = RequestMethod.POST)
	public String fourthpost(String text02, Model model) {

		model.addAttribute("sousin02", text02);

		return "out";
	}
}
