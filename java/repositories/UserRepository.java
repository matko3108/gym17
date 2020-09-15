package java.repositories;


import java.model.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	
	@Query("SELECT t FROM User t WHERE t.username = :username AND t.deleted IS NULL") 
	User findByUsername1(@Param("username") String username);
	
	@Query("SELECT t FROM User t WHERE t.id = :id AND t.deleted IS NULL")
	Optional<User> findById(@Param("id") int id);
	
	@Query("SELECT t FROM User t WHERE t.deleted IS NULL")
	List<User> findAll();

	//update je save iz CrudRepository<T, ID>
	// delete je save iz CrudRepository<T, ID>
}