package com.mywatch.rest.controller;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywatch.entity.Product;
import com.mywatch.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<Product> findAllProducts(){
		return this.service.findAll();
	}
	
	@GetMapping("/latest/{latest}")
    public List<Product> findLatestProducts(@PathVariable int latest){
		return this.service.findLatestProducts(latest);
	}
	
	@GetMapping("/company/{cId}")
    public List<Product> findProductsByCompanyID(@PathVariable int cId){
		return this.service.findProductsByCompanyID(cId);
	}
	
	@GetMapping("/smart/{smart}")
    public List<Product> findSmartProducts(@PathVariable int smart){
		return this.service.findSmartProducts(smart);
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> findByID(@PathVariable int id)
    {
        Product product= this.service.findById(id);
        ResponseEntity<Product> entity=new ResponseEntity<>(product,HttpStatus.OK);
        return entity;
    }
    
	
}
