package com.mywatch.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywatch.entity.Customer;
import com.mywatch.repository.CustomerRepository;
import com.mywatch.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public Customer save(Customer c) {
		Customer tempCustomer = new Customer();
		tempCustomer.setEmailId(c.getEmailId());
		tempCustomer.setPassword(c.getPassword());
		tempCustomer.setFirstName(c.getFirstName());
		tempCustomer.setLastName(c.getLastName());
		tempCustomer.setRole("ROLE_NORMAL");
		tempCustomer.setInCart(",");
		tempCustomer.setInCartNo(0);
		return this.repo.save(tempCustomer);
	}

	@Override
	public Customer findByUsername(String emailId) {
		return this.repo.findById(emailId).get();
	}

	@Override
	public List<Customer> findAllUser() {
		return this.repo.findAll();
	}

	@Override
	public Customer update(Customer c) {
		return this.repo.save(c);
	}

	
}
