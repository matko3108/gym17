package src.main.java.com.gym17.gym17.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.User;

@RepositoryRestResource(exported = false)
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	
	@Query("SELECT t FROM User t WHERE t.username = :username") 
	User findByUsername1(@Param("username") String username);
	
	@Query("SELECT t FROM User t WHERE t.id = :id")
	Optional<User> findById(@Param("id") int id);
	
	@Query("SELECT t FROM User t")
	List<User> findAll();

	//update je save iz CrudRepository<T, ID>
	// delete je save iz CrudRepository<T, ID>
}