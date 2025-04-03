package sms.controller.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import sms.entity.Enrollment;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({"course"})
public class EnrollmentData {
	private Long enrollmentId;
	private Long studentId;
	private Date enrollmentDate;
	private char grade;
	private CourseData course;

	public EnrollmentData(Enrollment enrollment) {
		this.enrollmentId = enrollment.getEnrollmentId();
		this.studentId = enrollment.getStudent().getStudentId();
		this.enrollmentDate = enrollment.getEnrollmentDate();
		this.grade = enrollment.getGrade();
		
		if (enrollment.getCourse() != null) {
			this.course = new CourseData(enrollment.getCourse());
		}
	}

	public EnrollmentData(Long enrollmentId, Date enrollmentDate, char grade) {
		this.enrollmentId = enrollmentId;
		this.enrollmentDate = enrollmentDate;
		this.grade = grade;
	}

	public Enrollment toEnrollment() {
		Enrollment enrollment = new Enrollment();

		enrollment.setEnrollmentId(enrollmentId);
		enrollment.setEnrollmentDate(enrollmentDate);
		enrollment.setGrade(grade);

		if (course != null) {
			enrollment.setCourse(course.toCourse());
		}
		return enrollment;
	}
	
}
