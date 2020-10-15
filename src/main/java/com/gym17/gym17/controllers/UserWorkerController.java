package src.main.java.com.gym17.gym17.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.gym17.gym17.model.Group;
import src.main.java.com.gym17.gym17.model.GroupWeekdays;
import src.main.java.com.gym17.gym17.model.UserWorker;
import src.main.java.com.gym17.gym17.model.UserWorkerList;
import src.main.java.com.gym17.gym17.model.UserWorkerWorkerRights;
import src.main.java.com.gym17.gym17.model.Weekdays;
import src.main.java.com.gym17.gym17.model.WorkerRights;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.response.ResponseStatus;
import src.main.java.com.gym17.gym17.service.UserWorkerWorkerRightsService;
import src.main.java.com.gym17.gym17.service.UserWorkerService;
import src.main.java.com.gym17.gym17.service.WorkerRightsService;



@RestController
@RequestMapping("")
public class UserWorkerController {
	@Autowired
	private UserWorkerWorkerRightsService UserWorkerWorkerRightsService;
	@Autowired
	private WorkerRightsService WorkerRightsService;
	
	private UserWorkerService UserWorkerService;

	@Autowired
	public UserWorkerController(UserWorkerService UserCustomerService) {
		this.UserWorkerService = UserCustomerService;
	}

	@GetMapping("/v1/userworker/list")
	public Iterable<UserWorker> list() {
		// log.info("Requested: a list of UserCustomers.");
		Iterable<UserWorker> UserWorker = UserWorkerService.list();
		// log.info("Response contains the following list of UserCustomers: [{}]",
		// UserCustomerList);
		return UserWorker;
	}
	

	@GetMapping("/v1/userworkerCoach/list")
	public Iterable<UserWorker> coachlist() {
		// log.info("Requested: a list of UserCustomers.");
		Iterable<UserWorker> UserWorker = UserWorkerService.coachlist();
		// log.info("Response contains the following list of UserCustomers: [{}]",
		// UserCustomerList);
		return UserWorker;
	}
	

	@GetMapping("/v1/userRights/list")
	public Iterable<WorkerRights> rightslist() {
		// log.info("Requested: a list of UserCustomers.");
		Iterable<WorkerRights> WorkerRights = WorkerRightsService.list();
		// log.info("Response contains the following list of UserCustomers: [{}]",
		// UserCustomerList);
		return WorkerRights;
	}
	
	@PostMapping("/v1/userworkerrights")
	public ResponseEntity<Object> saveuserworkerrights(@RequestBody UserWorkerWorkerRights UserWorkerWorkerRights) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<WorkerRights> WorkerRights =  WorkerRightsService.findById(UserWorkerWorkerRights.getWorkerRights().getId());
		UserWorkerWorkerRights.setWorkerRights(WorkerRights.get());
		
		Optional<UserWorker> UserWorker = UserWorkerService.findById(UserWorkerWorkerRights.getUserWorker().getId());
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		UserWorkerWorkerRights.setUserWorker(UserWorker.get());
		
		UserWorkerWorkerRightsService.saveUserWorkerWorkerRights(UserWorkerWorkerRights);
		Optional<UserWorker> UserWorkernew = UserWorkerService.findById(UserWorkerWorkerRights.getUserWorker().getId());
		return ResponseEntity.ok().body(UserWorkernew.get());
		//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	
	@DeleteMapping("/v1/userworkerrights/{userworkerrights}")
	public ResponseEntity<Object> deleteuserworkerrights(@PathVariable("userworkerrights") String userworkerrights) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<UserWorkerWorkerRights> UserWorkerWorkerRights = UserWorkerWorkerRightsService.findById(Integer.parseInt(userworkerrights));
		if (!UserWorkerWorkerRights.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		UserWorkerWorkerRightsService.delete(UserWorkerWorkerRights.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}

}