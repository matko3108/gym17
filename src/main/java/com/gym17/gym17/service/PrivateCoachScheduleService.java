package src.main.java.com.gym17.gym17.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.main.java.com.gym17.gym17.model.LuckyReward;
import src.main.java.com.gym17.gym17.model.PrivateCoachSchedule;
import src.main.java.com.gym17.gym17.repositories.PrivateCoachScheduleRepository;
import src.main.java.com.gym17.gym17.repositories.PrivateCoachStatusRepository;

@Service
public class PrivateCoachScheduleService {
	@Autowired
	private PrivateCoachStatusRepository PrivateCoachStatusRepository;
	
	private PrivateCoachScheduleRepository PrivateCoachScheduleRepository;

	@Autowired
	public PrivateCoachScheduleService(PrivateCoachScheduleRepository PrivateCoachScheduleRepository) {
		this.PrivateCoachScheduleRepository = PrivateCoachScheduleRepository;
	}
	public Iterable<PrivateCoachSchedule> list() {
		Iterable<PrivateCoachSchedule> PrivateCoachScheduleCollection = PrivateCoachScheduleRepository.findAll();
		return PrivateCoachScheduleCollection;
	}

	public Optional<PrivateCoachSchedule> findById(int parseInt) {
		return PrivateCoachScheduleRepository.findById(parseInt);
	}
	
	public PrivateCoachSchedule savePrivateCoachSchedule(PrivateCoachSchedule data) {
		return PrivateCoachScheduleRepository.save(data);
	}
	public void delete(PrivateCoachSchedule PrivateCoachSchedule) {
		PrivateCoachScheduleRepository.delete(PrivateCoachSchedule);				
	}
	public Iterable<PrivateCoachSchedule> findByCustomer(int parseInt) {
		return PrivateCoachScheduleRepository.findByCustomer(parseInt);
	}
	public Iterable<PrivateCoachSchedule> getOldEntety() {
		return PrivateCoachScheduleRepository.getOldEntety();

	}
	public void deleteOldEntety(Iterable<PrivateCoachSchedule> privateCoachs) {
		// TODO Auto-generated method stub
		PrivateCoachScheduleRepository.deleteAll(privateCoachs);
		
	}
	public Iterable<PrivateCoachSchedule> listofFree() {
		Iterable<PrivateCoachSchedule> PrivateCoachScheduleCollection = PrivateCoachScheduleRepository.findFree();
		return PrivateCoachScheduleCollection;
	}
	public void clearOldEntety(Iterable<PrivateCoachSchedule> privateCoachSchedulelist) {
		for(PrivateCoachSchedule privateCoachSchedule: privateCoachSchedulelist){
			privateCoachSchedule.setEnd(null);
			privateCoachSchedule.setStart(null);
			privateCoachSchedule.setUserCustomer(null);
			privateCoachSchedule.setPrivateCoachStatus(PrivateCoachStatusRepository.findById(1).get());
			PrivateCoachScheduleRepository.save(privateCoachSchedule);
		}		
	}

}