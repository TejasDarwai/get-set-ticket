package com.mywatch.service;

import java.util.List;

import com.mywatch.entity.Customer;

public interface CustomerService {

	Customer save(Customer c);

	Customer findByUsername(String emailId);

	List<Customer> findAllUser();

	Customer update(Customer c);

	

}
