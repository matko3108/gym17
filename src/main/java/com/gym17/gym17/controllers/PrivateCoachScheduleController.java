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
import src.main.java.com.gym17.gym17.model.PrivateCoachSchedule;
import src.main.java.com.gym17.gym17.model.PrivateCoachStatus;
import src.main.java.com.gym17.gym17.model.PrivateCoachWeekday;
import src.main.java.com.gym17.gym17.model.PrivateCoachWeekdays;
import src.main.java.com.gym17.gym17.model.UserCustomer;
import src.main.java.com.gym17.gym17.model.UserWorker;
import src.main.java.com.gym17.gym17.model.Weekdays;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.response.ResponseStatus;
import src.main.java.com.gym17.gym17.service.PrivateCoachService;
import src.main.java.com.gym17.gym17.service.PrivateCoachWeekdaysService;
import src.main.java.com.gym17.gym17.service.UserCustomerService;
import src.main.java.com.gym17.gym17.service.UserWorkerService;
import src.main.java.com.gym17.gym17.service.WeekdaysService;
import src.main.java.com.gym17.gym17.service.PrivateCoachScheduleService;
import src.main.java.com.gym17.gym17.service.PrivateCoachStatusService;


@RestController
@RequestMapping("")
public class PrivateCoachScheduleController {

	@Autowired
	private PrivateCoachWeekdaysService PrivateCoachWeekdaysService;
	@Autowired
	private WeekdaysService WeekdaysService;
	@Autowired
	private UserCustomerService UserCustomerService;
	@Autowired
	private UserWorkerService UserWorkerService;
	@Autowired
	private PrivateCoachService PrivateCoachService;
	@Autowired
	private PrivateCoachStatusService PrivateCoachStatusService;

	private PrivateCoachScheduleService PrivateCoachScheduleService;

	@Autowired
	public PrivateCoachScheduleController(PrivateCoachScheduleService PrivateCoachScheduleService) {
		this.PrivateCoachScheduleService = PrivateCoachScheduleService;
	}

	@GetMapping("/v1/PrivateCoachSchedule/list")
	public Iterable<PrivateCoachSchedule> list() {
		Iterable<PrivateCoachSchedule> PrivateCoachSchedule = PrivateCoachScheduleService.list();
		return PrivateCoachSchedule;
	}
	
	@GetMapping("/v1/PrivateCoachSchedule/listofFree")
	public Iterable<PrivateCoachSchedule> listofFree() {
		Iterable<PrivateCoachSchedule> PrivateCoachSchedule = PrivateCoachScheduleService.listofFree();
		return PrivateCoachSchedule;
	}

