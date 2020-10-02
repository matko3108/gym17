package src.main.java.com.gym17.gym17.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.gym17.gym17.model.PrivateCoach;
import src.main.java.com.gym17.gym17.model.PrivateCoachWeekday;
import src.main.java.com.gym17.gym17.model.PrivateCoachWeekdays;
import src.main.java.com.gym17.gym17.model.Weekdays;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.response.ResponseStatus;
import src.main.java.com.gym17.gym17.service.PrivateCoachService;
import src.main.java.com.gym17.gym17.service.PrivateCoachWeekdaysService;
import src.main.java.com.gym17.gym17.service.WeekdaysService;


@RestController
@RequestMapping("")
public class PrivateCoachController {

	@Autowired
	private PrivateCoachWeekdaysService PrivateCoachWeekdaysService;
	@Autowired
	private WeekdaysService WeekdaysService;
	private PrivateCoachService PrivateCoachService;

	@Autowired
	public PrivateCoachController(PrivateCoachService PrivateCoachService) {
		this.PrivateCoachService = PrivateCoachService;
	}

	@GetMapping("/v1/PrivateCoach/list")
	public Iterable<PrivateCoach> list() {
		Iterable<PrivateCoach> PrivateCoach = PrivateCoachService.list();
		return PrivateCoach;
	}
	
	@GetMapping(path = "/v1/PrivateCoach/{PrivateCoach}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("PrivateCoach") String PrivateCoach) {
		Optional<PrivateCoach> org = PrivateCoachService.findById(Integer.parseInt(PrivateCoach));
		if (org == null) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.ACTIVITY_NOT_FOUND));
		}

		return ResponseEntity.ok().body(org.get());
	}
	

	@PostMapping("/v1/PrivateCoach")
	public ResponseEntity<Object> savePrivateCoach(@RequestBody PrivateCoach data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
			PrivateCoach PrivateCoachsaved = PrivateCoachService.savePrivateCoach(data);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(PrivateCoachsaved);
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	
	
	@PostMapping("/v1/PrivateCoachWeekday")
	public ResponseEntity<Object> savePrivateCoachWeekday(@RequestBody PrivateCoachWeekday data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		
		SimpleDateFormat f = new SimpleDateFormat("kk:mm:ss");
		Date start = new Date();
		try {
		    start = f.parse(data.getHour());
		} catch (ParseException e) {
		   System.out.println("ERROR: Failed to parse start time.");
		   e.printStackTrace();
		}
		Optional<Weekdays> weekdays = WeekdaysService.findById(data.getWeekdays());
		Optional<PrivateCoach> PrivateCoach = PrivateCoachService.findById(data.getPrivateCoach());

		PrivateCoachWeekdays PrivateCoachWeekdays = new PrivateCoachWeekdays(PrivateCoach.get(),weekdays.get(), data.getDuradion(), start);
		PrivateCoachWeekdays PrivateCoachWeekdaysnew = PrivateCoachWeekdaysService.savePrivateCoachWeekdays(PrivateCoachWeekdays);
		//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(PrivateCoachWeekdaysnew);
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	

	@DeleteMapping("/v1/PrivateCoach/{PrivateCoachID}")
	public ResponseEntity<Object> deleteUser(@PathVariable("PrivateCoachID") String PrivateCoachID) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<PrivateCoach> PrivateCoach = PrivateCoachService.findById(Integer.parseInt(PrivateCoachID));
		if (!PrivateCoach.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		PrivateCoachService.delete(PrivateCoach.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
	
	@DeleteMapping("/v1/PrivateCoachWeekday/{PrivateCoachWeekdays}")
	public ResponseEntity<Object> deletePrivateCoachWeekday(@PathVariable("PrivateCoachWeekdays") String PrivateCoachWeekdays) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<PrivateCoachWeekdays> PrivateCoachWeekday = PrivateCoachWeekdaysService.findById(Integer.parseInt(PrivateCoachWeekdays));
		if (!PrivateCoachWeekday.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		PrivateCoachWeekdaysService.delete(PrivateCoachWeekday.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
}