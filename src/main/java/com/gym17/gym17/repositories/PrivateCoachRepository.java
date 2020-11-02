package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.PrivateCoach;
import src.main.java.com.gym17.gym17.model.User;

@RepositoryRestResource(exported = false)
@Repository
public interface PrivateCoachRepository extends JpaRepository<PrivateCoach, Integer> {

	@Query(value = "SELECT * FROM private_coach t WHERE t.fk_customer = :parseInt", nativeQuery = true)
	Iterable<PrivateCoach> findByCustomer(@Param("parseInt") int parseInt);

	@Query(value = "SELECT * FROM private_coach WHERE end IS NOT NULL AND end < NOW()", nativeQuery = true)
	Iterable<PrivateCoach> getOldEntety();
}