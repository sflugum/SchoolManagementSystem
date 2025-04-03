package sms.controller.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import sms.entity.Course;
import sms.entity.Enrollment;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"students"})
public class CourseData {
	private Long courseId;
	private String courseTitle;
	private String courseCode;
	private double credits;
	private String description;
	private Set<StudentData> students = new HashSet<>();

	public CourseData(Course course) {
		this.courseId = course.getCourseId();
		this.courseTitle = course.getCourseTitle();
		this.courseCode = course.getCourseCode();
		this.credits = course.getCredits();
		this.description = course.getDescription();

		for (Enrollment enrollment : course.getEnrollments()) {
			if (enrollment.getStudent() != null) {
				this.students.add(new StudentData(enrollment.getStudent()));
			}
		}
	}

	public CourseData(Long courseId, String courseTitle, String courseCode, double credits, String description) {
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseCode = courseCode;
		this.credits = credits;
		this.description = description;
	}

	public Course toCourse() {
		Course course = new Course();

		course.setCourseId(courseId);
		course.setCourseTitle(courseTitle);
		course.setCourseCode(courseCode);
		course.setCredits(credits);
		course.setDescription(description);

		return course;
	}
}