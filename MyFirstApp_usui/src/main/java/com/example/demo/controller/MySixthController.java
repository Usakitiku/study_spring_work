package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MySixthController {

	@RequestMapping(path = "/sixthpra", method = RequestMethod.GET)
	public String four(Model model) {
		
		model.addAttribute("ichimonme","いちもんめ");
		
		return "MySixth";
	}

	@RequestMapping(path = "/sixthlogin", method = RequestMethod.POST)
	public String four(String a,String b ,Model model) {
		if(a=="uho"&& b=="uhoho") {
			model.addAttribute("a",a);
			System.out.println("ログイン成功");
		}else {
			System.out.println("ログイン失敗");
		}
        System.out.println(a + b);
        
		return "MySixth";
	}
}