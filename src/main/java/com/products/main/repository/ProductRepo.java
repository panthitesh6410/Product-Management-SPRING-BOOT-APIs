package com.products.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.main.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
}
