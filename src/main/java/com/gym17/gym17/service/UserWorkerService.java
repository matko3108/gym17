package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.UserWorkerList;
import src.main.java.com.gym17.gym17.model.UserWorker;
import src.main.java.com.gym17.gym17.repositories.UserCustomerRepository;
import src.main.java.com.gym17.gym17.repositories.UserWorkerListRepository;
import src.main.java.com.gym17.gym17.repositories.UserWorkerRepository;
import src.main.java.com.gym17.gym17.repositories.WorkerTypeRepository;


@Service
public class UserWorkerService {
	private UserWorkerListRepository UserWorkerListRepository;
	@Autowired
	private UserWorkerRepository UserWorkerRepository;
	@Autowired
	private WorkerTypeRepository WorkerTypeRepository;
	
	@Autowired
	public UserWorkerService(UserWorkerListRepository UserWorkerListRepository) {
		this.UserWorkerListRepository = UserWorkerListRepository;
	}
	public Iterable<UserWorker> list() {
		Iterable<UserWorker> userCollection = UserWorkerRepository.findAll();
		return userCollection;
	}

	
	  public Optional<UserWorker> findById(int parseInt) { return
	  UserWorkerRepository.findById(parseInt); }
	  /*
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
	public Iterable<UserWorker> coachlist() {
		// TODO Auto-generated method stub
		Iterable<UserWorker> userCollection = UserWorkerRepository.findCoaches();
		return userCollection;
		}

}
