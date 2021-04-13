package src.main.java.com.gym17.gym17.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.com.gym17.gym17.model.CustomerMembershipFee;
import src.main.java.com.gym17.gym17.model.LuckyReward;

@RepositoryRestResource(exported = false)
@Repository
public interface CustomerMembershipFeeRepository extends JpaRepository<CustomerMembershipFee, Integer> {

	@Modifying
    @Transactional 
	@Query(value = "DELETE FROM customer_membership_fee WHERE end_date < NOW()", nativeQuery = true)
	void deleteOldEntety();

	@Query(value = "SELECT * FROM customer_membership_fee WHERE fk_user = :fkuser AND fk_membership_fee = :fkmembershipfee AND start_date = :startdate AND end_date = :enddate LIMIT 1", nativeQuery = true)
	Optional<CustomerMembershipFee> checkCustomerMembershipFee(@Param("fkuser") int fkuser, @Param("fkmembershipfee") int fkmembershipfee, @Param("startdate") String startdate, @Param("enddate") String enddate );

}