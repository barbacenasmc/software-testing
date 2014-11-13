package com.miscellaneous.test;

public class FunctionTester {

	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

	}

}
