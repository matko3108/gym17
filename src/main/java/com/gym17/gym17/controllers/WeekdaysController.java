package src.main.java.com.gym17.gym17.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.gym17.gym17.model.Weekdays;
import src.main.java.com.gym17.gym17.response.ErrorResponse;
import src.main.java.com.gym17.gym17.response.ErrorType;
import src.main.java.com.gym17.gym17.service.WeekdaysService;

@RestController
@RequestMapping("")
public class WeekdaysController {


	private WeekdaysService WeekdaysService;

	@Autowired
	public WeekdaysController(WeekdaysService WeekdaysService) {
		this.WeekdaysService = WeekdaysService;
	}

	@GetMapping("/v1/weekdays/list")
	public Iterable<Weekdays> list() {
		Iterable<Weekdays> Weekdays = WeekdaysService.list();
		return Weekdays;
	}

	
}