package src.main.java.com.gym17.gym17.service;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.LuckyReward;
import src.main.java.com.gym17.gym17.repositories.LuckyRewardRepository;
import src.main.java.com.gym17.gym17.repositories.RewardStatusRepository;


@Service
public class LuckyRewardService {
	private LuckyRewardRepository LuckyRewardRepository;
	
	@Autowired
	private RewardStatusRepository RewardStatusRepository;
	
	@Autowired
	public LuckyRewardService(LuckyRewardRepository LuckyRewardRepository) {
		this.LuckyRewardRepository = LuckyRewardRepository;
	}
	
	public Iterable<LuckyReward> list() {
		Iterable<LuckyReward> LuckyRewardCollection = LuckyRewardRepository.findAll();
		return LuckyRewardCollection;
	}
	
	public Optional<LuckyReward> findById(int parseInt) {
		return LuckyRewardRepository.findById(parseInt);
	}
	
	public LuckyReward saveLuckyReward(LuckyReward data) {
		return LuckyRewardRepository.save(data);
	}
	public void delete(LuckyReward LuckyReward) {
		LuckyRewardRepository.delete(LuckyReward);				
	}
	public Optional<LuckyReward> findByCustomer(int parseInt) {
		return LuckyRewardRepository.findByCustomer(parseInt);
	}
	public Iterable<LuckyReward> getOldEntety() {
		return LuckyRewardRepository.getOldEntety();

	}
	public void deleteOldEntety(Iterable<LuckyReward> luckyrewards) {		
		for(LuckyReward luckyReward: luckyrewards){
			luckyReward.setRewardStatus(RewardStatusRepository.findById(21).get());	
			LuckyRewardRepository.save(luckyReward);
		}
	}

	public Optional<LuckyReward> findByCode(String randomString) {
		// TODO Auto-generated method stub
		return LuckyRewardRepository.findByCode(randomString);
	}
}
