package com.application.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.mvc.chapter04_dynamicQuery.DynamicQueryDAO;
import com.application.mvc.data.BrandDTO;
import com.application.mvc.data.ProductDTO;

@SpringBootTest
public class DynamicQueryTest {

	@Autowired
	private DynamicQueryDAO dynamicQueryDAO;

	@Test
	@DisplayName("if 사용예시")
	public void ifEx() {
		
		System.out.println("\n --- ifEx --- \n");
		
		Map<String,Object> searchMap = new HashMap<String, Object>();
//		searchMap.put("searchKeyword", "enrollDt");
//		searchMap.put("searchWord" , "2022");
		searchMap.put("searchKeyword", "productNm");
		searchMap.put("searchWord" , "삼성전자");
		
		List<ProductDTO> productList = dynamicQueryDAO.ifEx(searchMap);
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
		
	}

	// [ when ] 사용예시
	@Test
	@DisplayName("when 사용예시")
	public void whenEx() {
		
		System.out.println("\n --- whenEx --- \n");
		
		Map<String,Object> searchMap = new HashMap<String, Object>();
//		searchMap.put("searchKeyword", "enrollDt");
//		searchMap.put("searchWord" , "2022");
		searchMap.put("searchKeyword", "productNm");
		searchMap.put("searchWord" , "삼성전자");
		
		List<ProductDTO> productList = dynamicQueryDAO.whenEx(searchMap);
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
		
	}

	
	@Test
	@DisplayName("otherwise 사용예시")
	public void otherwiseEx() {
		
		System.out.println("\n --- otherwiseEx --- \n");
		
		//int deliveryPrice = 0;
		int deliveryPrice = 3000;
		
		List<ProductDTO> productList = dynamicQueryDAO.otherwiseEx(deliveryPrice);
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
		
		
	}

	
	@Test
	@DisplayName("[ foreach ] insert 사용예시")
	public void foreachEx01() {
		
		System.out.println("\n --- foreachEx01 --- \n");
		
		List<BrandDTO> brandList = new ArrayList<BrandDTO>();
		
		for (int i = 111; i <= 120; i++) { // 111 ~ 120 , 121 ~ 130으로 변경하며 테스트 
			
			BrandDTO brandDTO = new BrandDTO();
			brandDTO.setBrandId(i);
			brandDTO.setBrandNm("추가된브랜드" + i);
			brandDTO.setEnteredDt(new Date());
			brandDTO.setActiveYn("Y");
			
			brandList.add(brandDTO);
			
		}
		
		dynamicQueryDAO.foreachEx01(brandList);
		
	}

	
	@Test
	@DisplayName("[ foreach ] select 사용예시")
	public void foreachEx02() {
		
		System.out.println("\n --- foreachEx02 --- \n");
		
		long[] brandIdList = {1 , 2 , 3};
		
		List<BrandDTO> brandList = dynamicQueryDAO.foreachEx02(brandIdList);
		for (BrandDTO brandDTO : brandList) {
			System.out.println(brandDTO);
		}
		
		
	}

	
	@Test
	@DisplayName("[ foreach ] delete 사용예시")
	public void foreachEx03() {
		
		System.out.println("\n --- foreachEx03 --- \n");
		long[] brandIdList = {111 , 112 , 113 , 114 , 115 };
		
		dynamicQueryDAO.foreachEx03(brandIdList);
		
	}

	
	@Test
	@DisplayName("[ foreach ] update 사용예시1")
	public void foreachEx04() {
		
		System.out.println("\n --- foreachEx04 --- \n");
		
		long[] productIdList = {1 , 2 , 3 , 4 , 5 , 6};
		dynamicQueryDAO.foreachEx04(productIdList);
		
	}
	
	
	
	@Test
	@DisplayName("[ foreach ] update 사용예시2")
	public void foreachEx05() {
		
		System.out.println("\n --- foreachEx05 --- \n");
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(); 
		
		for (int i = 1; i < 11; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productId" , i);
			map.put("addPrice" , 100 * i);
			mapList.add(map);
		}
		
		dynamicQueryDAO.foreachEx05(mapList);
	}
	

	@Test
	@DisplayName("[ where ] 사용예시")
	public void whereEx() {
		
		System.out.println("\n --- whereEx --- \n");
		/*
		
			# 실습환경
			
			시나리오 1) productNm과 brandId가 모두 있을 경우  > success
			시나리오 2) productNm만 있을 경우 				  > success
			시나리오 3) brandId만 있을 경우 				  > error
		
		 */

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNm("삼성");
		productDTO.setBrandId(1);
		
		List<ProductDTO> productList = dynamicQueryDAO.whereEx(productDTO);
		for(ProductDTO productDTO2 : productList) {
			System.out.println(productDTO2);
		}
	}

	
	@Test
	@DisplayName("[ set ] 사용예시")
	public void setEx() {

		System.out.println("\n --- setEx --- \n");
		
		/*
		
			# 실습환경
			
			시나리오 1) price와 deliveryPrice가 모두 있을 경우  > success
			시나리오 2) price만 있을 경우 				  		> error
			시나리오 3) deliveryPrice만 있을 경우 				> success
	
		 */
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPrice(1);
		productDTO.setDeliveryPrice(1);
		
		dynamicQueryDAO.setEx(productDTO);
	}
	
}