	@GetMapping(path = "/v1/PrivateCoachSchedule/{PrivateCoachSchedule}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("PrivateCoachSchedule") String PrivateCoachSchedule) {
		Optional<PrivateCoachSchedule> org = PrivateCoachScheduleService
				.findById(Integer.parseInt(PrivateCoachSchedule));
		if (org == null) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.PRIVATE_COACH_NOT_FOUND));
		}

		return ResponseEntity.ok().body(org.get());
	}

	@GetMapping(path = "/v1/PrivateCoachScheduleCustomer/{PrivateCoachScheduleCustomer}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByCustomer(
			@PathVariable("PrivateCoachScheduleByCustomer") String PrivateCoachScheduleByCustomer) {
		Iterable<PrivateCoachSchedule> org = PrivateCoachScheduleService
				.findByCustomer(Integer.parseInt(PrivateCoachScheduleByCustomer));
		return ResponseEntity.ok().body(org);
	}

	@PostMapping("/v1/PrivateCoachSchedule")
	public ResponseEntity<Object> savePrivateCoachSchedule(@RequestBody PrivateCoachSchedule data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<UserWorker> UserWorker = UserWorkerService.findById(data.getUserWorker().getId());
		data.setUserWorker(UserWorker.get());
		Optional<Weekdays>  Weekdays = WeekdaysService.findById(data.getWeekdays().getId());
		data.setWeekdays(Weekdays.get());
		Optional<PrivateCoachStatus>  PrivateCoachStatus = PrivateCoachStatusService.findById(1);
		data.setPrivateCoachStatus(PrivateCoachStatus.get());
		
		PrivateCoachSchedule PrivateCoachSchedule = PrivateCoachScheduleService.savePrivateCoachSchedule(data);
		// log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		return ResponseEntity.ok().body(PrivateCoachSchedule);
		// return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
	}


	@PostMapping("/v1/PrivateCoachSchedule/register")
	public ResponseEntity<Object> registerPrivateCoachSchedule(@RequestBody PrivateCoachSchedule data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<PrivateCoachSchedule> PrivateCoachSchedule = PrivateCoachScheduleService.findById(data.getId());
		Optional<UserCustomer> UserCustomer = UserCustomerService.findById(data.getUserCustomer().getId());
		PrivateCoachSchedule.get().setUserCustomer(UserCustomer.get());

		Optional<PrivateCoachStatus>  PrivateCoachStatus = PrivateCoachStatusService.findById(11);
		PrivateCoachSchedule.get().setPrivateCoachStatus(PrivateCoachStatus.get());
		
		PrivateCoachSchedule PrivateCoachSchedulesaved = PrivateCoachScheduleService.savePrivateCoachSchedule(PrivateCoachSchedule.get());
		// log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		return ResponseEntity.ok().body(PrivateCoachSchedulesaved);
		// return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
	}
	
	
	@PostMapping("/v1/PrivateCoachSchedule/bookPrivateCoach")
	public ResponseEntity<Object> bookPrivateCoachSchedule(@RequestBody PrivateCoachSchedule data) {

		Optional<PrivateCoachSchedule> PrivateCoachSchedule = PrivateCoachScheduleService.findById(data.getId());

		Optional<PrivateCoachStatus>  PrivateCoachStatus = PrivateCoachStatusService.findById(21);
		PrivateCoachSchedule.get().setPrivateCoachStatus(PrivateCoachStatus.get());
		PrivateCoachSchedule.get().setStart(data.getStart());
		PrivateCoachSchedule.get().setEnd(data.getEnd());
		
		
		
		Optional<UserWorker> UserWorker =  UserWorkerService.findById(data.getUserWorker().getId());
		Optional<UserCustomer> UserCustomer =  UserCustomerService.findById(data.getUserCustomer().getId());
		
		PrivateCoachSchedule.get().setUserCustomer(UserCustomer.get());
		PrivateCoachSchedule PrivateCoachSchedulesaved = PrivateCoachScheduleService.savePrivateCoachSchedule(PrivateCoachSchedule.get());

		
		PrivateCoach PrivateCoach = new PrivateCoach();
		PrivateCoach.setDescription(PrivateCoachSchedulesaved.getDescription());
		PrivateCoach.setEnd(PrivateCoachSchedulesaved.getEnd());
		PrivateCoach.setStart(PrivateCoachSchedulesaved.getStart());
		PrivateCoach.setUserCustomer(UserCustomer.get());
		PrivateCoach.setUserWorker(UserWorker.get());
		
		PrivateCoach PrivateCoachsaved = PrivateCoachService.savePrivateCoach(PrivateCoach);
		
		PrivateCoachWeekdays PrivateCoachWeekdayses = new PrivateCoachWeekdays();
		PrivateCoachWeekdayses.setDuration(PrivateCoachSchedulesaved.getDuration());
		PrivateCoachWeekdayses.setHour(PrivateCoachSchedulesaved.getHour());
		PrivateCoachWeekdayses.setPrivateCoach(PrivateCoachsaved);
		PrivateCoachWeekdayses.setWeekdays(PrivateCoachSchedulesaved.getWeekdays());
		
		PrivateCoachWeekdays PrivateCoachWeekdaysessaved = PrivateCoachWeekdaysService.savePrivateCoachWeekdays(PrivateCoachWeekdayses);
		//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		
		// log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		return ResponseEntity.ok().body(PrivateCoachSchedulesaved);
		// return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
	}
	
	/*
	 * @PostMapping("/v1/PrivateCoachWeekday") public ResponseEntity<Object>
	 * savePrivateCoachWeekday(@RequestBody PrivateCoachWeekday data) {
	 * 
	 * 
	 * log.
	 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
	 * UserId);
	 * 
	 * 
	 * SimpleDateFormat f = new SimpleDateFormat("kk:mm:ss"); Date start = new
	 * Date(); try { start = f.parse(data.getHour()); } catch (ParseException e) {
	 * System.out.println("ERROR: Failed to parse start time.");
	 * e.printStackTrace(); } Optional<Weekdays> weekdays =
	 * WeekdaysService.findById(data.getWeekdays()); Optional<PrivateCoach>
	 * PrivateCoach = PrivateCoachService.findById(data.getPrivateCoach());
	 * 
	 * PrivateCoachWeekdays PrivateCoachWeekdays = new
	 * PrivateCoachWeekdays(PrivateCoach.get(),weekdays.get(), data.getDuration(),
	 * start); PrivateCoachWeekdays PrivateCoachWeekdaysnew =
	 * PrivateCoachWeekdaysService.savePrivateCoachWeekdays(PrivateCoachWeekdays);
	 * //log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
	 * Optional<PrivateCoach> PrivateCoachsaved =
	 * PrivateCoachService.findById(data.getPrivateCoach());
	 * 
	 * return ResponseEntity.ok().body(PrivateCoachsaved.get()); //return
	 * ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND)); }
	 */

	@DeleteMapping("/v1/PrivateCoachSchedule/{PrivateCoachScheduleID}")
	public ResponseEntity<Object> deletePrivateCoachSchedule(
			@PathVariable("PrivateCoachScheduleID") String PrivateCoachScheduleID) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<PrivateCoachSchedule> PrivateCoachSchedule = PrivateCoachScheduleService
				.findById(Integer.parseInt(PrivateCoachScheduleID));
		if (!PrivateCoachSchedule.isPresent()) {
			// log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.PRIVATE_COACH_NOT_FOUND));
		}

		PrivateCoachScheduleService.delete(PrivateCoachSchedule.get());
		// log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}

	/*
	 * @DeleteMapping("/v1/PrivateCoachWeekday/{PrivateCoachWeekdays}") public
	 * ResponseEntity<Object> deletePrivateCoachWeekday(
	 * 
	 * @PathVariable("PrivateCoachWeekdays") String PrivateCoachWeekdays) {
	 * 
	 * 
	 * log.
	 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
	 * UserId);
	 * 
	 * Optional<PrivateCoachWeekdays> PrivateCoachWeekday =
	 * PrivateCoachWeekdaysService
	 * .findById(Integer.parseInt(PrivateCoachWeekdays)); if
	 * (!PrivateCoachWeekday.isPresent()) { // log.info("Response: [{}].",
	 * ErrorType.USER_NOT_FOUND.toString()); return ResponseEntity.ok().body(new
	 * ErrorResponse(ErrorType.USER_NOT_FOUND)); }
	 * 
	 * PrivateCoachWeekdaysService.delete(PrivateCoachWeekday.get()); //
	 * log.info("Requested User successfully deleted! Response: [{}].", User.get());
	 * return ResponseEntity.ok().body(new ResponseStatus(true)); }
	 */
}