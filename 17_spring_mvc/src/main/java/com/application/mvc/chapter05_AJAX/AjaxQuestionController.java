package com.application.mvc.chapter05_AJAX;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjaxQuestionController {


	@GetMapping("/ex03_question")
	public String question03() {
		return "chapter05_AJAX/ajaxEx03_question";
	}
	
	
	@GetMapping("/ex04_question")
	public String question04() {
		return "chapter05_AJAX/ajaxEx04_question";
	}
	
	
	@GetMapping("/ex05_question")
	public String question05() {
		return "chapter05_AJAX/ajaxEx05_question";
	}
	
	
	@GetMapping("/ex06_question")
	public String question06() {
		return "chapter05_AJAX/ajaxEx06_question";
	}
	
	
	@GetMapping("/ex07_question")
	public String question07() {
		return "chapter05_AJAX/ajaxEx07_question";
	}
	
	
	@GetMapping("/ex08_question")
	public String question08() {
		return "chapter05_AJAX/ajaxEx08_question";
	}
	
	
	@GetMapping("/ex09_question")
	public String question09() {
		return "chapter05_AJAX/ajaxEx09_question";
	}
	
	
	@GetMapping("/ex10_question")
	public String question10() {
		return "chapter05_AJAX/ajaxEx10_question";
	}
	
	
	@GetMapping("/ex11_question")
	public String question11() {
		return "chapter05_AJAX/ajaxEx11_question";
	}
	
	
	@GetMapping("/ex12_question")
	public String question12(Model model) {
		
		Random ran = new Random();
		int authenticationNumber = ran.nextInt(9000) + 1000;
		
		model.addAttribute("authenticationNumber" , authenticationNumber);
		
		return "chapter05_AJAX/ajaxEx12_question";
		
	}
	
	
	@GetMapping("/ex13_question")
	public String question13() {
		return "chapter05_AJAX/ajaxEx13_question";
	}
	
	
	@GetMapping("/ex14_question")
	public String question14() {
		return "chapter05_AJAX/ajaxEx14_question";
	}
	
	@GetMapping("/ex15_question")
	public String question15() {
		return "chapter05_AJAX/ajaxEx15_question";
	}
	
	
	@GetMapping("/ex16_question")
	public String question16() {
		return "chapter05_AJAX/ajaxEx16_question";
	}
	
	
	@GetMapping("/ex17_question")
	public String question17() {
		return "chapter05_AJAX/ajaxEx17_question";
	}
	
}
