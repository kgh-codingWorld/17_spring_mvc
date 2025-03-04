package com.application.mvc.chapter01_thymeleaf;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.mvc.data.ProductDTO;

@Controller
@RequestMapping("/th/object")
public class ObjectController {

	@GetMapping("/ex01")  // localhost/th/object/ex01
	public String ex01(Model model) {
	
		// th:object , th:value 예시
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(2);
		productDTO.setProductNm("테스트 상품2");
		productDTO.setPrice(300000);
		productDTO.setDeliveryPrice(3000);
		productDTO.setEnrollDt(new Date());
		productDTO.setBrandId(100);
		
		model.addAttribute("productDTO" , productDTO);
		// 1) Model Interface에서 지원이 된다.
		// 2) HashMap은 지원 x (key value라 안 됨) > 객체만 가능
		
		return "chapter01_thymeleaf/object/objectEx01";
	
	}
	
	
	@GetMapping("/ex02") // localhost/th/object/ex02
	public String ex02(Model model) {
		
		// 다양한 폼데이터 예시
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPrice(3000000); 					// 1000000 , 2000000 , 3000000
		productDTO.setDeliveryPrice(2500);  			// 0 , 2500 , 3000
		productDTO.setProductId(1); 					// 1 , 2 , 3
		productDTO.setEnrollDt(new Date());	
		productDTO.setProductNm("테스트상품입니다.");
		
		model.addAttribute("productDTO" , productDTO);
		
		return "chapter01_thymeleaf/object/objectEx02";
	
	}
	
}
