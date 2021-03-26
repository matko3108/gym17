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

import src.main.java.com.gym17.gym17.model.UserCustomer;
import src.main.java.com.gym17.gym17.model.UserCustomerList;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.service.UserCustomerService;
import src.test.java.com.gym17.gym17.UserListCustomer;

@RestController
@RequestMapping("")
public class UserCustomerController {

	private UserCustomerService UserCustomerService;

	@Autowired
	public UserCustomerController(UserCustomerService UserCustomerService) {
		this.UserCustomerService = UserCustomerService;
	}

	@GetMapping("/v1/usercustomer/list")
	public Iterable<UserListCustomer> list() {
		// log.info("Requested: a list of UserCustomers.");
		Iterable<UserListCustomer> UserCustomerList = UserCustomerService.list();
		// log.info("Response contains the following list of UserCustomers: [{}]",
		// UserCustomerList);
		return UserCustomerList;
	}

}
