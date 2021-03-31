package src.main.java.com.gym17.gym17.service;

import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.model.UserCustomer;
//import src.main.java.com.gym17.gym17.model.ModelUtilities;
import src.main.java.com.gym17.gym17.model.UserData;
import src.main.java.com.gym17.gym17.model.UserFull;
import src.main.java.com.gym17.gym17.model.UserType;
import src.main.java.com.gym17.gym17.model.UserWorker;
import src.main.java.com.gym17.gym17.model.UserWorkerData;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.com.gym17.gym17.repositories.UserRepository;
import src.main.java.com.gym17.gym17.repositories.UserCustomerRepository;
import src.main.java.com.gym17.gym17.repositories.UserTypeRepository;
import src.main.java.com.gym17.gym17.repositories.UserFullRepository;




@Service
public class UserService {
	private UserRepository UserRepository;
	@Autowired
	private UserCustomerRepository UserCustomerRepository;
	@Autowired
	private UserTypeRepository UserTypeRepository;
	@Autowired
	private UserFullRepository UserFullRepository;
	


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
			user.setUserType(UserTypeRepository.findById(11).get());

			user.setUserWorker(new UserWorker(user));
			//user.setUserType(UserTypeRepository.);
			UserRepository.save(user);
			user.setPassword(null);
			return user;
			
		}else {
			User user = UserRepository.save(data.getUser());
			user.setUserType(UserTypeRepository.findById(1).get());

			user.setUserCustomer(new UserCustomer(user));
			UserRepository.save(user);
			user.setPassword(null);
			return 	user;
		}
		}
	
	public User saveUserCredentials(User data) {
			User user = UserRepository.save(data);
			return user;
		
		}
	

	public User saveNewUserWorker(UserWorkerData userdata) {
		
			User user = UserRepository.save(userdata.getUser());
			user.setUserType(UserTypeRepository.findById(11).get());
			user.setUserWorker(new UserWorker(user, userdata.getWorkerType()));
			//user.setUserType(UserTypeRepository.);
			UserRepository.save(user);
			user.setPassword(null);
			return user;
			
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
		Iterable<User> userCollection = UserRepository.findlistWorkers();
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
		User NewUser = fillnewUser(newuser, olduser.get());
		User saveduser = UserRepository.save(NewUser);
		saveduser.setPassword(null);
		return saveduser;
	}

	private User fillnewUser(User newuser, User user) {
		user.setName(newuser.getName());
		user.setLastname(newuser.getLastname());
		user.setEmail(newuser.getEmail());
		user.setPhone(newuser.getPhone());
		user.getAddress().setAddressLine(newuser.getAddress().getAddressLine());
		user.getAddress().setCity(newuser.getAddress().getCity());
		user.getAddress().setCountry(newuser.getAddress().getCountry());
		user.getAddress().setZip(newuser.getAddress().getZip());

		return user;
		
	}

	public Optional<UserFull> findByEmail(String userByEmail) {
		Optional<UserFull> optOrg = UserFullRepository.findByEmail(userByEmail);
		return optOrg;

	}
	
}