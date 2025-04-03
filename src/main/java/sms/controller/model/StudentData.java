package sms.controller.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import sms.entity.Enrollment;
import sms.entity.Student;

@Data
@NoArgsConstructor
public class StudentData {
	private Long studentId;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	private Date birthdate;
	
	public StudentData(Student student) {
		this.studentId = student.getStudentId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.address = student.getAddress();
		this.email = student.getEmail();
		this.phone = student.getPhone();
		this.birthdate = student.getBirthdate();
	}
	
	public StudentData (Long studentId, String firstName, String lastName, String address, String 
			email, String phone, Date birthdate) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.birthdate = birthdate;
	}

	public Student toStudent() {
		Student student = new Student();

		student.setStudentId(studentId);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setAddress(address);
		student.setEmail(email);
		student.setPhone(phone);
		student.setBirthdate(birthdate);

		return student;
	}
	
}
