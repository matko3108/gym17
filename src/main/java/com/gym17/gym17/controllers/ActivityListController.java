package src.main.java.com.gym17.gym17.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.gym17.gym17.model.ActivityList;
import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.service.ActivityListService;

@RestController
@RequestMapping("")
public class ActivityListController {


	private ActivityListService ActivityListService;

	@Autowired
	public ActivityListController(ActivityListService ActivityListService) {
		this.ActivityListService = ActivityListService;
	}

	@GetMapping("/v1/activityList/list")
	public Iterable<ActivityList> list() {
		Iterable<ActivityList> ActivityList = ActivityListService.list();
		return ActivityList;
	}
	@GetMapping(path = "/v1/activityList/{activityList}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("activityListid") String activityListid) {
		Optional<ActivityList> org = ActivityListService.findById(Integer.parseInt(activityListid));
		if (org == null) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.ACTIVITY_NOT_FOUND));
		}

		return ResponseEntity.ok().body(org);
	}
	
}