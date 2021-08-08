package com.products.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.products.main.model.Product;
import com.products.main.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/addProduct")
	@ResponseBody
	public Product addProduct(Product product) {
		service.saveData(product);
		return product;
	}
	
	@GetMapping("/products")
	@ResponseBody
	public List<Product> products(){
		return service.showAll();
	}
	
	@GetMapping("/product/{id}")
	@ResponseBody
	public Product product(@PathVariable("id") int id) {
		return service.getOne(id);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id") int id) {
		service.deleteData(id);
		return "Record ID = "+id+" deleted successfully";
	}
	
	@PutMapping("/updatePrice/id/price")
	@ResponseBody
	public Product updatePrice(@PathVariable("id") int id, @PathVariable("price") float price) {
		return service.updatePrice(id, price);
	}
	
	@PutMapping("/updateName/id/name")
	@ResponseBody
	public Product updateName(@PathVariable("id") int id, @PathVariable("name") String name) {
		return service.updateName(id, name);
	}
	
	@PutMapping("/updatePrice/id/newId")
	@ResponseBody
	public Product updateId(@PathVariable("id") int id, @PathVariable("newId") int newId) {
		return service.updatePrice(id, newId);
	}
}
