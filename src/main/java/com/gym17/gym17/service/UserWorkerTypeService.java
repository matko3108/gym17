package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.WorkerType;
import src.main.java.com.gym17.gym17.repositories.WorkerTypeRepository;

@Service
public class UserWorkerTypeService {
	private WorkerTypeRepository UserWorkerTypeRepository;

	@Autowired
	public UserWorkerTypeService(WorkerTypeRepository UserWorkerTypeRepository) {
		this.UserWorkerTypeRepository = UserWorkerTypeRepository;
	}
	public Iterable<WorkerType> list() {
		Iterable<WorkerType> UserWorkerTypeCollection = UserWorkerTypeRepository.findAll();
		return UserWorkerTypeCollection;
	}

	public Optional<WorkerType> findById(int parseInt) {
		return UserWorkerTypeRepository.findById(parseInt);
	}
	
	public WorkerType saveUserWorkerType(WorkerType data) {
		return UserWorkerTypeRepository.save(data);
	}
	public void delete(WorkerType UserWorkerType) {
		UserWorkerTypeRepository.delete(UserWorkerType);				
	}

}