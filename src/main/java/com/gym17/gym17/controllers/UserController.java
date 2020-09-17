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

import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


	private UserService UserService;

	@Autowired
	public UserController(UserService UserService) {
		this.UserService = UserService;
	}

	@GetMapping("/v1/list")
	public Iterable<User> list() {
		//log.info("Requested: a list of Users.");
		Iterable<User> UserList = UserService.list();
		//log.info("Response contains the following list of Users: [{}]", UserList);
		return UserList;
	}

	@GetMapping(path = "/v100/list/{UserId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findUserById(@PathVariable("UserId") String UserId) {

		//log.info("Requested: User with a specifid id. Request data: [UserId={}]", UserId);
		Optional<User> User = UserService.findById(Integer.parseInt(UserId));

		if (!User.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		//log.info("Requested User successfully found! Response: [{}].", User.get());
		return ResponseEntity.ok().body(User.get());
	}

	@DeleteMapping("/v100/delete/{UserId}")
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

		//UserService.delete(User.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(User.get());
	}

	@PostMapping("/v100/update/{UserId}")
	public ResponseEntity<Object> updateUser(@PathVariable("UserId") String UserId,
			@RequestBody User data) {

		/*
		 * log.
		 * info("Requested: update User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<User> User = UserService.findById(Integer.parseInt(UserId));
		if (!User.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}

		//UserService.update(User.get(), data);
		//log.info("Requested User successfully updated! Response: [{}].", User.get());
		return ResponseEntity.ok().body(User.get());
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
	@GetMapping(path = "/v100/user/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByUsername(@PathVariable("username") String username) {
		/*
		 * //log.info("Requested: User with [username={}]", username);
		 */		User org = UserService.findByUsername1(username);
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
