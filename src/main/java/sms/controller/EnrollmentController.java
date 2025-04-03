package sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sms.controller.model.EnrollmentData;
import sms.service.EnrollmentService;

@RestController
@RequestMapping("/sch_mgmt")
@Slf4j
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentService;
	
	@GetMapping("/enrollment/{enrollmentId}")
	public EnrollmentData retrieveEnrollment(@PathVariable Long enrollmentId) {
		log.info("Retrieving enrollment with ID={}", enrollmentId);
		return enrollmentService.retrieveEnrollmentById(enrollmentId);
	}
}
