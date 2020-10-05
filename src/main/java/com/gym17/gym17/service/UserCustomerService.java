package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.model.UserCustomer;
import src.main.java.com.gym17.gym17.model.UserCustomerList;
import src.main.java.com.gym17.gym17.repositories.UserCustomerListRepository;
import src.main.java.com.gym17.gym17.repositories.UserRepository;
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
	public Iterable<UserCustomerList> list() {
		Iterable<UserCustomerList> userCollection = UserCustomerListRepository.findAll();
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
