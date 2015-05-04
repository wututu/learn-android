package com.example.jnidemo;

public class FirstJNI {
		
	static{		
		System.loadLibrary("firstjni");
	}
	
	public native String sayHello();

}
