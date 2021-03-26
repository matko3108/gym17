package src.main.java.com.gym17.gym17.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.model.UserCustomerList;
import src.main.java.com.gym17.gym17.model.UserListCustomer;

@RepositoryRestResource(exported = false)
@Repository
public interface UserCustomerListRepository extends JpaRepository<User, Integer> {


	@Query(value = "SELECT id, name, lastname, email, phone,externalid FROM user t WHERE t.fk_user_type = 1", nativeQuery = true)
	List<UserListCustomer> listCustomer();
	

}