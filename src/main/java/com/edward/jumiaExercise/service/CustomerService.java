package com.edward.jumiaExercise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.edward.jumiaExercise.models.CountryCodes;
import com.edward.jumiaExercise.models.Customer;
import com.edward.jumiaExercise.models.ValidationRegex;
import com.edward.jumiaExercise.repository.CustomerRepo;

@Service 
public class CustomerService {
	 
	private CustomerRepo customerRepo;
	private ValidationRegex validationRegex;
	
	public CustomerService(CustomerRepo customerRepo,ValidationRegex validationRegex) {
		this.customerRepo = customerRepo;
		this.validationRegex = validationRegex;		
	}
	
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll(); 
	}
	public List<Customer> getCustomersInCountry(String country,String state){
		CountryCodes countryCode = (CountryCodes) validationRegex.getRegexMap().get(country);
		List<Customer> validCustomerList = new ArrayList<>();
		List<Customer> invalidCustomerList = new ArrayList<>();
		
		customerRepo.findCustomersByCountry(countryCode.getCode()).forEach(cust ->{
			
			Pattern pattern = Pattern.compile(countryCode.getPattern(), Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(cust.getPhone());
		    boolean matchFound = matcher.find();
		    
		    if(matchFound) {
		    	validCustomerList.add(cust);
		    }else {
		    	invalidCustomerList.add(cust);
		    }			
		});
		if(state.equalsIgnoreCase("valid")) {
			return validCustomerList;
		}else {
			return invalidCustomerList;
		}
	}
}

