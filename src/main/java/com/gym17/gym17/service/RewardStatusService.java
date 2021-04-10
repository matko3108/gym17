package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.RewardStatus;
import src.main.java.com.gym17.gym17.repositories.RewardStatusRepository;

@Service
public class RewardStatusService {
	private RewardStatusRepository RewardStatusRepository;

	@Autowired
	public RewardStatusService(RewardStatusRepository RewardStatusRepository) {
		this.RewardStatusRepository = RewardStatusRepository;
	}
	public Iterable<RewardStatus> list() {
		Iterable<RewardStatus> userCollection = RewardStatusRepository.findAll();
		return userCollection;
	}

	public Optional<RewardStatus> findById(int parseInt) {
		return RewardStatusRepository.findById(parseInt);
	}
	public RewardStatus findByName(String activityType) {
		return RewardStatusRepository.findByName(activityType);

	}

}
