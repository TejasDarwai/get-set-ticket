package com.mywatch.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywatch.entity.Company;
import com.mywatch.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyRestController {
	
	@Autowired
	private CompanyService service;
	
	@GetMapping
	public List<Company> findAll(){
		return this.service.findAll();
	}

}
