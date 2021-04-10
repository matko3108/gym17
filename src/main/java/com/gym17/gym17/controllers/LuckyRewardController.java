package src.main.java.com.gym17.gym17.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

import src.main.java.com.gym17.gym17.model.LuckyReward;
import src.main.java.com.gym17.gym17.model.RewardStatus;
import src.main.java.com.gym17.gym17.model.UserCustomer;
import src.main.java.com.gym17.gym17.model.UserWorker;
import src.main.java.com.gym17.gym17.model.Weekdays;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.response.ResponseStatus;
import src.main.java.com.gym17.gym17.service.LuckyRewardService;
import src.main.java.com.gym17.gym17.service.UserCustomerService;
import src.main.java.com.gym17.gym17.service.UserWorkerService;
import src.main.java.com.gym17.gym17.service.WeekdaysService;
import src.main.java.com.gym17.gym17.service.RewardStatusService;



@RestController
@RequestMapping("")
public class LuckyRewardController {

	@Autowired
	private UserCustomerService UserCustomerService;
	@Autowired
	private RewardStatusService RewardStatusService;
	
	private LuckyRewardService LuckyRewardService;

	@Autowired
	public LuckyRewardController(LuckyRewardService LuckyRewardService) {
		this.LuckyRewardService = LuckyRewardService;
	}

	@GetMapping("/v1/LuckyReward/list")
	public Iterable<LuckyReward> list() {
		Iterable<LuckyReward> LuckyReward = LuckyRewardService.list();
		return LuckyReward;
	}
	
	@GetMapping(path = "/v1/LuckyReward/{LuckyReward}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("LuckyReward") String LuckyReward) {
		Optional<LuckyReward> org = LuckyRewardService.findById(Integer.parseInt(LuckyReward));
		if (org == null) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.ACTIVITY_NOT_FOUND));
		}

		return ResponseEntity.ok().body(org.get());
	}
	
	@GetMapping(path = "/v1/LuckyRewardCustomer/{LuckyRewardCustomer}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByCustomerId(@PathVariable("LuckyRewardCustomer") String LuckyRewardCustomer) {
		Optional<LuckyReward> org = LuckyRewardService.findByCustomer(Integer.parseInt(LuckyRewardCustomer));
		if (!org.isPresent()) {
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.NO_LUCKY_REWARD));
		}

		return ResponseEntity.ok().body(org.get());
	}
	

	@PostMapping("/v1/LuckyReward")
	public ResponseEntity<Object> saveLuckyReward(@RequestBody LuckyReward data) {

		if(data.getId() == null) {
			List<Integer> userCustomerList = UserCustomerService.findValidCustomers();
			Random rand = new Random();
		    int newUserWinner =givenList_shouldReturnARandomElement(userCustomerList);
		    String newCode = newCodeGenerator();
		   
		    data.setUserCustomer(UserCustomerService.findById(newUserWinner).get());
		    data.setCode(newCode);
		    data.setRewardStatus(RewardStatusService.findById(1).get());
		    
			LuckyReward LuckyRewardsaved = LuckyRewardService.saveLuckyReward(data);
			return ResponseEntity.ok().body(LuckyRewardsaved);
		    
		}else {
			Optional<UserCustomer> UserCustomer =  UserCustomerService.findById(data.getUserCustomer().getId());
			data.setUserCustomer(UserCustomer.get());
			Optional<RewardStatus> RewardStatus =  RewardStatusService.findById(data.getRewardStatus().getId());
			data.setRewardStatus(RewardStatus.get());
			LuckyReward LuckyRewardsaved = LuckyRewardService.saveLuckyReward(data);
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(LuckyRewardsaved);
			//return ResponseEntity.ok().body(new ErrorResponse(ErrorType.USER_NOT_FOUND));
		}
	}
	
	public int givenList_shouldReturnARandomElement(List<Integer> userCustomerList) {
		boolean exists = true;
		int newUser = 0;
		while(exists) {
		    Random rand = new Random();
		    int randomElement = userCustomerList.get(rand.nextInt(userCustomerList.size()));
		    Optional<LuckyReward> luckyReward = LuckyRewardService.findByCustomer(randomElement);
		    if(!luckyReward.isPresent()) {
		    	exists = false;
		    	newUser = randomElement;
		    }
		    
		}
	    return newUser;
	}
	
	public String newCodeGenerator() {
		 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 StringBuilder sb = new StringBuilder();
		 Random random = new Random();
		 int length = 7;
		 String randomCode = null;
		 boolean codeexists = true;
		 
			while(codeexists) {
		    for(int i = 0; i < length; i++) {
		      // generate random index number
		      int index = random.nextInt(alphabet.length());
		      // get character specified by index
		      // from the string
		      char randomChar = alphabet.charAt(index);
		      // append the character to string builder
		      sb.append(randomChar);
		    }

		    String randomString = sb.toString();
		    Optional<LuckyReward> luckyReward = LuckyRewardService.findByCode(randomString);

		    if(!luckyReward.isPresent()) {
		    	codeexists = false;
		    	randomCode = randomString;
		    }
		    
			}
			return randomCode;
	}
	

	@DeleteMapping("/v1/LuckyReward/{LuckyRewardID}")
	public ResponseEntity<Object> deleteLuckyReward(@PathVariable("LuckyRewardID") String LuckyRewardID) {

		/*
		 * log.
		 * info("Requested: delete User with a specifid id. Request data: [UserId={}]",
		 * UserId);
		 */

		Optional<LuckyReward> LuckyReward = LuckyRewardService.findById(Integer.parseInt(LuckyRewardID));
		if (!LuckyReward.isPresent()) {
			//log.info("Response: [{}].", ErrorType.USER_NOT_FOUND.toString());
			return ResponseEntity.ok().body(new ErrorResponse(ErrorType.NO_LUCKY_REWARD));
		}

		LuckyRewardService.delete(LuckyReward.get());
		//log.info("Requested User successfully deleted! Response: [{}].", User.get());
		return ResponseEntity.ok().body(new ResponseStatus(true));
	}
	
	
}