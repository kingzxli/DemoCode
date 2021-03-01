package com.king;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private DemoCode demoCode;

	@Test
	void contextLoads() {
		List<String> result =  demoCode.letterCombinations("23");
		System.out.println(result);
		
	}

}
