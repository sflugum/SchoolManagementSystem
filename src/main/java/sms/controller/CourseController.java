package sms.controller;

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
import sms.controller.model.CourseData;
import sms.service.CourseService;

@RestController
@RequestMapping("/sch_mgmt")
@Slf4j
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CourseData createCourse(@RequestBody CourseData courseData) {
		log.info("Creating course {}", courseData);
		return courseService.saveCourse(courseData);
	}
	
	@PutMapping("/course/{courseId}")
	public CourseData updateCourse(@PathVariable Long courseId, @RequestBody CourseData courseData) {
		courseData.setCourseId(courseId);
		log.info("Updating course {}", courseData);
		return courseService.saveCourse(courseData);
	}
	
	@GetMapping("/course/{courseId}")
	public CourseData retrieveCourse(@PathVariable Long courseId) {
		log.info("Retrieving course with ID={}", courseId);
		return courseService.retrieveCourseById(courseId);
	}
	
	@DeleteMapping("/course/{courseId}")
	public Map<String, String> deleteCourse(@PathVariable Long courseId) {
		log.info("Deleting course with ID=" + courseId + ".");
		courseService.deleteCourse(courseId);
		
		return Map.of("message", "Course with ID=" + courseId + " was deleted successfully");
	}
}
