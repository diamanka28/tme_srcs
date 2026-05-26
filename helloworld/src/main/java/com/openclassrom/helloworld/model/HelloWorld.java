package com.openclassrom.helloworld.model;

public class HelloWorld {
	
	private String value = "Hello World!!";
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String val) {
		this.value = val;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
