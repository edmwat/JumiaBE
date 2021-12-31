package com.edward.jumiaExercise.models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component 
public class ValidationRegex {
	
	private Map<String,CountryCodes> regexMap;
	
	public ValidationRegex() {
		regexMap = new HashMap<String,CountryCodes>();
		regexMap.put("Cameroon", new CountryCodes("(237)","\\(237\\)\\ ?[2368]\\d{7,8}$"));
		regexMap.put("Ethiopia", new CountryCodes("(251)","\\(251\\)\\ ?[1-59]\\d{8}$"));
		regexMap.put("Morocco", new CountryCodes("(212)","\\(212\\)\\ ?[5-9]\\d{8}$"));
		regexMap.put("Mozambique", new CountryCodes("(258)","\\(258\\)\\ ?[28]\\d{7,8}$"));
		regexMap.put("Uganda", new CountryCodes("(256)","\\(256\\)\\ ?\\d{9}$"));		
	}
	
	public Map<String,CountryCodes> getRegexMap(){
		return regexMap;
	}

}
