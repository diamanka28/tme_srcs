package com.openclassrom.helloworld.service;

import org.springframework.stereotype.Component;

import com.openclassrom.helloworld.model.HelloWorld;

@Component
public class BusinessService {

	public HelloWorld getHelloWorld() {
		HelloWorld val = new HelloWorld();
		return val;
		
	}
}
