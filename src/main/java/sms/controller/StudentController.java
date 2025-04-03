package sms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sms.controller.model.StudentData;
import sms.service.StudentService;

@RestController
@RequestMapping("/sch_mgmt")
@Slf4j
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student/{studentId}")
	public StudentData retrieveStudent(@PathVariable Long studentId) {
		log.info("Retrieving student with ID={}", studentId);
		return studentService.retrieveStudentById(studentId);
	}
}
