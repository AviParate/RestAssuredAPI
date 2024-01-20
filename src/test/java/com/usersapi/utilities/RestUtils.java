package com.usersapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String userName() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return("Morpheus"+generatedString);
	}
	
	public static String userJob() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return("Leader"+generatedString);
	}
	
/*	public static String empAge() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return(generatedString);
	}*/

}
