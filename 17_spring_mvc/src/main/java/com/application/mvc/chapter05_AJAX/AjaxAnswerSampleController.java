package com.application.mvc.chapter05_AJAX;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.mvc.data.ProductDTO;
import com.application.mvc.data.SupposeDAO;

@Controller
@RequestMapping("/ajax")
public class AjaxAnswerSampleController {

	@Autowired
	private SupposeDAO supposeDAO;

	@GetMapping("/ex03_answerSample")
	public String answerSample03() {
		return "chapter05_AJAX/ajaxEx03_answerSample";
	}
	
	@PostMapping("/ex03_answerSample")
	@ResponseBody
	public String answerSample03(@RequestBody Map<String,String> map) {
		
		String com = map.get("com");
		String me  = map.get("me");
		
		String result = "";
		
		if (com.equals(me)) 		result = "비겼다.";
		else if (me.equals("가위")) result = "내가 졌다.";
		else if (me.equals("보")) 	result = "내가 이겼다.";
		else 						result = "잘못된 입력값 입니다. '가위' 혹은 '바위' 혹은 '보'를 입력해주세요.";
		
		return result;
		
	}
	
	
	@GetMapping("/ex04_answerSample")
	public String answerSample04() {
		return "chapter05_AJAX/ajaxEx04_answerSample";
	}
	
	@PostMapping("/ex04_answerSample")
	@ResponseBody
	public String answerSample04(@RequestBody Map<String,Integer> map) {
		
		int com = map.get("com");
		int me  = map.get("me");
		
		String result = "";
		
		if (me < com) 		result = "UP!";
		else if (me == com) result = "Bingo!";
		else if (me > com) 	result = "Down!";
		
		return result;
		
	}
	
	
	@GetMapping("/ex05_answerSample")
	public String answerSample05() {
		return "chapter05_AJAX/ajaxEx05_answerSample";
	}
	
	@PostMapping("/ex05_answerSample")
	@ResponseBody
	public String answerSample05(@RequestBody Map<String,Object> map) {
		
		String result = "reject";
		
		double height  = Double.parseDouble(map.get("height").toString());
		String withParent  = map.get("withParent").toString();
		
		if (height >= 120.0 || (height < 120.0 && withParent.equals("yes"))){
			result = "pass";
		}
		
		return result;
		
	}
	
	
	@GetMapping("/ex06_answerSample")
	public String answerSample06() {
		return "chapter05_AJAX/ajaxEx06_answerSample";
	}
	
	@PostMapping("/ex06_answerSample")
	@ResponseBody
	public String answerSample06(@RequestBody Map<String,Integer> map) {
		
		int num1 = map.get("num1");
		int num2  = map.get("num2");
		
		int tryAnswer = map.get("answer");
		int realAnswer = num1 * num2;
		
		String result = "땡 (정답 : " +  realAnswer + ")";
		
		if (tryAnswer == realAnswer) {
			result = "정답";
		}
		
		return result;
		
	}
	
	
	@GetMapping("/ex07_answerSample")
	public String answerSample07() {
		return "chapter05_AJAX/ajaxEx07_answerSample";
	}
	
	@PostMapping("/ex07_answerSample")
	@ResponseBody
	public int answerSample07(@RequestBody Map<String,Integer> map) {
		
		int num1 = map.get("num1");
		int num2  = map.get("num2");
		int num3  = map.get("num3");
		

		int maxNum = num1;
		if (maxNum < num2) {
			maxNum = num2;
		}
		if (maxNum < num3) {
			maxNum = num3;
		}
		
		return maxNum;
		
	}
	
	
	@GetMapping("/ex08_answerSample")
	public String answerSample08() {
		return "chapter05_AJAX/ajaxEx08_answerSample";
	}
	
	@PostMapping("/ex08_answerSample")
	@ResponseBody
	public String answerSample08(@RequestParam("id") String id) {
		
		String result = "N";
		String[] userList = {"user1" , "user2" , "user3" , "user4" , "user5"};
		for (int i = 0; i < userList.length; i++) {
			if (id.equals(userList[i])) {
				result = "Y";
			}
		}
		
		return result;
		
	}
	
	
	@GetMapping("/ex09_answerSample")
	public String answerSample09() {
		return "chapter05_AJAX/ajaxEx09_answerSample";
	}
	
