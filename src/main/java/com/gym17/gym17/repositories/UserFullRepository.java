package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.model.UserFull;

@RepositoryRestResource(exported = false)
@Repository
public interface UserFullRepository extends JpaRepository<UserFull, Integer> {

	@Query(value = "SELECT * FROM User t WHERE (t.email = :userByEmail OR t.phone = :userByEmail) AND t.fk_user_type = 1", nativeQuery = true)
	Optional<UserFull> findByEmail(@Param("userByEmail") String userByEmail);

}
