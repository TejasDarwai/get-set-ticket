package com.mywatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mywatch.serviceimpl.CustomerUserDetailService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WatchStoreAppSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
//	@Autowired
//	private CustomerUserDetailService customerUserDetailService;
//	
	
	@Autowired
	CustomerUserDetailService service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//auth.userDetailsService(customerUserDetailService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(service);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() 						.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/api/customer/registercustomer").permitAll()
		.antMatchers(HttpMethod.POST, "/api/customer/login").permitAll()
																	
		.antMatchers("/api/customer/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/product/**").permitAll()
		.antMatchers(HttpMethod.OPTIONS, "/**") 	
		.permitAll()
		.antMatchers(HttpMethod.GET, "/api/company").permitAll()	
		.anyRequest()
		.authenticated()
		.and().httpBasic();
		
	}
	

}
