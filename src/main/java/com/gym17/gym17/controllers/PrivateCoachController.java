package src.main.java.com.gym17.gym17.controllers;

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
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.service.PrivateCoachService;

@RestController
@RequestMapping("")
public class PrivateCoachController {


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
	public ResponseEntity<?> findById(@PathVariable("PrivateCoachid") String PrivateCoachid) {
		Optional<PrivateCoach> org = PrivateCoachService.findById(Integer.parseInt(PrivateCoachid));
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
		return ResponseEntity.ok().body(PrivateCoach.get());
	}
}