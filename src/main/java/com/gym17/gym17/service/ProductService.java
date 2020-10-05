package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.Product;
import src.main.java.com.gym17.gym17.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository ProductRepository;

	@Autowired
	public ProductService(ProductRepository ProductRepository) {
		this.ProductRepository = ProductRepository;
	}
	public Iterable<Product> list() {
		Iterable<Product> ProductCollection = ProductRepository.findAll();
		return ProductCollection;
	}

	public Optional<Product> findById(int parseInt) {
		return ProductRepository.findById(parseInt);
	}
	
	public Product saveProduct(Product data) {
		return ProductRepository.save(data);
	}
	public void delete(Product Product) {
		ProductRepository.delete(Product);				
	}

}