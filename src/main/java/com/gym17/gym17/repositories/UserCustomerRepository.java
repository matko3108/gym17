package src.main.java.com.gym17.gym17.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.UserCustomer;


@RepositoryRestResource(exported = false)
@Repository
public interface UserCustomerRepository extends JpaRepository<UserCustomer, Integer> {

	@Query(value = "SELECT uc.id FROM user u JOIN user_customer uc ON u.id = uc.id WHERE u.email <> '' OR u.phone <> ''", nativeQuery = true)
	List<Integer> findValidCustomers();


}