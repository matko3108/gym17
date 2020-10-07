package src.main.java.com.gym17.gym17.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.gym17.gym17.model.Group;
import src.main.java.com.gym17.gym17.model.GroupCustomer;
import src.main.java.com.gym17.gym17.model.Product;
import src.main.java.com.gym17.gym17.model.ProductDiscount;
import src.main.java.com.gym17.gym17.model.ProductType;
import src.main.java.com.gym17.gym17.model.UserCustomer;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.response.ResponseStatus;
import src.main.java.com.gym17.gym17.service.MembershipFeeTypeService;
import src.main.java.com.gym17.gym17.service.ProductService;
import src.main.java.com.gym17.gym17.service.ProductTypeService;
import src.main.java.com.gym17.gym17.service.ProductDiscountService;


@RestController
@RequestMapping("")
public class ProductController {
	@Autowired
	private ProductTypeService ProductTypeService;
	@Autowired
	private ProductDiscountService ProductDiscountService;

	
	private ProductService ProductService;

	@Autowired
	public ProductController(ProductService ProductService) {
		this.ProductService = ProductService;
	}

	@GetMapping("/v1/product/list")
	public Iterable<Product> list() {
		Iterable<Product> Product = ProductService.list();
		return Product;
	}

	@GetMapping(path = "/v1/product/{Product}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("Product") String Product) {
		Optional<Product> org = ProductService.findById(Integer.parseInt(Product));
		if (org == null) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.ACTIVITY_NOT_FOUND));
		}

		return ResponseEntity.ok().body(org.get());
	}
	

	@DeleteMapping("/v1/product/{Product}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("Product") String Product) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<Product> org = ProductService.findById(Integer.parseInt(Product));
		if (!org.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		ProductService.delete(org.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
	
	
	@GetMapping("/v1/productType/list")
	public Iterable<ProductType> ProductTypelist() {
		Iterable<ProductType> ProductType = ProductTypeService.list();
		return ProductType;
	}

	@GetMapping(path = "/v1/productType/{productType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByIdProductType(@PathVariable("productType") String productType) {
		Optional<ProductType> org = ProductTypeService.findById(Integer.parseInt(productType));
		if (org == null) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.ACTIVITY_NOT_FOUND));
		}

		return ResponseEntity.ok().body(org.get());
	}
	
	@PostMapping("/v1/productDiscount")
	public ResponseEntity<Object> saveproductDiscount(@RequestBody ProductDiscount data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<Product> Product = ProductService.findById(data.getProduct().getId());
		data.setProduct(Product.get());
		ProductDiscount ProductDiscount = ProductDiscountService.saveProductDiscount(data);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		Optional<Product> Productnew = ProductService.findById(ProductDiscount.getProduct().getId());
		return ResponseEntity.ok().body(Productnew.get());
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	
	@PostMapping("/v1/product")
	public ResponseEntity<Object> saveproduct(@RequestBody Product data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<ProductType> ProductType = ProductTypeService.findById(Integer.parseInt(productType));

		data.setProductType(ProductType.get());
		Product Productnew = ProductService.saveProduct(data);
		return ResponseEntity.ok().body(Productnew);
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	
	
	@DeleteMapping("/v1/productDiscount/{productDiscount}")
	public ResponseEntity<Object> deleteproductDiscount(@PathVariable("productDiscount") String productDiscount) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<ProductDiscount> ProductDiscount = ProductDiscountService.findById(Integer.parseInt(productDiscount));
		if (!ProductDiscount.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		ProductDiscountService.delete(ProductDiscount.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
	
}