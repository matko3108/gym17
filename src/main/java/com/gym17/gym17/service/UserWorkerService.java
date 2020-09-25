package src.main.java.com.gym17.gym17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.UserWorkerList;
import src.main.java.com.gym17.gym17.repositories.UserWorkerListRepository;

@Service
public class UserWorkerService {
	private UserWorkerListRepository UserWorkerListRepository;

	@Autowired
	public UserWorkerService(UserWorkerListRepository UserWorkerListRepository) {
		this.UserWorkerListRepository = UserWorkerListRepository;
	}
	public Iterable<UserWorkerList> list() {
		Iterable<UserWorkerList> userCollection = UserWorkerListRepository.findAll();
		return userCollection;
	}

	/*
	 * public Optional<UserWorker> findById(int parseInt) { return
	 * UserWorkerRepository.findById(parseInt); }
	 * 
	 * public void delete(UserWorker UserWorker) {
	 * UserWorkerRepository.delete(UserWorker);
	 * 
	 * }
	 * 
	 * public UserWorker updateUserWorker(UserWorker data) { return
	 * UserWorkerRepository.save(data);
	 * 
	 * }
	 */

}
