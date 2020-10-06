package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.UserWorkerWorkerRights;
import src.main.java.com.gym17.gym17.repositories.UserWorkerWorkerRightsRepository;

@Service
public class UserWorkerWorkerRightsService {
	private UserWorkerWorkerRightsRepository UserWorkerWorkerRightsRepository;

	@Autowired
	public UserWorkerWorkerRightsService(UserWorkerWorkerRightsRepository UserWorkerWorkerRightsRepository) {
		this.UserWorkerWorkerRightsRepository = UserWorkerWorkerRightsRepository;
	}
	public Iterable<UserWorkerWorkerRights> list() {
		Iterable<UserWorkerWorkerRights> UserWorkerWorkerRightsCollection = UserWorkerWorkerRightsRepository.findAll();
		return UserWorkerWorkerRightsCollection;
	}

	public Optional<UserWorkerWorkerRights> findById(int parseInt) {
		return UserWorkerWorkerRightsRepository.findById(parseInt);
	}
	
	public UserWorkerWorkerRights saveUserWorkerWorkerRights(UserWorkerWorkerRights data) {
		return UserWorkerWorkerRightsRepository.save(data);
	}
	public void delete(UserWorkerWorkerRights UserWorkerWorkerRights) {
		UserWorkerWorkerRightsRepository.delete(UserWorkerWorkerRights);				
	}

}