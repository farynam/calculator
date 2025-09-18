package com.example.demo;

import com.example.demo.input.ArgsParser;

public class DemoApplication {

	public static void main(String[] args) {
		
		String expr = "3 / -2 + 1 + 1 + 1";

		ArgsParser argsParser = new ArgsParser();
	
		argsParser.parse(expr);

		System.out.println(argsParser.parse(expr).execute());
	}

}
