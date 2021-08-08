package com.products.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.main.model.Product;
import com.products.main.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
	public void saveData(Product product) {
		repo.save(product);
	}
	
	public List<Product> showAll(){
		return repo.findAll();
	}
	
	public Product getOne(Integer id) {
		return repo.findById(id).get();
	}
	
	public void deleteData(int id) {
		repo.deleteById(id);
	}
	
	public Product updatePrice(int id, float newPrice) {
		Product pro = repo.findById(id).get();
		pro.setPrice(newPrice);
		repo.save(pro);
		return pro;
	}
	
	public Product updateName(int id, String newName) {
		Product pro = repo.findById(id).get();
		pro.setName(newName);
		repo.save(pro);
		return pro;
	}
	
	public Product updateId(int id, int newId) {
		Product pro = repo.findById(id).get();
		pro.setId(newId);
		repo.save(pro);
		return pro;
	}
}
