package com.mywatch.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mywatch.entity.Customer;
import com.mywatch.entity.CustomerDetail;
import com.mywatch.repository.CustomerRepository;

@Service
public class CustomerUserDetailService implements UserDetailsService{

	@Autowired
	private CustomerServiceImpl repo;
	// Following method will be automatically executed by spring security
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Inside load User by username");
		Customer customer = repo.findByUsername(username); 		// Fetching user from database 
		if(customer==null) {
			throw new UsernameNotFoundException(username); 	// If not found, throwing exception
		}
		String userRoles = customer.getRole();  	// These are roles are comming from database 
															// These roles are associated with the user who are currently logged in.
		// In the following approach, roles are hardcoded here
//		org.springframework.security.core.userdetails.User authenticatedUser = 
//				new org.springframework.security.core.userdetails.User(username, "{noop}"+
//																		foundUser.getPassword(),
//																		AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_HR"));
//		
		
		org.springframework.security.core.userdetails.User authenticatedUser = 
				new org.springframework.security.core.userdetails.User(username, "{noop}"+
																		customer.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_HR"));
		return authenticatedUser; 		// returning authenticated user object fetched form the database 
	}
	
	

}
