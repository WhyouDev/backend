package com.bandingin.wahyu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bandingin.wahyu.exception.ResourceNotFoundException;
import com.bandingin.wahyu.model.Product;
import com.bandingin.wahyu.repository.ProductRepository;

@Service("productService")
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public Iterable<Product> getAll(){
		return productRepository.findAll();
	}
	
	public DataTablesOutput<Product> listAll(DataTablesInput input){
		return productRepository.findAll(input);
	}
	
	public Product insert(Product product) {
		return productRepository.save(product);
	}
	public Optional<Product> getById(Integer id){
		return productRepository.findById(id);
	}
	
	public Product update(Integer id, Product product) {
		Product pr = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Data not found", "id", id));
		pr.setProduct_name(product.getProduct_name());
		pr.setProduct_price(product.getProduct_price());
		pr.setProduct_detail(product.getProduct_detail());
		pr.setUpdate_by(product.getUpdate_by());
		pr.setProduct_date(product.getProduct_date());
		Product update = productRepository.save(pr);
		return update;
	}
	
	public ResponseEntity<?> delete(Integer id){
		productRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
