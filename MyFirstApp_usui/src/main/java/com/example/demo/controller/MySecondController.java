package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MySecondController {
	@RequestMapping(path = "/second", method = RequestMethod.GET)
	public String seconds() {
		return "Mysecnd";
	}
	@RequestMapping(path = "/s", method = RequestMethod.GET)
	public String secondsh() {
		return "Mysecondchall";
	}
}
