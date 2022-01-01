package com.edward.jumiaExercise.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.edward.jumiaExercise.models.Customer;

@DataJpaTest  
class CustomerRepoTest {
	@Autowired 
	private CustomerRepo customerRepo;

	@Test
	void itShouldReturnCustomersInAGivenCountryCode() {
		
		//given
		
		Customer c1 = new Customer();
		c1.setId(31);
		c1.setName("EMILE CHRISTIAN KOUKOU DIKANDA HONORE");
		c1.setPhone("(237) 697151594");				
		customerRepo.save(c1);
		
		Customer c2 = new Customer();
		c1.setId(32);
		c1.setName("ARREYMANYOR ROLAND TABOT");
		c1.setPhone("(237) 6A0311634");				
		customerRepo.save(c2);
		
		Customer c3 = new Customer();
		c1.setId(33);
		c1.setName("Frehiwot Teka");
		c1.setPhone("(251) 988200000");				
		customerRepo.save(c3);
		
		//when
		
		List<Customer> customers = customerRepo.findCustomersByCountry("(237)");
		
		
		//then
		assertThat(customers.stream().filter(c -> 
			c.getName().equals("EMILE CHRISTIAN KOUKOU DIKANDA HONORE")).findFirst().isPresent()).isTrue();	
	}

}
