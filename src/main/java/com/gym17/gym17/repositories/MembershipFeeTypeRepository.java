package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.MembershipFeeType;
import src.main.java.com.gym17.gym17.model.User;

@RepositoryRestResource(exported = false)
@Repository
public interface MembershipFeeTypeRepository extends JpaRepository<MembershipFeeType, Integer> {

	@Query("SELECT t FROM MembershipFeeType t WHERE t.externalid = :externalId") 
	Optional<MembershipFeeType> findByIdExternalId(String externalId);
}