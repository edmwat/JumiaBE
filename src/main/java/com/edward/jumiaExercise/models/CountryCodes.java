package com.edward.jumiaExercise.models;

public class CountryCodes {
	private String code;
	private String pattern;
	
	public CountryCodes(String code,String pattern) {
		this.code = code;
		this.pattern = pattern;		
	}
	
	public String getPattern() {
		return pattern;
	}
	public String getCode() {
		return code;
	}

}
