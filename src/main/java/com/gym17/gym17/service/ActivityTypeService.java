package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.ActivityType;
import src.main.java.com.gym17.gym17.repositories.ActivityTypeRepository;

@Service
public class ActivityTypeService {
	private ActivityTypeRepository ActivityTypeRepository;

	@Autowired
	public ActivityTypeService(ActivityTypeRepository ActivityTypeRepository) {
		this.ActivityTypeRepository = ActivityTypeRepository;
	}
	public Iterable<ActivityType> list() {
		Iterable<ActivityType> userCollection = ActivityTypeRepository.findAll();
		return userCollection;
	}

	public Optional<ActivityType> findById(int parseInt) {
		return ActivityTypeRepository.findById(parseInt);
	}
	public ActivityType findByName(String activityType) {
		return ActivityTypeRepository.findByName(activityType);

	}

}
