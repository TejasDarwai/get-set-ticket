package com.mywatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mywatch.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	// JPQL
	@Query(value = "SELECT p FROM Product p WHERE isLatestProduct=:l")
	List<Product> findLatestProducts(@Param("l") int l);
	
	@Query(value = "SELECT p FROM Product p WHERE companyId=:cId")
	List<Product> findCompanyProducts(@Param("cId") int cId);
	
	@Query(value = "SELECT p FROM Product p WHERE isSmartWatchProduct=:smart")
	List<Product> findSmartProducts(@Param("smart") int smart);
	
	
//	SELECT e
//	FROM employee e
//	WHERE department='ABC'


}
