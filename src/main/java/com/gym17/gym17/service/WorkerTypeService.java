package src.main.java.com.gym17.gym17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.WorkerRights;
import src.main.java.com.gym17.gym17.model.WorkerType;
import src.main.java.com.gym17.gym17.repositories.WorkerTypeRepository;

@Service
public class WorkerTypeService {
	private WorkerTypeRepository WorkerTypeRepository;

	@Autowired
	public WorkerTypeService(WorkerTypeRepository WorkerTypeRepository) {
		this.WorkerTypeRepository = WorkerTypeRepository;
	}
	
	public  Iterable<WorkerType> list() {
		Iterable<WorkerType> WorkerTypeCollection = WorkerTypeRepository.findAll();
		return WorkerTypeCollection;
	}
}
