package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Zaseki {
	List<String> list = new ArrayList<>();
	String ac1c = null;
	String[] id = new String[10];
	String[] ps = new String[10];
	String idname = null;
	int idset = 0;

	@RequestMapping(path = "/zasekiyoyaku", method = RequestMethod.GET)
	public String fast1(Model model, HttpSession session) {
		list.clear();
		return "zaseki";
	}

	@RequestMapping(path = "/zasekiyoyaku", method = RequestMethod.POST)
	public String second(String ac4, String ac3f1, String ac3f2, String ac1, String ac2, Model model,
			String scr1, String ID, HttpSession session) {
		ac1c = ac1;
		if (ID != null) {
			idname = ID;
		}

		for (String f1we : id) {
			System.out.println(f1we);
		}

		if (ac3f1 != null && ac3f2 != null) {
			int ac3f1c = Integer.parseInt(ac3f1);
			int ac3f2c = Integer.parseInt(ac3f2);
			while (ac3f1c <= ac3f2c) {
				String s = Integer.toString(ac3f1c);
				for (String f1 : list) {
					if (f1.equals(s)) {
						model.addAttribute("zf", "ok");
						session.setAttribute("ac101", ac1);
						ac3f1c = 11;
						return "zaseki";
					}
				}
				if (idset == 10) {
					idset = 0;
				}
				list.add(s);
				id[idset] = idname;
				ac3f1c++;
				idset++;
			}
		}
		if (ac2 != null) {
			for (String f2 : list) {
				if (f2.equals(ac2)) {
					model.addAttribute("zf", "ok");
					session.setAttribute("ac101", ac1);
					return "zaseki";
				}
			}
			if (idset == 10) {
				idset = 0;
			}
			list.add(ac2);
			id[idset] = idname;
			idset++;
		}
		if (ac4 != null) {
			int sakuzyo = 0;
			for (String s : list) {

				if (s.equals(ac4)) {

					while (id[sakuzyo] != null) {
						id[sakuzyo] = id[++sakuzyo];
					}
					idset--;
					list.remove(list.indexOf(s));
					seiretu(session);
					session.setAttribute("ac101", ac1);
					return "zaseki";
				}
				sakuzyo++;
			}
		}
		seiretu(session);
		session.setAttribute("ID", ID);
		session.setAttribute("ac101", ac1);
		return "zaseki";
	}

	void seiretu(HttpSession session) {
		String[] listc1 = new String[list.size()];
		int i = 0;
		int idban = 0;
		for (int n = 1; n <= 10; n++) {
			String xc = Integer.toString(n);
			idban = 0;
			for (String s : list) {
				if (s.equals(xc)) {
					if (ac1c != null && (ac1c.equals("検索"))) {
						if (idname.equals(id[idban])) {
							listc1[i] = s + "番" + id[idban];
						}
					} else {
						listc1[i] = s + "番" + id[idban];
					}
					i++;
				}
				idban++;
			}
		}
		session.setAttribute("list", listc1);
	}
}