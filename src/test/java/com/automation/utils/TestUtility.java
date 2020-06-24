package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class TestUtility {

	
	static RequestSpecification req;
	static Properties prop;
	FileInputStream fis;
	public RequestSpecification requestBuilder() throws IOException {
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).
				addFilter(RequestLoggingFilter.logRequestTo(log)).
				addFilter(ResponseLoggingFilter.logResponseTo(log)).
				addQueryParam("key","qaclick123").build();
		return req;
		}
		return req;
	}
	
	public String getGlobalValue(String key) throws IOException {
		
		prop = new Properties();
		fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\RADemo\\src\\main\\resources\\Config\\configurationFile.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
}
