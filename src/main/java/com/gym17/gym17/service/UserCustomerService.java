package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.model.UserCustomer;
import src.main.java.com.gym17.gym17.model.UserCustomerList;
import src.main.java.com.gym17.gym17.repositories.UserCustomerListRepository;
import src.main.java.com.gym17.gym17.repositories.UserRepository;
import src.test.java.com.gym17.gym17.UserListCustomer;
import src.main.java.com.gym17.gym17.repositories.UserCustomerRepository;


@Service
public class UserCustomerService {
	private UserCustomerListRepository UserCustomerListRepository;
	@Autowired
	private UserCustomerRepository UserCustomerRepository;


	@Autowired
	public UserCustomerService(UserCustomerListRepository UserCustomerListRepository) {
		this.UserCustomerListRepository = UserCustomerListRepository;
	}
	public Iterable<UserListCustomer> list() {
		Iterable<UserListCustomer> userCollection = UserCustomerListRepository.listCustomer();
		return userCollection;
	}

	
	  public Optional<UserCustomer> findById(int parseInt) { return
	  UserCustomerRepository.findById(parseInt); }
	  /* 
	 * public void delete(UserCustomer userCustomer) {
	 * UserCustomerRepository.delete(userCustomer);
	 * 
	 * }
	 * 
	 * public UserCustomer updateUserCustomer(UserCustomer data) { return
	 * UserCustomerRepository.save(data);
	 * 
	 * }
	 */

}
