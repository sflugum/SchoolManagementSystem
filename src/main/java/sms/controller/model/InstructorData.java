package sms.controller.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import sms.entity.Course;
import sms.entity.Instructor;

@Data
@NoArgsConstructor
public class InstructorData {

	private Long instructorId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private List<CourseData> course = new ArrayList<>();
	
	public InstructorData(Instructor instructor) {
		this.instructorId = instructor.getInstructorId();
		this.firstName = instructor.getFirstName();
		this.lastName = instructor.getLastName();

		for (Course course : instructor.getCourses()) {
			this.course.add(new CourseData(course));
		}
	}

	public InstructorData(Long instructorId, String firstName, String lastName, 
			String email, String phone) {
		this.instructorId = instructorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public Instructor toInstructor() {
		Instructor instructor = new Instructor();

		instructor.setInstructorId(instructorId);
		instructor.setFirstName(firstName);
		instructor.setLastName(lastName);
		instructor.setEmail(email);
		instructor.setPhone(phone);
		
		return instructor;
	}
}
