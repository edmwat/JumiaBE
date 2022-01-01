package com.edward.jumiaExercise.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.edward.jumiaExercise.models.CountryCodes;
import com.edward.jumiaExercise.models.Customer;
import com.edward.jumiaExercise.models.ValidationRegex;
import com.edward.jumiaExercise.repository.CustomerRepo;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {
	@Autowired
	private CustomerRepo customerRepo;
		 
	private boolean phoneNumberValid;
	private CountryCodes countryCodes;
	
	@BeforeEach
    public void setUp() throws Exception {
		ValidationRegex validationRegex = new ValidationRegex();		
		countryCodes = (CountryCodes) validationRegex.getRegexMap().get("Cameroon");
    }

	@Test
	void testIfItReturnsAvalidPhonenumber() {
		//Given
		Customer c1 = new Customer();
		c1.setId(31);
		c1.setName("EMILE CHRISTIAN KOUKOU DIKANDA HONORE");
		c1.setPhone("(237) 697151594");				
		customerRepo.save(c1);
		
		//When
		customerRepo.findCustomersByCountry(countryCodes.getCode()).forEach(cust ->{			 
			Pattern pattern = Pattern.compile(countryCodes.getPattern(), Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(cust.getPhone());
		    boolean matchFound = matcher.find();
		    if(matchFound) {
		    	phoneNumberValid=true;
		    }else {
		    	phoneNumberValid = false;
		    }
		});
		
		//Then
		assertThat(phoneNumberValid).isTrue();
	}
	
	@Test
	void testIfItReturnsAnIvalidPhonenumber() {
		//Given
		Customer c1 = new Customer();
		c1.setId(33);
		c1.setName("ARREYMANYOR ROLAND TABOT");
		c1.setPhone("(237) 6A0311634");				
		customerRepo.save(c1);
		
		//When
		customerRepo.findCustomersByCountry(countryCodes.getCode()).forEach(cust ->{
			 
			Pattern pattern = Pattern.compile(countryCodes.getPattern(), Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(cust.getPhone());
		    boolean matchFound = matcher.find();
		    if(matchFound) {
		    	phoneNumberValid=true;
		    }else {
		    	phoneNumberValid = false;
		    }
		});
		
		//Then
		assertThat(phoneNumberValid).isFalse();
	}

}
