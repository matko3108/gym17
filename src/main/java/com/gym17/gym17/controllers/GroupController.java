package src.main.java.com.gym17.gym17.controllers;

import java.util.Optional;
import java.util.function.Consumer;

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

import src.main.java.com.gym17.gym17.model.Group;
import src.main.java.com.gym17.gym17.model.GroupCustomer;
import src.main.java.com.gym17.gym17.model.GroupCustomerNew;
import src.main.java.com.gym17.gym17.model.GroupWeekdays;
import src.main.java.com.gym17.gym17.model.GroupWeekdaysNew;
import src.main.java.com.gym17.gym17.model.GroupWorker;
import src.main.java.com.gym17.gym17.model.GroupWorkerNew;
import src.main.java.com.gym17.gym17.model.PrivateCoachWeekdays;
import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.model.UserCustomer;
import src.main.java.com.gym17.gym17.model.UserWorker;
import src.main.java.com.gym17.gym17.model.Weekdays;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.response.ResponseStatus;
import src.main.java.com.gym17.gym17.service.GroupService;
import src.main.java.com.gym17.gym17.service.GroupWorkerService;
import src.main.java.com.gym17.gym17.service.GroupCustomerService;
import src.main.java.com.gym17.gym17.service.GroupWeekDaysService;
import src.main.java.com.gym17.gym17.service.UserCustomerService;
import src.main.java.com.gym17.gym17.service.UserWorkerService;
import src.main.java.com.gym17.gym17.service.WeekdaysService;


@RestController
@RequestMapping("")
public class GroupController {
	@Autowired
	private GroupWorkerService GroupWorkerService;
	@Autowired
	private GroupCustomerService GroupCustomerService;
	@Autowired
	private GroupWeekDaysService GroupWeekDaysService;
	@Autowired
	private UserCustomerService UserCustomerService;
	@Autowired
	private UserWorkerService UserWorkerService;
	@Autowired
	private WeekdaysService WeekdaysService;
	

	private GroupService GroupService;

	@Autowired
	public GroupController(GroupService GroupService) {
		this.GroupService = GroupService;
	}

	@GetMapping("/v1/group/list")
	public Iterable<Group> list() {
		Iterable<Group> Group = GroupService.list();
		return Group;
	}
	
	@GetMapping(path = "/v1/group/{Group}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("Group") String Group) {
		Optional<Group> org = GroupService.findById(Integer.parseInt(Group));
		if (org == null) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.ACTIVITY_NOT_FOUND));
		}

		return ResponseEntity.ok().body(org.get());
	}
	

	@PostMapping("/v1/group")
	public ResponseEntity<Object> saveGroup(@RequestBody Group data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */


		Group groupsaved = GroupService.saveGroup(data);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		return ResponseEntity.ok().body(groupsaved);
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	

	@DeleteMapping("/v1/group/{groupID}")
	public ResponseEntity<Object> deleteUser(@PathVariable("groupID") String groupID) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<Group> Group = GroupService.findById(Integer.parseInt(groupID));
		if (!Group.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		GroupService.delete(Group.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
	
	
	@PostMapping("/v1/groupCustomer")
	public ResponseEntity<Object> saveGroupCustomer(@RequestBody GroupCustomer data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<UserCustomer> UserCustomer =  UserCustomerService.findById(data.getUserCustomer().getId());
		data.setUserCustomer(UserCustomer.get());
		GroupCustomer GroupCustomersaved = GroupCustomerService.saveGroupCustomer(data);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		Optional<Group> Group = GroupService.findByIdnew(GroupCustomersaved.getGroup().getId());
		return ResponseEntity.ok().body(Group.get());
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	
	@PostMapping("/v1/groupWorker")
	public ResponseEntity<Object> saveGroupWorker(@RequestBody GroupWorker data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 * 
		 */
		Optional<UserWorker> UserWorker =  UserWorkerService.findById(data.getUserWorker().getId());
		data.setUserWorker(UserWorker.get());
		GroupWorker GroupWorkersaved = GroupWorkerService.saveGroupWorker(data);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		Optional<Group> Group = GroupService.findById(GroupWorkersaved.getGroup().getId());

		return ResponseEntity.ok().body(Group.get());
		//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	
	@PostMapping("/v1/groupWeekdays")
	public ResponseEntity<Object> saveGroupWeekdays(@RequestBody GroupWeekdays data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<Weekdays> Weekdays =  WeekdaysService.findById(data.getWeekdays().getId());
		data.setWeekdays(Weekdays.get());
		GroupWeekdays GroupWeekdayssaved = GroupWeekDaysService.saveGroupWeekdays(data);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
		Optional<Group> Group = GroupService.findById(GroupWeekdayssaved.getGroup().getId());
		return ResponseEntity.ok().body(Group.get());
		//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	
	@DeleteMapping("/v1/groupWeekdays/{groupWeekdays}")
	public ResponseEntity<Object> deletegroupWeekdays(@PathVariable("groupWeekdays") String groupWeekdays) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<GroupWeekdays> GroupWeekday = GroupWeekDaysService.findById(Integer.parseInt(groupWeekdays));
		if (!GroupWeekday.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		GroupWeekDaysService.delete(GroupWeekday.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
	
	@DeleteMapping("/v1/groupWorker/{GroupWorker}")
	public ResponseEntity<Object> deleteGroupWorker(@PathVariable("GroupWorker") String GroupWorker) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<GroupWorker> GroupWorkerget = GroupWorkerService.findById(Integer.parseInt(GroupWorker));
		if (!GroupWorkerget.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		GroupWorkerService.delete(GroupWorkerget.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
	
	@DeleteMapping("/v1/groupCustomer/{groupCustomer}")
	public ResponseEntity<Object> deletegroupCustomer(@PathVariable("groupCustomer") String groupCustomer) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */
		Optional<GroupCustomer> GroupCustomerget = GroupCustomerService.findById(Integer.parseInt(groupCustomer));
		if (!GroupCustomerget.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		GroupCustomerService.delete(GroupCustomerget.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
}