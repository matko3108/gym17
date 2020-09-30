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

import src.main.java.com.gym17.gym17.model.Group;
import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.service.GroupService;

@RestController
@RequestMapping("")
public class GroupController {


	private GroupService GroupService;

	@Autowired
	public GroupController(GroupService GroupService) {
		this.GroupService = GroupService;
	}

	@GetMapping("/v1/Group/list")
	public Iterable<Group> list() {
		Iterable<Group> Group = GroupService.list();
		return Group;
	}
	
	@GetMapping(path = "/v1/Group/{Group}", produces = MediaType.APPLICATION_JSON_VALUE)
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
		return ResponseEntity.ok().body(Group.get());
	}
}