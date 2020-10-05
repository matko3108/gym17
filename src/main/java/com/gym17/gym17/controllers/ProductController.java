package src.main.java.com.gym17.gym17.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.gym17.gym17.model.Product;
import src.main.java.com.gym17.gym17.service.ProductService;

@RestController
@RequestMapping("")
public class ProductController {


	private ProductService ProductService;

	@Autowired
	public ProductController(ProductService ProductService) {
		this.ProductService = ProductService;
	}

	@GetMapping("/v1/Product/list")
	public Iterable<Product> list() {
		Iterable<Product> Product = ProductService.list();
		return Product;
	}

	
}