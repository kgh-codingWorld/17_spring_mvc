package com.application.mvc.chapter02_modelAndView;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 
	# Representational State Transfer 
  
	- 웹 시스템에서 서버와 클라이언트간의 자원(resource)를 교환하기 위한 아키텍처 스타일
  
	- 자원을 표현(representation) 으로 구분하여 해당 자원의 상태(get , post , put , delete)를 주고 받는 모든 것을 의미한다.
  
 */

@Controller
@RequestMapping("/c2v/rest")
public class C2V_REST {
	

	/*
	  
	 	# 예시 1) @ResponseBody  
	 	
	 	- HTTP 본문의 응답을 나타내는데 사용한다.
	 	
	 	- 이는 클라이언트가 요청한 작업의 결과를 포함하며 , 데이터 형식은 JSON , XML , HTML 등으로 표현된다.
	 	 
	 	- 서버에서 클라이언트로 전송되는 데이터의 실제 내용을 담고 있고 , 클라이언트가 이 정보를 바탕으로 필요한
	 	  로직을 처리하거나 클라이언트 UI를 업데이트할 수 있다.
	 	 
	 	- ResponseEntity와 기능이 같으며 헤더와 상태 코드를 제외한 HTML 본문만 전송한다.
     
	 */
	
	@GetMapping("/responseBody") // localhost/c2v/rest/responseBody
	@ResponseBody // 붙이면 데이터 전송 , 안붙이면 html 포워딩
	public String responseBody() {
		
		//String jsScript = "<h1>테스트 데이터</h1>";
		String jsScript = """
				<script>
					alert('결제되었습니다.');
				</script>
				""";
		
		return jsScript;
		
		
	}
	
	
	
	
	/*
	  
	 	 # 2) ResponseEntity
	 	 
	 	 - HTTP에서 Request와 Response 동작시 전송되는 정보는 크게 body(몸체) , headers(헤더), status code(상태 코드)가 있다.

	 	 - @ResponseBody에 없는 헤더와 상태코드를 함께 반환한다.
	 	
	 		[ 구성요소 ]
	 		
	 	 	I) body (옵션)
	 		- HTTP의 request 또는 response가 전송하는 데이터(본문)
	 		
	 	 	II) headers (옵션)
	 		- HTTP의 request 또는 response에 대한 부가적인 정보
	 		
	 		(한글 헤더 참고)
	 		HttpHeaders responseHeaders = new HttpHeaders();
	 		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	 
	 	 	III) status code (필수)
	 		- 클라이언트의 요청이 성공적으로 처리되었는지 상태를 알려주는 것
	  
	 */
	
	@GetMapping("/responseEntity") // localhost/c2v/rest/responseEntity
	public ResponseEntity<Object> responseEntity() {
		
		// 1) 상태코드
		//return new ResponseEntity<Object>(HttpStatus.OK);
		
		// 2) 본문 + 상태코드 
		String jsScript = """
				<script>
					alert('결제되었습니다.');
				</script>
				""";
		//return new ResponseEntity<Object>(jsScript , HttpStatus.OK);
		
		// 3) 본문 + 헤더 + 상태코드
		HttpHeaders responseHeaders = new HttpHeaders();
 		responseHeaders.add("Content-Type", "text/html; charset=utf-8");

		return new ResponseEntity<Object>(jsScript , responseHeaders, HttpStatus.OK);
	
	}
	
	
}


/*

	# 3) @RestController

    - @ResponseController 어노테이션이 추가된 컨트롤러는 기본 반환 타입(String)이 뷰 경로로 구현되지 않고 @ResponseBody로 구현된다.	
	
	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 HTML 본문만 전송한다.
	
	- 메서드가 아닌 '클래스'영역에 @RestController어노테이션을 작성하여 구현한다.  

	- RESTFul API의 Controller 역할을 한다.
	
 */

@RestController // '데이터 전송'
@RequestMapping("/rest")
class RestControllerEx {
	
	@GetMapping("/restController") // localhost/rest/restController
	public String restController() {
		
		String jsScript = """
				<script>
					alert('결제되었습니다.');
				</script>
				""";
		return jsScript;
	}
	
	@GetMapping("/read") // localhost/rest/read
	public String read() {
		return "조회"; // 데이터 전송o, 화면 이동x
	}
	
	@GetMapping("/create") // localhost/rest/create
	public String create() {
		return "생성"; // 데이터 전송o, 화면 이동x
	}
	
	@GetMapping("/update") // localhost/rest/update
	public String update() {
		return "수정"; // 데이터 전송o, 화면 이동x
	}
	
	@GetMapping("/delete") // localhost/rest/delete
	public String delete() {
		return "삭제"; // 데이터 전송o, 화면 이동x
	}
}



	
