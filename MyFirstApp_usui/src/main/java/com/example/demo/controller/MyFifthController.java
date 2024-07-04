

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MyFifthController {

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/fifthroc", method = RequestMethod.GET)
	public String fourthget() {
		return "myfifthcorrect";
	}
	
	//画面からの値を処理するPOSTメソッド
	@RequestMapping(path = "/fifthroc", method = RequestMethod.POST)
	public String fourthpost(String debuggerName,Model model) {
		
		model.addAttribute("as",debuggerName);
		
		return "myfifthcorrect";
	}
}