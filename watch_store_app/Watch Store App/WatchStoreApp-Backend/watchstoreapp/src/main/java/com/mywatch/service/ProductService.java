package com.mywatch.service;

import java.util.List;

import com.mywatch.entity.Product;

public interface ProductService {

	List<Product> findAll();

	List<Product> findLatestProducts(int latest);

	List<Product> findProductsByCompanyID(int cId);

	List<Product> findSmartProducts(int smart);
	
	Product findById(int id);
}
