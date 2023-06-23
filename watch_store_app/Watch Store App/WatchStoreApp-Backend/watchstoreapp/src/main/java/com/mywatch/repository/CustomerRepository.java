package com.mywatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywatch.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
