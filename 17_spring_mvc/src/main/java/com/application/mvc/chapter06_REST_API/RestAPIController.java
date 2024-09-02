package com.application.mvc.chapter06_REST_API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.mvc.data.ProductDTO;
import com.application.mvc.data.SupposeDAO;

@RestController // 어노테이션을 사용하여 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타낸다. 
@RequestMapping("/product") // 자원 기반의 URL을 사용하고 HTTP 메서드를 사용하여 구현한다.
public class RestAPIController { // 화면이동용 아님!!!!

	@Autowired
	private SupposeDAO supposeDAO;
	
	/* URL자원(데이터)에 대한 CRUD (Create, Read, Update, Delete) 작업을 REST API를 통해 제공한다. */
	
	@GetMapping // 전체 데이터 요청, localhost/product까지
	//@ResponseBody
	public List<ProductDTO> getProductList() {
		return supposeDAO.getDTOList();
	}
	
	@GetMapping("/{productId}") // 상세 데이터 요청 (@PathVariable 어노테이션으로 데이터를 전달받는다.)
	public ProductDTO getProductDetail(@PathVariable("productId") long productId) {
		System.out.println("(@GetMapping)productId : " + productId);
		return supposeDAO.getDTO();
	}
	
	@PostMapping // 데이터 추가 (@RequestBody 어노테이션으로 데이터를 전달받는다.)
	public void createProduct(@RequestBody ProductDTO productDTO) {
		System.out.println("(@PostMapping)productDTO : " + productDTO);
	}
	
	
	@PutMapping("/{productId}")// 데이터 수정 (@PathVariable 어노테이션으로 ID를 전달받는다.)
	public void updateProduct(@PathVariable("productId") long productId, @RequestBody ProductDTO productDTO) { // @RequestBody 어노테이션으로 데이터를 전달받는다.
		System.out.println("(@PutMapping)productId : " + productId);
		System.out.println("(@PutMapping)productDTO : " + productDTO);
	}
	
	
	@DeleteMapping("/{productId}")// 데이터 삭제 (@PathVariable 어노테이션으로 데이터를 전달받는다.)
	public void deleteProduct(@PathVariable("productId") long productId) {
		System.out.println("(@DeleteMapping)" + productId + "가 삭제되었습니다.");
	}
	
}
