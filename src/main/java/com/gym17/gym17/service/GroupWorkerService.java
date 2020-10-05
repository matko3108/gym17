package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.GroupWorker;
import src.main.java.com.gym17.gym17.repositories.GroupWorkerRepository;

@Service
public class GroupWorkerService {
	private GroupWorkerRepository GroupWorkerRepository;

	@Autowired
	public GroupWorkerService(GroupWorkerRepository GroupWorkerRepository) {
		this.GroupWorkerRepository = GroupWorkerRepository;
	}
	public Iterable<GroupWorker> list() {
		Iterable<GroupWorker> GroupWorkerCollection = GroupWorkerRepository.findAll();
		return GroupWorkerCollection;
	}

	public Optional<GroupWorker> findById(int parseInt) {
		return GroupWorkerRepository.findById(parseInt);
	}
	
	public GroupWorker saveGroupWorker(GroupWorker data) {
		return GroupWorkerRepository.saveAndFlush(data);
	}
	public void delete(GroupWorker GroupWorker) {
		GroupWorkerRepository.delete(GroupWorker);				
	}

}