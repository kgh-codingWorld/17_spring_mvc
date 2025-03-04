package com.application.mvc.chapter02_modelAndView;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.mvc.data.ProductDTO;

@Controller
@RequestMapping("/v2c")
public class V2C_binding {

	@GetMapping("/view")
	public String view() { // localhost/v2c/view
		return "chapter02_modelAndView/v2c";
	}
	
	/*
	 
		  1) @ModelAttribute
		  
		  - @ModelAttribute 어노테이션을 사용하여 HTML element name 과 DTO property가 일치된 경우에  
		     DTO 형식으로 바인딩(매핑) 된 전달받을 수 있다. 
		    
		  - @ModelAttribute 의 경우 내부적으로 검증(Validation) 작업을 진행하기 때문에 setter 메서드를 이용하여 값을 바인딩하려고 시도하다가 
		   예외를 만날때(데이터 타입 불일치) 작업이 중단되면서 Http 400 Bad Request가 발생한다.
		   
		  - String to Date 데이터 형식의 바인딩은 DTO클래스 property위에 @DateTimeFormat(pattern = "yyyy-MM-dd")을 추가하여 매핑한다.
		  
	 */
	
	@PostMapping("/modelAttribute")
	public String modelAttribute(@ModelAttribute ProductDTO productDTO) {
		
		System.err.println("\n @ModelAttribute \n");
		System.out.println(productDTO);
		System.out.println();
		
		return "redirect:/v2c/view"; // 실습을 위해 다시 view로 이동
	}
	
	// (참고 오류 코드)
	// 405(get, post 불일치)
	@PostMapping("/testUrl") // 404(url 경로 불일치)
	public String testUrl(@ModelAttribute ProductDTO productDTO) { // 400(전송되는 데이터 타입 불일치)
		
		// 500(이하 로직 모두 [html파일 thymeleaf 포함])
		
		return "html 파일로 이동";
	}
	
	
	/* 
	  
		  2) @RequestParam Map<K,V>
		  
		  - 요청 HTML의 name속성이 Map 컬렉션 프레임워크의 "KEY"로 바인딩되며
		    요청 HTML의 name의 value속성이 Map 컬렉션 프레임워크의 "VALUE"로 바인딩된다.
		
		  - HashMap타입이 아닌 HashMap의 인터페이스인 Map타입으로 데이터를 받는다.
		 
		  - Map으로 전달되는 데이터가 정수 , 실수 , 글자등 다양한 데이터일 경우 다형성을 이용하여 Object타입으로 처리할 수 있다.
		  
		  - Object 타입으로 전송받는 경우 데이터를 전송받은 이후 로직에 알맞게 데이터 형변환을 따로 해주어야 한다.
	  
	 */
	
	@PostMapping("/map")
	public String map(@RequestParam Map<String, Object> productMap) {
		
		// 전체 가져오기
		System.out.println("\n - Map - \n");
		System.out.println(productMap);
		System.out.println();
		
		/*
		 
		 	# Object로 데이터를 받은 이후 형변환하는 방법 예시
		 	
		 	1) String : map.get("key").toString() , 
		 			    map.get("key") + ""
		 			    
		 	2) int    : Integer.parseInt(map.get("key").toString());
		 				Integer.parseInt(map.get("key") + "");
		 				
		 	3) long   : Long.parseLong(map.get("key").toString());
		 				Long.parseLong(map.get("key") + "");
		 				
		 	4) double : Double.parseDouble(map.get("key").toString());
		 				Double.parseDouble(map.get("key") + "");
		 
		 */
		
		// 하나씩 가져오기
		long productId 		= Long.parseLong(productMap.get("productId").toString());
		String productNm 	= productMap.get("productNm").toString();
		int price 			= Integer.parseInt(productMap.get("price").toString());
		
		System.out.println("productId : " + productId);
		System.out.println("productId : " + productNm);
		System.out.println("productId : " + price);
		System.out.println();
		
		return "redirect:/v2c/view";
	}
		
	
	
}
