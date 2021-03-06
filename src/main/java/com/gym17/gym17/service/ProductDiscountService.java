package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.PrivateCoach;
import src.main.java.com.gym17.gym17.model.ProductDiscount;
import src.main.java.com.gym17.gym17.repositories.ProductDiscountRepository;

@Service
public class ProductDiscountService {
	private ProductDiscountRepository ProductDiscountRepository;

	@Autowired
	public ProductDiscountService(ProductDiscountRepository ProductDiscountRepository) {
		this.ProductDiscountRepository = ProductDiscountRepository;
	}
	public Iterable<ProductDiscount> list() {
		Iterable<ProductDiscount> ProductDiscountCollection = ProductDiscountRepository.findAll();
		return ProductDiscountCollection;
	}

	public Optional<ProductDiscount> findById(int parseInt) {
		return ProductDiscountRepository.findById(parseInt);
	}
	
	public ProductDiscount saveProductDiscount(ProductDiscount data) {
		return ProductDiscountRepository.save(data);
	}
	public void delete(ProductDiscount ProductDiscount) {
		ProductDiscountRepository.delete(ProductDiscount);				
	}
	
	public Iterable<Integer> listProductId() {
		Iterable<Integer> ProductDiscountCollection = ProductDiscountRepository.findAllProducts();
		return ProductDiscountCollection;
	}
	public void deleteOldEntety() {
		// TODO Auto-generated method stub
		ProductDiscountRepository.deleteOldEntety();
	}
	
	

}