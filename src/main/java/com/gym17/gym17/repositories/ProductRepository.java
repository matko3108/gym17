package src.main.java.com.gym17.gym17.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.Product;
import src.main.java.com.gym17.gym17.model.User;

@RepositoryRestResource(exported = false)
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "SELECT * FROM product t WHERE t.fk_type = :id", nativeQuery = true)
	Iterable<Product> findByTypeId(@Param("id") int id);
	
}