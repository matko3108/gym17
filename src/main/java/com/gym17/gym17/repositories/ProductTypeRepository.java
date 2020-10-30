package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.ProductType;
import src.main.java.com.gym17.gym17.model.User;

@RepositoryRestResource(exported = false)
@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

	@Query(value = "SELECT * FROM product_type t WHERE t.name = :productByType", nativeQuery = true)
	Optional<ProductType> findByName(@Param("productByType") String productByType);
}