package sms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollmentId;
	
	private Date enrollmentDate;
	private char grade;
	
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	@JsonBackReference
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	@JsonBackReference
	private Course course;

	
}
