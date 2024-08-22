package com.application.mvc;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.mvc.chapter03_mybatis.M2D;
import com.application.mvc.data.BrandDTO;
import com.application.mvc.data.ProductDTO;

/*

	# 테스트 코드 
	
	- 테스트 코드를 작성하는 것은 애플리케이션의 안정성을 보장하고, 
	기능이 예상대로 동작하는지 확인하기 위한 중요한 과정이다.
	
	- 단위 테스트(Unit Test): 가장 작은 코드 단위의 기능을 테스트한다.
	보통 메소드 레벨에서 이루어지며, 스프링 컨텍스트를 로드하지 않아 실행 속도가 빠르다.
	
	- @SpringBootTest 애너테이션을 클래스 레벨에 사용하여 스프링 부트의 테스트 환경을 구성한다. 
	  @Test 애너테이션을 메서드 레벨에 사용하여 테스트 케이스를 정의한다.

*/

@SpringBootTest
public class M2dMapperTest {

	@Autowired
	private M2D m2d;

	@DisplayName("DTO List 반환 예시1")
	@Test
	public void ex01() {

		System.out.println("\n - ex01 - \n");
		List<ProductDTO> productList = m2d.ex01();
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
	}

	@DisplayName("DTO List 반환 예시2")
	@Test
	public void ex02() {

		System.out.println("\n - ex02 - \n");
		List<BrandDTO> brands = m2d.ex02();
		for (BrandDTO brandDTO : brands) {
			System.out.println(brandDTO);
		}
	}

	@DisplayName("DTO 반환 예시1")
	@Test
	public void ex03() {

		System.out.println("\n - ex03 - \n");
		ProductDTO productDTO = m2d.ex03();
		System.out.println(productDTO);
	}

	@DisplayName("DTO 반환 예시2")
	@Test
	public void ex04() {

		System.out.println("\n - ex04 - \n");
		BrandDTO brandDTO = m2d.ex04();
		System.out.println(brandDTO);
	}

	@DisplayName("단일데이터 반환 예시1")
	@Test
	public void ex05() {

		System.out.println("\n - ex05 - \n");
		int count = m2d.ex05();
		System.out.println(count);
	}

	@DisplayName("단일데이터 반환 예시2")
	@Test
	public void ex06() {

		System.out.println("\n - ex06 - \n");
		double avg = m2d.ex06();
		System.out.println(avg);
	}

	@DisplayName("단일데이터 반환 예시3")
	@Test
	public void ex07() {

		System.out.println("\n - ex07 - \n");
		String productNm = m2d.ex07();
		System.out.println(productNm);
	}

	@DisplayName("<![CDATA[]]> 사용예시")
	@Test
	public void ex08() {

		System.out.println("\n - ex01 - \n");
		List<ProductDTO> productList = m2d.ex01();
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
	}

	@DisplayName("map 사용예시")
	@Test
	public void ex09() {

		System.out.println("\n - ex09 - \n");
		List<Map<String, Object>> resultMaps = m2d.ex09();
		for (Map<String, Object> resultMap : resultMaps) {
			System.out.println(resultMap);
		}
	}

	@DisplayName("resultMap 사용예시")
	@Test
	public void ex10() {

		System.out.println("\n - ex10 - \n");
		List<Map<String, Object>> resultMapList = m2d.ex10();

		for (Map<String, Object> resultMap : resultMapList) {
			System.out.println(resultMap);
		}
	}

	@DisplayName("resultMap 사용예시")
	@Test
	public void ex11() {

		System.out.println("\n - ex11 - \n");
		System.out.println("\n - ex11 - \n");
		List<Map<String,Object>> resultMapList = m2d.ex11();
		
		for (Map<String, Object> resultMap : resultMapList) {
			System.out.println(resultMap);
		}
	}
}
