package src.main.java.com.gym17.gym17.service;

import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.model.UserCustomer;
//import src.main.java.com.gym17.gym17.model.ModelUtilities;
import src.main.java.com.gym17.gym17.model.UserData;
import src.main.java.com.gym17.gym17.model.UserType;
import src.main.java.com.gym17.gym17.model.UserWorker;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.com.gym17.gym17.repositories.UserRepository;
import src.main.java.com.gym17.gym17.repositories.UserCustomerRepository;
import src.main.java.com.gym17.gym17.repositories.UserTypeRepository;



@Service
public class UserService {
	private UserRepository UserRepository;
	private UserCustomerRepository UserCustomerRepository;
	private UserTypeRepository UserTypeRepository;


	@Autowired
	public UserService(UserRepository UserRepository) {
		this.UserRepository = UserRepository;
	}

	public Optional<User> findByUsername1(String username) {
		Optional<User> User = UserRepository.findByUsername1(username);
		return User;
	}

	public Iterable<User> list() {
		Iterable<User> userCollection = UserRepository.findAll();
		return userCollection;
	}

	public Optional<User> findById(int id) {
		Optional<User> optOrg = UserRepository.findById(id);
		if (optOrg.isPresent()) {
			optOrg.get().setPassword(null);
		}
		return optOrg;
	}
	/*
	 * public void delete(int idUser) { Consumer<User> consumer = (x) ->
	 * x.setDeleted(ModelUtilities.getDateTime()); performAction(idUser, consumer);
	 * }
	 * 
	 * public void delete(User User) { delete(User.getId()); }
	 * 
	 * public void update(User User, User data) { update(User.getId(), data); }
	 * 
	 * public void update(int idUser, User data) { Consumer<User> consumer = (x) ->
	 * { x.updateFields(data); x.setUpdated(ModelUtilities.getDateTime()); };
	 * performAction(idUser, consumer); }
	 */

	private void performAction(int idUser, Consumer<User> consumer) {
		Optional<User> orgOptional = findById(idUser);
		if (orgOptional.isPresent()) {
			User User = orgOptional.get();
			consumer.accept(User);
			UserRepository.save(User);

		} else {
			throw new IllegalArgumentException(
					String.format("User with provided idUser=[%s] not found!", idUser));
		}
	}

	public boolean authenticate(String username, String password) {
		//User User = UserRepository.findByUsername1(username);
		//if (User != null) {
		//	if (User.getPassword().equals(password)) {
			////	return true;
			//}
		//}
		return false;
	}

	public User saveNewUser(UserData data) {
		
		if(data.getUserType().equals("WORKER")) {
			User user = UserRepository.save(data.getUser());
			user.setUserWorker(new UserWorker(user));
			//user.setUserType(UserTypeRepository.);
			UserRepository.save(user);
			user.setPassword(null);
			return user;
			
		}else {
			User user = UserRepository.save(data.getUser());
			user.setUserCustomer(new UserCustomer(user));
			UserRepository.save(user);
			user.setPassword(null);
			return 	user;
		}
		}
	
	public User updateUser(User user) {
		 User updateduser = UserRepository.save(user);
		 updateduser.setPassword(null);
		 return updateduser;
	}

	public void delete(User user) {
		 UserRepository.delete(user);		
	}

	public Iterable<User> customerlist() {
		Iterable<User> userCollection = UserRepository.findlistByType(1);
		return userCollection;
	}

	public Iterable<User> workerlist() {
		Iterable<User> userCollection = UserRepository.findlistByType(11);
		return userCollection;
	}

	public Optional<User> findByExternalId(String externalId) {
		Optional<User> optOrg = UserRepository.findByIdExternalId(externalId);
		//if (optOrg.isPresent()) {
		//	optOrg.get().setPassword(null);
		//}
		return optOrg;
	}

	public User updateExternalUser(User newuser, Optional<User> olduser) {
		// TODO Auto-generated method stub
		return null;
	}
	
}