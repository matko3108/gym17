package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.ProductType;
import src.main.java.com.gym17.gym17.repositories.ProductTypeRepository;

@Service
public class ProductTypeService {
	private ProductTypeRepository ProductTypeRepository;

	@Autowired
	public ProductTypeService(ProductTypeRepository ProductTypeRepository) {
		this.ProductTypeRepository = ProductTypeRepository;
	}
	public Iterable<ProductType> list() {
		Iterable<ProductType> ProductTypeCollection = ProductTypeRepository.findAll();
		return ProductTypeCollection;
	}

	public Optional<ProductType> findById(int parseInt) {
		return ProductTypeRepository.findById(parseInt);
	}
	
	public ProductType saveProductType(ProductType data) {
		return ProductTypeRepository.save(data);
	}
	public void delete(ProductType ProductType) {
		ProductTypeRepository.delete(ProductType);				
	}

}