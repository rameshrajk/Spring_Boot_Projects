package com.raj.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringjmsApplicationTests {
	
	@Autowired
	MessageSender sender;

	@Test
	void testSendAndReceive() {
		sender.send("Hello Spring JMS!");
	}

}
