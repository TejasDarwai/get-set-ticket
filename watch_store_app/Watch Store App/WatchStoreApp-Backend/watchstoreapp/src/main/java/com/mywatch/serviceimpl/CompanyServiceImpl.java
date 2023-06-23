package com.mywatch.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywatch.entity.Company;
import com.mywatch.repository.CompanyRepository;
import com.mywatch.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository repo;

	@Override
	public List<Company> findAll() {
		return this.repo.findAll();
	}

}
