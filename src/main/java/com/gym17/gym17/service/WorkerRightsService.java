package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.WorkerRights;
import src.main.java.com.gym17.gym17.repositories.WorkerRightsRepository;

@Service
public class WorkerRightsService {
	private WorkerRightsRepository WorkerRightsRepository;

	@Autowired
	public WorkerRightsService(WorkerRightsRepository WorkerRightsRepository) {
		this.WorkerRightsRepository = WorkerRightsRepository;
	}
	public Iterable<WorkerRights> list() {
		Iterable<WorkerRights> WorkerRightsCollection = WorkerRightsRepository.findAll();
		return WorkerRightsCollection;
	}

	public Optional<WorkerRights> findById(int parseInt) {
		return WorkerRightsRepository.findById(parseInt);
	}
	
	public WorkerRights saveWorkerRights(WorkerRights data) {
		return WorkerRightsRepository.save(data);
	}
	public void delete(WorkerRights WorkerRights) {
		WorkerRightsRepository.delete(WorkerRights);				
	}

}