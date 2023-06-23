package com.mywatch.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywatch.entity.Product;
import com.mywatch.repository.ProductRepository;
import com.mywatch.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> findAll() {
		return this.repo.findAll();
	}

	@Override
	public List<Product> findLatestProducts(int latest) {
		return this.repo.findLatestProducts(latest);
	}

	@Override
	public List<Product> findProductsByCompanyID(int cId) {
		return this.repo.findCompanyProducts(cId);
	}

	@Override
	public List<Product> findSmartProducts(int smart) {
		return this.repo.findSmartProducts(smart);
	}

	@Override
	public Product findById(int id) {
		return this.repo.findById(id).get();
	}

}