	@PostMapping("/ex09_answerSample")
	@ResponseBody
	public String answerSample09(@RequestBody Map<String,String> map) {
		
		String id = map.get("id");
		String passwd = map.get("passwd");
		
		String result = "F";
		if (id.equals("admin") && passwd.equals("admin")) {
			result = "P";
		}
		
		return result;
		
	}
	
	
	@GetMapping("/ex10_answerSample")
	public String answerSample10() {
		return "chapter05_AJAX/ajaxEx10_answerSample";
	}
	
	@PostMapping("/ex10_answerSample")
	@ResponseBody
	public String answerSample10(@RequestBody Map<String,String> map) {
		
		String orderQty = map.get("orderQty");
		String productId = map.get("productId");
		
		String sql = "UPDATE ORDER ";
			   sql += "SET ORDER_QTY = " + orderQty;
			   sql += "	WHERE PRODUCT_ID = " + productId;
		
		return sql;
		
	}
	
	
	@GetMapping("/ex11_answerSample")
	public String answerSample11() {
		return "chapter05_AJAX/ajaxEx11_answerSample";
	}
	
	@PostMapping("/ex11_answerSample")
	@ResponseBody
	public String answerSample11(@RequestBody Map<String,String> map) {
		
		String orderQty = map.get("orderQty");
		String productId = map.get("productId");
		
		String sql = "UPDATE ORDER ";
			   sql += "SET ORDER_QTY = " + orderQty;
			   sql += "	WHERE PRODUCT_ID = " + productId;
		
		return sql;
		
	}
	
	
	@GetMapping("/ex12_answerSample")
	public String answerSample12(Model model) {
		
		Random ran = new Random();
		int authenticationNumber = ran.nextInt(9000) + 1000;
		
		model.addAttribute("authenticationNumber" , authenticationNumber);
		
		return "chapter05_AJAX/ajaxEx12_answerSample";
		
	}
	
	@PostMapping("/ex12_answerSample")
	@ResponseBody
	public String answerSample12(@RequestBody Map<String,Integer> map) {
		
		int tryAuthentication = map.get("tryAuthentication");
		int authenticationNumber = map.get("authenticationNumber");
		
		String isAuthentication = "N";
		if (tryAuthentication ==  authenticationNumber) {
			isAuthentication = "Y";
		}
		
		return isAuthentication;
		
	}
	
	
	@GetMapping("/ex13_answerSample")
	public String answerSample13() {
		return "chapter05_AJAX/ajaxEx13_answerSample";
	}
	
	@PostMapping("/ex13_answerSample")
	@ResponseBody
	public int answerSample13(@RequestBody Map<String,Integer> map) {
		
		int count = 0;
		if (map.get("likeCnt") != null) {
			count = map.get("likeCnt");		
		}
		if (map.get("dislikeCnt") != null) {
			count = map.get("dislikeCnt");		
		}
		count++;
		
		return count;
		
	}
	
	
	@GetMapping("/ex14_answerSample")
	public String answerSample14() {
		return "chapter05_AJAX/ajaxEx14_answerSample";
	}
	
	@PostMapping("/ex14_answerSample")
	@ResponseBody
	public ProductDTO postAnswerSample14() {
		return supposeDAO.getDTO();
	}
	
	
	@GetMapping("/ex15_answerSample")
	public String answerSample15() {
		return "chapter05_AJAX/ajaxEx15_answerSample";
	}
	
	@PostMapping("/ex15_answerSample")
	@ResponseBody
	public List<ProductDTO> postAnswerSample15() {
		return supposeDAO.getDTOList();
	}
	
	
	@GetMapping("/ex16_answerSample")
	public String postAnswerSample16() {
		return "chapter05_AJAX/ajaxEx16_answerSample";
	}
	
	@PostMapping("/ex16_answerSample")
	@ResponseBody
	public Map<String,Object> answerSample16() {
		return supposeDAO.getMap();
	}
	
	
	@GetMapping("/ex17_answerSample")
	public String postAnswerSample17() {
		return "chapter05_AJAX/ajaxEx17_answerSample";
	}
	
	@PostMapping("/ex17_answerSample")
	@ResponseBody
	public List<Map<String,Object>> answerSample17() {
		return supposeDAO.getMapList();
	}
	
}
