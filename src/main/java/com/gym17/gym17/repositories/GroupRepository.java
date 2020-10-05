package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.Group;

@RepositoryRestResource(exported = false)
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
	
	@Query("SELECT t FROM Group t WHERE t.id = :id") 
	Optional<Group> findByIdnew(@Param("id") Integer id);


}