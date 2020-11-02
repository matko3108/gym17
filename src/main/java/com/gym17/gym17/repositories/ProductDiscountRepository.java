package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.com.gym17.gym17.model.PrivateCoach;
import src.main.java.com.gym17.gym17.model.ProductDiscount;

@RepositoryRestResource(exported = false)
@Repository
public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Integer> {
	
	@Query(value = "SELECT fk_product FROM product_discount", nativeQuery = true)
	Iterable<Integer> findAllProducts();

	@Modifying
    @Transactional 
	@Query(value = "DELETE FROM product_discount WHERE valid_to < NOW() AND valid_to IS NOT NULL", nativeQuery = true)
	void deleteOldEntety();
}