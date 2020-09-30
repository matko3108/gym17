package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.MembershipFeeType;
import src.main.java.com.gym17.gym17.model. Token;

@RepositoryRestResource(exported = false)
@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	@Query("SELECT t FROM Token t WHERE t.licenceName = :licenceName") 
	Optional<Token> findByLicence(@Param("licenceName") String licenceName);

}