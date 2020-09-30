package src.main.java.com.gym17.gym17.controllers;

import java.util.HashMap;
import java.util.Map;
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

import src.main.java.com.gym17.gym17.model.CustomerMembershipFee;
import src.main.java.com.gym17.gym17.model.LoginCredentials;
import src.main.java.com.gym17.gym17.model.MembershipFeeType;
import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.model.UserData;
import src.main.java.com.gym17.gym17.model.UserMembershipData;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.service.UserService;
import src.main.java.com.gym17.gym17.service.MembershipFeeTypeService;
import src.main.java.com.gym17.gym17.service.CustomerMembershipFeeService;



@RestController
@RequestMapping("")
public class UserController {


	private UserService UserService;
	@Autowired
	private MembershipFeeTypeService MembershipFeeTypeService;
	@Autowired
	private CustomerMembershipFeeService CustomerMembershipFeeService;
	
	@Autowired
	public UserController(UserService UserService) {
		this.UserService = UserService;
	}

	@GetMapping("/v1/user/list")
	public Iterable<User> list() {
		//log.info("Requested: a list of Users.");
		Iterable<User> UserList = UserService.list();
		//log.info("Response contains the following list of Users: [{}]", UserList);
		return UserList;
	}
	
	//@GetMapping("/v1/user/customerlist")
	public Iterable<User> customerlist() {
		//log.info("Requested: a list of Users.");
		Iterable<User> UserList = UserService.customerlist();
		//log.info("Response contains the following list of Users: [{}]", UserList);
		return UserList;
	}

	//@GetMapping("/v1/user/workerlist")
	public Iterable<User> workerlist() {
		//log.info("Requested: a list of Users.");
		Iterable<User> UserList = UserService.workerlist();
		//log.info("Response contains the following list of Users: [{}]", UserList);
		return UserList;
	}
	

	@DeleteMapping("/v1/delete/{UserId}")
	public ResponseEntity<Object> deleteUser(@PathVariable("UserId") String UserId) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<User> User = UserService.findById(Integer.parseInt(UserId));
		if (!User.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		UserService.delete(User.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(User.get());
	}

	@PostMapping("/v1/user/update")
	public ResponseEntity<Object> updateUser(@RequestBody User data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<User> User = UserService.findById(data.getId());
		if (User.isPresent()) {
			User usersaved = UserService.updateUser(data);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(usersaved);
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		//UserService.update(User.get(), data);
		//log.info("Requested User successfully updated! Response: [{}].", User.get());
		return ResponseEntity.ok().body(User.get());
	}
	
	@PostMapping("/v1/userworker/login")
	public ResponseEntity<Object> userLogin(@RequestBody LoginCredentials data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<User> User = UserService.findByUsername1(data.getUsername());
		if (User.isPresent()) {
			if(User.get().getPassword().equals(data.getPassword())) {
				User.get().setPassword(null);
				return ResponseEntity.ok().body(User.get());

			}
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.BAD_CREDENTIALS));

		}

		return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));

		}

	@PostMapping("/v1/user")
	public ResponseEntity<Object> saveUser(@RequestBody UserData userdata) {

		Optional<User> User = UserService.findByExternalId(userdata.getUser().getExternalId());
		if (User.isPresent()) {
			User usersaved = UserService.updateExternalUser(userdata.getUser(), User);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(usersaved);
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}else {
			User usersaved = UserService.saveNewUser(userdata);
			return ResponseEntity.ok().body(usersaved);
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		//UserService.update(User.get(), data);
		//log.info("Requested User successfully updated! Response: [{}].", User.get());
		//return ResponseEntity.ok().body(User.get());
	}
	
	@PostMapping("/v1/userMembership")
	public ResponseEntity<Object> saveUserMebership(@RequestBody UserMembershipData userMembershipdata) {

		Optional<User> User = UserService.findByExternalId(userMembershipdata.getUser_id());
		Optional<MembershipFeeType> MembershipFeeType = MembershipFeeTypeService.findByExternalId(userMembershipdata.getUser_id());
		if (User.isPresent() && MembershipFeeType.isPresent()) {
			CustomerMembershipFee customerMembershipFee = new CustomerMembershipFee();
			customerMembershipFee.setMembershipFeeType(MembershipFeeType.get());
			customerMembershipFee.setUserCustomer(User.get().getUserCustomer());
			customerMembershipFee.setEndDate(userMembershipdata.getEnd_date());
			customerMembershipFee.setStartDate(userMembershipdata.getStart_date());
			CustomerMembershipFeeService.saveCustomerMembershipFee(customerMembershipFee);
			
			return ResponseEntity.ok().body("");
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}else {
			if(!User.isPresent()) {
				return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
			}else if(!MembershipFeeType.isPresent()) {
				return ResponseEntity.ok().body(new ErrorResponse(ErrorType.MEMBERSHIP_NOT_FOUND));
			}
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
		return null;

		//UserService.update(User.get(), data);
		//log.info("Requested User successfully updated! Response: [{}].", User.get());
		//return ResponseEntity.ok().body(User.get());
	}
	/*
	 * @RestController() public class UserinfoController {
	 * 
	 * @GetMapping("/me") public ResponseEntity currentUser(@AuthenticationPrincipal
	 * UserDetails userDetails) {
	 * //log.info("Request: map curretnt user to /User/me"); Map<Object, Object> model
	 * = new HashMap<>(); model.put("username", userDetails.getUsername());
	 * //log.info("Response: [{}]", model); return (ResponseEntity) model; } }
	 */

	// Controller
	@GetMapping(path = "/v1/user/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("userid") String userid) {
		/*
		 * //log.info("Requested: User with [username={}]", username);
		 */		Optional<User> org = UserService.findById(Integer.parseInt(userid));
		if (org == null) {
			/*
			 * //log.info("User with [username={}] not found! Response: [{}]", username,
			 * ErrorType.USER_NOT_FOUND.toString());
			 */
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		/*
		 * //log.info("User with [username={}] found successfully! Response: [{}]",
		 * username, org);
		 */		return ResponseEntity.ok().body(org);
	}

}
