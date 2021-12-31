package com.edward.jumiaExercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edward.jumiaExercise.models.Customer;

@Repository 
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	@Query(value="select id,name,phone from customer where phone like ?%",nativeQuery = true)
	List<Customer> findCustomersByCountry(String countryCode);
	
}
