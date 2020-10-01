package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.PrivateCoachWeekdays;
import src.main.java.com.gym17.gym17.repositories.PrivateCoachWeekdaysRepository;

@Service
public class PrivateCoachWeekdaysService {
	private PrivateCoachWeekdaysRepository PrivateCoachWeekdaysRepository;

	@Autowired
	public PrivateCoachWeekdaysService(PrivateCoachWeekdaysRepository PrivateCoachWeekdaysRepository) {
		this.PrivateCoachWeekdaysRepository = PrivateCoachWeekdaysRepository;
	}
	public Iterable<PrivateCoachWeekdays> list() {
		Iterable<PrivateCoachWeekdays> PrivateCoachWeekdaysCollection = PrivateCoachWeekdaysRepository.findAll();
		return PrivateCoachWeekdaysCollection;
	}

	public Optional<PrivateCoachWeekdays> findById(int parseInt) {
		return PrivateCoachWeekdaysRepository.findById(parseInt);
	}
	
	public PrivateCoachWeekdays savePrivateCoachWeekdays(PrivateCoachWeekdays data) {
		return PrivateCoachWeekdaysRepository.save(data);
	}
	public void delete(PrivateCoachWeekdays PrivateCoachWeekdays) {
		PrivateCoachWeekdaysRepository.delete(PrivateCoachWeekdays);				
	}

}