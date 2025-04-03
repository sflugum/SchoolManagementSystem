package sms.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long instructorId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	private List<Course> courses;

}
