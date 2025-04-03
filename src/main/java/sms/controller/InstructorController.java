package sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sms.controller.model.InstructorData;
import sms.service.InstructorService;

@RestController
@RequestMapping("/sch_mgmt")
@Slf4j
public class InstructorController {
	@Autowired
	private InstructorService instructorService;

	@GetMapping("/instructor/{instructorId}")
	public InstructorData retrieveInstructor(@PathVariable Long instructorId) {
		log.info("Retrieving instructor with ID={}", instructorId);
		return instructorService.retrieveInstructorById(instructorId);
	}
}
