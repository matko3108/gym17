package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.ActivityList;
import src.main.java.com.gym17.gym17.repositories.ActivityListRepository;

@Service
public class ActivityListService {
	private ActivityListRepository ActivityListRepository;

	@Autowired
	public ActivityListService(ActivityListRepository ActivityListRepository) {
		this.ActivityListRepository = ActivityListRepository;
	}
	public Iterable<ActivityList> list() {
		Iterable<ActivityList> userCollection = ActivityListRepository.findAll();
		return userCollection;
	}

	public Optional<ActivityList> findById(int parseInt) {
		return ActivityListRepository.findById(parseInt);
	}
	public ActivityList save(ActivityList activityList) {
		return ActivityListRepository.save(activityList);
		// TODO Auto-generated method stub
		
	}

}
