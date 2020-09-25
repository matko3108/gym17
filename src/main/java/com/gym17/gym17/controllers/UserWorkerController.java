package src.main.java.com.gym17.gym17.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.gym17.gym17.model.UserWorkerList;
import src.main.java.com.gym17.gym17.service.UserWorkerService;

@RestController
@RequestMapping("")
public class UserWorkerController {

	private UserWorkerService UserWorkerService;

	@Autowired
	public UserWorkerController(UserWorkerService UserCustomerService) {
		this.UserWorkerService = UserCustomerService;
	}

	@GetMapping("/v1/userworker/list")
	public Iterable<UserWorkerList> list() {
		// log.info("Requested: a list of UserCustomers.");
		Iterable<UserWorkerList> UserCustomerList = UserWorkerService.list();
		// log.info("Response contains the following list of UserCustomers: [{}]",
		// UserCustomerList);
		return UserCustomerList;
	}

}