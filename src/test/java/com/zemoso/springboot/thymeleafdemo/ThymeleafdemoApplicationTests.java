package com.zemoso.springboot.thymeleafdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ThymeleafdemoApplicationTests {

	Calculator c = new Calculator();

	@Test
	void contextLoads() {
	}

	@Test
	void testSum(){
		int expectedResult = 39;

		int actualResult = c.doSum(12,13,14);

		assertThat(actualResult).isEqualTo(expectedResult);


	}
	@Test
	@Disabled
	void testProduct(){
		int expectedResult = 199040;
		int actualResult = c.doproduct(20,32,311);
		assertThat(actualResult).isEqualTo(expectedResult);

	}

	@Test
	void testCompareNums(){
		Boolean actualResult = c.compareTwoNums(3,3);
		assertThat(actualResult).isTrue();
	}

}
