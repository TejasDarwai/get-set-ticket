package com.mywatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywatch.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
