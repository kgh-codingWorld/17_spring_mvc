package com.application.mvc.chapter05_AJAX;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxPracticeController {


	@GetMapping("/ex03_practice")
	public String practice03() {
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
	public String practice04() {
		return "chapter05_AJAX/ajaxEx04_practice";
	}
	
	@PostMapping("/ex04_practice")
	@ResponseBody
	public String practice04(@RequestBody Map<String, Integer> map) {
		
		int com = map.get("com");
		int me  = map.get("me");
		
		String result = "";
		
		if (me < com) {
			result = "Up!";
		} else if (me == com) {
			result = "Bingo!";
		} else if (me > com) {
			result = "Down";
		}
		
		return result;
	}
	
	@GetMapping("/ex05_practice")
	public String practice05() {
		return "chapter05_AJAX/ajaxEx05_practice";
	}
	
	@PostMapping("/ex05_practice")
	@ResponseBody
	public String practice05(@RequestBody Map<String, Object> map) {
		
		String result = "";
		
		double height = Double.parseDouble(map.get("height").toString());
		String withParaent = map.get("withParent").toString();
		
		if (height >= 120.0 || (height < 120.0 && withParaent.equals("yes"))) {
			result = "pass";
		} else {
			result = "reject";
		}
		
		return result;
	}
	
	
	@GetMapping("/ex06_practice")
	public String practice06() {
		return "chapter05_AJAX/ajaxEx06_practice";
	}
	
	@PostMapping("/ex06_practice")
	@ResponseBody
	public String practice06(@RequestBody Map<String, Integer> map) {
		
		int num1 = map.get("num1");
		int num2 = map.get("num2");
		int answer = map.get("answer");
		
		int realAnswer = num1 * num2;
		
		String result = "";
		
		if (answer == realAnswer) {
			result = "정답";
		} else {
			result = "땡(정답 : " + realAnswer + ")";
		}
		
		return result;
	}
	
	
	@GetMapping("/ex07_practice")
	public String practice07() {
		return "chapter05_AJAX/ajaxEx07_practice";
	}
	
	@PostMapping("/ex07_practice")
	@ResponseBody
	public int practice07(@RequestBody Map<String, Integer> map) {
		
		int num1 = map.get("num1");
		int num2 = map.get("num2");
		int num3 = map.get("num3");
		
		int maxNum = num1;
		if(maxNum < num2) {
			maxNum = num2;
		} else if(maxNum < num3) {
			maxNum = num3;
		}
		
		return maxNum;
	}
	
	
	@GetMapping("/ex08_practice")
	public String practice08() {
		return "chapter05_AJAX/ajaxEx08_practice";
	}
	
	@PostMapping("/ex08_practice")
	@ResponseBody
	public String practicce08(@RequestParam("id") String id) {
		
		String result = "N";
		
		String[] userList = {"user1" , "user2" , "user3" , "user4" , "user5"};
		for (String user : userList) {
			if(id.equals(user)) {
				
			}
		}
		
		return "";
		
	}
	
	@GetMapping("/ex09_practice")
	public String practice09() {
		return "chapter05_AJAX/ajaxEx09_practice";
	}
	
	
	@GetMapping("/ex10_practice")
	public String practice10() {
		return "chapter05_AJAX/ajaxEx10_practice";
	}
	
	
	@GetMapping("/ex11_practice")
	public String practice11() {
		return "chapter05_AJAX/ajaxEx11_practice";
	}
	
	
	@GetMapping("/ex12_practice")
	public String practice12(Model model) {
		
		Random ran = new Random();
		int authenticationNumber = ran.nextInt(9000) + 1000;
		
		model.addAttribute("authenticationNumber" , authenticationNumber);
		
		return "chapter05_AJAX/ajaxEx12_practice";
		
	}
	
	
	@GetMapping("/ex13_practice")
	public String practice13() {
		return "chapter05_AJAX/ajaxEx13_practice";
	}
	
	
	@GetMapping("/ex14_practice")
	public String practice14() {
		return "chapter05_AJAX/ajaxEx14_practice";
	}
	
	@GetMapping("/ex15_practice")
	public String practice15() {
		return "chapter05_AJAX/ajaxEx15_practice";
	}
	
	
	@GetMapping("/ex16_practice")
	public String practice16() {
		return "chapter05_AJAX/ajaxEx16_practice";
	}
	
	
	@GetMapping("/ex17_practice")
	public String practice17() {
		return "chapter05_AJAX/ajaxEx17_practice";
	}
	
}
