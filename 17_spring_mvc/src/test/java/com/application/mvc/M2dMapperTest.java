package com.application.mvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.application.mvc.chapter03_mybatis.M2D;
import com.application.mvc.data.ProductDTO;

@SpringBootTest
public class M2dMapperTest {
	
	@Autowired
	private M2D m2d;
	
	@Test
	public void ex01() {
		
		System.out.println("\n - ex01 - \n");
		List<ProductDTO> productList = m2d.ex01();
		for (ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
	}
}
