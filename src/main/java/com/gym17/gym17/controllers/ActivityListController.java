package src.main.java.com.gym17.gym17.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.gym17.gym17.model.ActivityList;
import src.main.java.com.gym17.gym17.model.ActivityListData;
import src.main.java.com.gym17.gym17.model.ActivityType;
import src.main.java.com.gym17.gym17.model.MembershipFeeType;
import src.main.java.com.gym17.gym17.model.Token;
import src.main.java.com.gym17.gym17.model.User;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.response.ResponseStatus;
import src.main.java.com.gym17.gym17.service.ActivityListService;
import src.main.java.com.gym17.gym17.service.TokenService;
import src.main.java.com.gym17.gym17.service.UserService;
import src.main.java.com.gym17.gym17.service.ActivityTypeService;


@RestController
@RequestMapping("")
public class ActivityListController {
	@Autowired
	private TokenService TokenService;
	@Autowired
	private UserService UserService;
	@Autowired
	private ActivityTypeService ActivityTypeService;

	
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
	public ResponseEntity<?> findById(@PathVariable("activityList") String activityList) {
		Optional<ActivityList> org = ActivityListService.findById(Integer.parseInt(activityList));
		if (org == null) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.ACTIVITY_NOT_FOUND));
		}

		return ResponseEntity.ok().body(org.get());
	}
	
	@PostMapping("/v1/activityList")
	public ResponseEntity<Object> saveactivityList(@RequestHeader("Authorization") String auth, @RequestBody ActivityListData ActivityListData) {
		if(auth != null ) {
			Optional<Token> token = TokenService.findBytoken(auth.replace("Bearer ", ""));
		if(token.isPresent()) {
			ActivityList ActivityList = new ActivityList();
			ActivityList.setCreateDate(ActivityListData.getCreateDate());
			ActivityList.setName(ActivityListData.getName());
			ActivityList.setDescription(ActivityListData.getDescription());
			ActivityList.setValidityPeriod(ActivityListData.getValidityPeriod());
			ActivityList.setActivityType(ActivityTypeService.findByName(ActivityListData.getActivityType()));
			ActivityList.setUser(UserService.findByExternalId(ActivityListData.getUser_id()).get());
			ActivityListService.save(ActivityList);

			return ResponseEntity.ok().body(new ResponseStatus(true));

		}
		return ResponseEntity.ok().body(new ErrorResponse(ErrorType.BAD_TOKEN));

		}
		return ResponseEntity.ok().body(new ErrorResponse(ErrorType.BAD_TOKEN));
	}
}