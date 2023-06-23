package com.mywatch.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mywatch.entity.Customer;
import com.mywatch.service.CustomerService;

@RestController
@RequestMapping("/api/customer") 	// This is a common portion of url applicable to all the methods in the class.
public class CustomerRestController {
	@Autowired
	private CustomerService service;


	@GetMapping
	public List<Customer> findAll(){
		return this.service.findAllUser();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> findById(@PathVariable String userId) {
		Customer customer = this.service.findByUsername(userId);
		ResponseEntity<Customer> entity = new ResponseEntity<>(customer, HttpStatus.OK);
		return entity;
	}

	
	@PostMapping("/registercustomer")
	public ResponseEntity<?> createNewAccount(@RequestBody Customer c) {
		try {
			Customer customer = this.service.save(c);
			ResponseEntity<Customer> entity = new ResponseEntity<>(customer, HttpStatus.CREATED);
			return entity;
		}catch(Exception e) {
			ResponseEntity<String> entity = new ResponseEntity<String>("User already existed", HttpStatus.BAD_REQUEST);
			return entity;
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer c) {
		try {
			Customer customer = this.service.update(c);
			ResponseEntity<Customer> entity = new ResponseEntity<>(customer, HttpStatus.CREATED);
			return entity;
		}catch(Exception e) {
			ResponseEntity<String> entity = new ResponseEntity<String>("User already existed", HttpStatus.BAD_REQUEST);
			return entity;
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> performLogin(@RequestBody Customer c){
		Customer foundCustomer = this.service.findByUsername(c.getEmailId()); 	// Fetch user object from database 
		 																// using the username sent by the client
		if(foundCustomer.getPassword().equals(c.getPassword())){ 			// Check the password sent by user and password from database.
			ResponseEntity<String> entity = new ResponseEntity<String>("Success", HttpStatus.OK);
			return entity;
		}
		else {
			ResponseEntity<String> entity = new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
			return entity;
		}
	}
	
}


