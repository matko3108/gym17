package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.GroupWeekdays;
import src.main.java.com.gym17.gym17.repositories.GroupWeekDaysRepository;

@Service
public class GroupWeekDaysService {
	private GroupWeekDaysRepository GroupWeekDaysRepository;

	@Autowired
	public GroupWeekDaysService(GroupWeekDaysRepository GroupWeekdaysRepository) {
		this.GroupWeekDaysRepository = GroupWeekdaysRepository;
	}
	public Iterable<GroupWeekdays> list() {
		Iterable<GroupWeekdays> GroupWeekdaysCollection = GroupWeekDaysRepository.findAll();
		return GroupWeekdaysCollection;
	}

	public Optional<GroupWeekdays> findById(int parseInt) {
		return GroupWeekDaysRepository.findById(parseInt);
	}
	
	public GroupWeekdays saveGroupWeekdays(GroupWeekdays data) {
		return GroupWeekDaysRepository.save(data);
	}
	public void delete(GroupWeekdays GroupWeekdays) {
		GroupWeekDaysRepository.delete(GroupWeekdays);				
	}

}