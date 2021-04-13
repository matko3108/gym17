package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.PrivateCoachStatus;
import src.main.java.com.gym17.gym17.repositories.PrivateCoachStatusRepository;

@Service
public class PrivateCoachStatusService {
	private PrivateCoachStatusRepository PrivateCoachStatusRepository;

	@Autowired
	public PrivateCoachStatusService(PrivateCoachStatusRepository PrivateCoachStatusRepository) {
		this.PrivateCoachStatusRepository = PrivateCoachStatusRepository;
	}
	public Iterable<PrivateCoachStatus> list() {
		Iterable<PrivateCoachStatus> userCollection = PrivateCoachStatusRepository.findAll();
		return userCollection;
	}

	public Optional<PrivateCoachStatus> findById(int parseInt) {
		return PrivateCoachStatusRepository.findById(parseInt);
	}


}