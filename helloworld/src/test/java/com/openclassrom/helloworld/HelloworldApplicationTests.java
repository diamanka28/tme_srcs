package com.openclassrom.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrom.helloworld.model.HelloWorld;
import com.openclassrom.helloworld.service.BusinessService;

@SpringBootTest
class HelloworldApplicationTests {

	@Autowired
	BusinessService bs;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testHelloworld() {
		
		String expected = "Hello World!!";
		String result = bs.getHelloWorld().getValue();
		
		HelloWorld hw=bs.getHelloWorld();
		
		assertEquals(expected, result);
		System.out.println(hw);
	}
}
