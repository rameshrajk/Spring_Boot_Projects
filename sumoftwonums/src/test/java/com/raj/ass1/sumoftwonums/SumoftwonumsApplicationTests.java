package com.raj.ass1.sumoftwonums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

@SpringBootTest
class SumoftwonumsApplicationTests {

	@Autowired
	private SumofTwoNums summer;
	
	@Test
	void testDependencyInjection() {		
		System.out.println(summer.sum(1, 2));
	}

}
