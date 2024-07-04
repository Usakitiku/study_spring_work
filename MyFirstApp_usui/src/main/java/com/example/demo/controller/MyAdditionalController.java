package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyAdditionalController {
	@RequestMapping(path = "/additional", method = RequestMethod.GET)
	public String fastadd() {
		return "myadditional";
	}

	@RequestMapping(path = "/additional", method = RequestMethod.POST)
	public String fastaddpos(String q1, String q2, String q3, String q4, Model model) {
		System.out.println(q1+q2 +q3 + q4);
		String s = null;
		if (q1.equals("i") && q2.equals("s") && q3.equals("t") && q4.equals("j")) {
			s = "ISTJ（「義務遂行者」）:\n実用的で真面目、事実に基づいて行動する。組織と責任を重んじる。";model.addAttribute("s",s);
		} else if (q1.equals("i") && q2.equals("s") && q3.equals("f") && q4.equals("j")) {
			s = "ISFJ（「保護者」）:\n温かく、寛大、忠実。伝統と安定性を大切にする。";model.addAttribute("s",s);
		} else if (q1.equals("i") && q2.equals("n") && q3.equals("f") && q4.equals("j")) {
			s = "INFJ（「カウンセラー」）:\n洞察力があり、直感的。理想主義的で、他人の成長を助けることに情熱を持つ。";model.addAttribute("s",s);
		} else if (q1.equals("i") && q2.equals("n") && q3.equals("t") && q4.equals("j")) {
			s = "	INTJ（「戦略家」）:独立心が強く、創造的。複雑な問題解決に優れている。";model.addAttribute("s",s);
		} else if (q1.equals("i") && q2.equals("s") && q3.equals("t") && q4.equals("p")) {
			s = "ISTP（「職人」）:\n現実的で柔軟、効率的。危機管理能力が高い。";model.addAttribute("s",s);
		} else if (q1.equals("i") && q2.equals("s") && q3.equals("f") && q4.equals("p")) {
			s = "ISFP（「アーティスト」）:\n穏やかで忍耐強い。現在を生きることを楽しむ。";model.addAttribute("s",s);
		} else if (q1.equals("i") && q2.equals("n") && q3.equals("f") && q4.equals("p")) {
			s = "INFP（「仲介者」）:\n内省的で理想主義的。創造的で情熱的。";model.addAttribute("s",s);
		} else if (q1.equals("i") && q2.equals("n") && q3.equals("t") && q4.equals("p")) {
			s = "INTP（「論理学者」）:\n非常に知的で理論的。好奇心旺盛で独創的。";model.addAttribute("s",s);
		} else if (q1.equals("e") && q2.equals("s") && q3.equals("t") && q4.equals("p")) {
			s = "ESTP（「冒険家」）:\n行動的でエネルギッシュ。現実的で解決志向。";model.addAttribute("s",s);
		} else if (q1.equals("e") && q2.equals("n") && q3.equals("f") && q4.equals("p")) {
			s = "ESFP（「パフォーマー」）:\n社交的で活発。楽しいことを見つけ、共有するのが得意。";model.addAttribute("s",s);
		} else if (q1.equals("e") && q2.equals("n") && q3.equals("f") && q4.equals("p")) {
			s = "ENFP（「活動家」）:\n熱意があり、創造的。可能性を見つけて刺激する。";model.addAttribute("s",s);
		} else if (q1.equals("e") && q2.equals("n") && q3.equals("t") && q4.equals("p")) {
			s = "ENTP（「発明家」）:\n知的で好奇心が強い。新しいことに挑戦するのが好き。";model.addAttribute("s",s);
		} else if (q1.equals("e") && q2.equals("s") && q3.equals("t") && q4.equals("j")) {
			s = "ESTJ（「実行者」）:\n組織的で実践的。リーダーシップがあり、物事を成し遂げる。";model.addAttribute("s",s);
		} else if (q1.equals("e") && q2.equals("s") && q3.equals("f") && q4.equals("j")) {
			s = "ESFJ（「提供者」）:\n協力的で調和を重んじる。他人のニーズに敏感。";model.addAttribute("s",s);
		} else if (q1.equals("e") && q2.equals("n") && q3.equals("f") && q4.equals("j")) {
			s = "ENFJ（「教師」）:\n社交的でカリスマ的。他人を奮い立たせ、導く。";model.addAttribute("s",s);
		} else if (q1.equals("e") && q2.equals("n") && q3.equals("t") && q4.equals("j")) {
			s = "ENTJ（「指導者」）:\n決断力があり、自信がある。挑戦を楽しみ、目標を達成する";
			model.addAttribute("s",s);
		
		
	}return "myadditional";
	}
}
