package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MyFifthPraController{
	
	
	@RequestMapping(path = "/myfifthpra", method = RequestMethod.GET)
	
	public String fourthget(Model model) {
		 String modelpra="さしもんめ";
		model.addAttribute("modelpra",modelpra);
		return "myfifthpra";}
@RequestMapping(path = "/myfifthpra", method = RequestMethod.POST)
	
	public String fourthget(String like,Model model) {
		if(like.equals("お寿司")) {
			like="私もお寿司が好きです";
		}
		System.out.println(like);
		model.addAttribute("likefood",like);
		return "myfifthpra";}}

