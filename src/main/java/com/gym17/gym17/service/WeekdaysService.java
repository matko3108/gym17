package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.Weekdays;
import src.main.java.com.gym17.gym17.repositories.WeekdaysRepository;

@Service
public class WeekdaysService {
	private WeekdaysRepository WeekdaysRepository;

	@Autowired
	public WeekdaysService(WeekdaysRepository WeekdaysRepository) {
		this.WeekdaysRepository = WeekdaysRepository;
	}
	public Iterable<Weekdays> list() {
		Iterable<Weekdays> WeekdaysCollection = WeekdaysRepository.findAll();
		return WeekdaysCollection;
	}

	public Optional<Weekdays> findById(int parseInt) {
		return WeekdaysRepository.findById(parseInt);
	}
	
	public Weekdays saveWeekdays(Weekdays data) {
		return WeekdaysRepository.save(data);
	}
	public void delete(Weekdays Weekdays) {
		WeekdaysRepository.delete(Weekdays);				
	}

}