package com.application.mvc.chapter05_AJAX;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxPracticeController {


	@GetMapping("/ex03_practice")
	public String question03() {
		return "chapter05_AJAX/ajaxEx03_practice";
	}
	
	@PostMapping("/ex03_practice")
	@ResponseBody
	public String practice03(@RequestBody Map<String, String> map) {
		
		String com = map.get("com");
		String me  = map.get("me");
		
		String result = "";
		
		if(com.equals(me))				result = "비겼다.";
		else if (me.equals("가위"))		result = "내가 졌다.";
		else if (me.equals("보")) 		result = "내가 이겼다.";
		else							result = "잘못된 입력값입니다.";
		
		return result;
	}
	
	@GetMapping("/ex04_practice")
	public String question04() {
		return "chapter05_AJAX/ajaxEx04_practice";
	}
	
	
	@GetMapping("/ex05_practice")
	public String question05() {
		return "chapter05_AJAX/ajaxEx05_practice";
	}
	
	
	@GetMapping("/ex06_practice")
	public String question06() {
		return "chapter05_AJAX/ajaxEx06_practice";
	}
	
	
	@GetMapping("/ex07_practice")
	public String question07() {
		return "chapter05_AJAX/ajaxEx07_practice";
	}
	
	
	@GetMapping("/ex08_practice")
	public String question08() {
		return "chapter05_AJAX/ajaxEx08_practice";
	}
	
	
	@GetMapping("/ex09_practice")
	public String question09() {
		return "chapter05_AJAX/ajaxEx09_practice";
	}
	
	
	@GetMapping("/ex10_practice")
	public String question10() {
		return "chapter05_AJAX/ajaxEx10_practice";
	}
	
	
	@GetMapping("/ex11_practice")
	public String question11() {
		return "chapter05_AJAX/ajaxEx11_practice";
	}
	
	
	@GetMapping("/ex12_practice")
	public String question12(Model model) {
		
		Random ran = new Random();
		int authenticationNumber = ran.nextInt(9000) + 1000;
		
		model.addAttribute("authenticationNumber" , authenticationNumber);
		
		return "chapter05_AJAX/ajaxEx12_practice";
		
	}
	
	
	@GetMapping("/ex13_practice")
	public String question13() {
		return "chapter05_AJAX/ajaxEx13_practice";
	}
	
	
	@GetMapping("/ex14_practice")
	public String question14() {
		return "chapter05_AJAX/ajaxEx14_practice";
	}
	
	@GetMapping("/ex15_practice")
	public String question15() {
		return "chapter05_AJAX/ajaxEx15_practice";
	}
	
	
	@GetMapping("/ex16_practice")
	public String question16() {
		return "chapter05_AJAX/ajaxEx16_practice";
	}
	
	
	@GetMapping("/ex17_practice")
	public String question17() {
		return "chapter05_AJAX/ajaxEx17_practice";
	}
	
}
