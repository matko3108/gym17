package src.main.java.com.gym17.gym17.service;

//import src.main.java.com.gym17.gym17.model.ModelUtilities;
import src.main.java.com.gym17.gym17.model.User;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.com.gym17.gym17.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository UserRepository;

	@Autowired
	public UserService(UserRepository UserRepository) {
		this.UserRepository = UserRepository;
	}

	public User findByUsername1(String username) {
		User User = UserRepository.findByUsername1(username);
		User.setPassword(null);
		return User;
	}

	public Iterable<User> list() {
		Iterable<User> orgCollection = UserRepository.findAll();
		Iterator<User> iter = orgCollection.iterator();
		while (iter.hasNext()) {
			iter.next().setPassword(null);
		}
		return orgCollection;
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
		User User = UserRepository.findByUsername1(username);
		if (User != null) {
			if (User.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}