package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.Group;
import src.main.java.com.gym17.gym17.repositories.GroupRepository;

@Service
public class GroupService {
	private GroupRepository GroupRepository;

	@Autowired
	public GroupService(GroupRepository GroupRepository) {
		this.GroupRepository = GroupRepository;
	}
	public Iterable<Group> list() {
		Iterable<Group> groupCollection = GroupRepository.findAll();
		return groupCollection;
	}

	public Optional<Group> findById(int parseInt) {
		return GroupRepository.findById(parseInt);
	}
	
	public Group saveGroup(Group data) {
		return GroupRepository.save(data);
	}
	public void delete(Group group) {
		GroupRepository.delete(group);				
	}

}