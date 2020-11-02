package src.main.java.com.gym17.gym17.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.com.gym17.gym17.model.CustomerMembershipFee;

@RepositoryRestResource(exported = false)
@Repository
public interface CustomerMembershipFeeRepository extends JpaRepository<CustomerMembershipFee, Integer> {

	@Modifying
    @Transactional 
	@Query(value = "DELETE FROM customer_membership_fee WHERE end_date < NOW()", nativeQuery = true)
	void deleteOldEntety();

}