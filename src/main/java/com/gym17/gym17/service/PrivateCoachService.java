package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.PrivateCoach;
import src.main.java.com.gym17.gym17.repositories.PrivateCoachRepository;

@Service
public class PrivateCoachService {
	private PrivateCoachRepository PrivateCoachRepository;

	@Autowired
	public PrivateCoachService(PrivateCoachRepository PrivateCoachRepository) {
		this.PrivateCoachRepository = PrivateCoachRepository;
	}
	public Iterable<PrivateCoach> list() {
		Iterable<PrivateCoach> PrivateCoachCollection = PrivateCoachRepository.findAll();
		return PrivateCoachCollection;
	}

	public Optional<PrivateCoach> findById(int parseInt) {
		return PrivateCoachRepository.findById(parseInt);
	}
	
	public PrivateCoach savePrivateCoach(PrivateCoach data) {
		return PrivateCoachRepository.save(data);
	}
	public void delete(PrivateCoach PrivateCoach) {
		PrivateCoachRepository.delete(PrivateCoach);				
	}
	public Iterable<PrivateCoach> findByCustomer(int parseInt) {
		return PrivateCoachRepository.findByCustomer(parseInt);
	}

}