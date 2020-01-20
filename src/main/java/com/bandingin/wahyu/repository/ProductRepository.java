package com.bandingin.wahyu.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.bandingin.wahyu.model.Product;

public interface ProductRepository extends DataTablesRepository<Product, Integer>{

}
