package com.bandingin.wahyu.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bandingin.wahyu.model.Product;
import com.bandingin.wahyu.service.ProductService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin(origins="*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/list/products")
	@JsonView(DataTablesOutput.View.class)
	public DataTablesOutput<Product> listAll(@Valid DataTablesInput input){
		return productService.listAll(input);	
	}
	@GetMapping("/products")
	public Iterable<Product> getAll(){
		return productService.getAll();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getById(@PathVariable("id") Integer id){
		return productService.getById(id);
	}
	
	@PostMapping("/product")
	public Product insert(@RequestBody Product product) {
		return productService.insert(product);
	}
	
	@PutMapping("/product/{id}")
	public Product update(@PathVariable("id") Integer id, @RequestBody Product product) {
		return productService.update(id, product);
	}
	
	@DeleteMapping("//{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return productService.delete(id);
	}
}
