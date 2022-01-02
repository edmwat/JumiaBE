package com.edward.jumiaExercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edward.jumiaExercise.models.Customer;
import com.edward.jumiaExercise.service.CustomerService;

@RestController
@RequestMapping("/phone")
@CrossOrigin(origins = {"http://localhost:4200","https://deploymenttest-313512.uc.r.appspot.com","http://localhost:4000"})
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok().body(customerService.getAllCustomers());
	}
	@GetMapping("{country}/{state}")
	public ResponseEntity<List<Customer>> getCustomersInCountry(
			@PathVariable("country") String country,
			@PathVariable("state") String state
			) {
		return ResponseEntity.ok().body(customerService.getCustomersInCountry(country,state));
	}

}
