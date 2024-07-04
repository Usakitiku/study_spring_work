
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyFirstController {

	//スラッシュがあるやつがローカルホスト
	@RequestMapping(path = "/firstpage2", method = RequestMethod.GET)
	public String first() {
		return "myfirst2";
	}
	@RequestMapping(path = "/secondpage", method = RequestMethod.GET)
	public String second() {
		return "Mysecnd";
	}
	@RequestMapping(path = "/thiredpage", method = RequestMethod.GET)
	public String thrird() {
		return "mythird";
	}
}


