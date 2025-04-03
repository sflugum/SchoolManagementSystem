package sms.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sms.controller.model.CourseData;
import sms.dao.CourseDao;
import sms.entity.Course;

@Service
public class CourseService {
	@Autowired
	private CourseDao courseDao;

	@Transactional(readOnly = false)
	public CourseData saveCourse(CourseData courseData) {
		Course course = courseData.toCourse();
		Course dbCourse = courseDao.save(course);

		return new CourseData(dbCourse);
	}

	@Transactional(readOnly = true)
	public CourseData retrieveCourseById(Long courseId) {
		Course course = findCourseById(courseId);
		return new CourseData(course);
	}

	private Course findCourseById(Long courseId) {
		return courseDao.findById(courseId)
				.orElseThrow(() -> new NoSuchElementException("Course with ID=" + courseId + " was not found"));
	}

	@Transactional(readOnly = true)
	public List<CourseData> retrieveAllCourses() {
	    List<Course> courseEntities = courseDao.findAll();
	    List<CourseData> courseDtos = new LinkedList<>();

	    courseEntities.sort(Comparator.comparing(Course::getCourseTitle));

	    for (Course course : courseEntities) {
	    	CourseData courseData = new CourseData(course);
	        courseDtos.add(courseData);
	    }

	    return courseDtos;
	}


	@Transactional(readOnly = false)
	public void deleteCourse(Long courseId) {
		Course course = findCourseById(courseId);
		courseDao.delete(course);
	}
}
