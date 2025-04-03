package sms.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sms.controller.model.StudentData;
import sms.dao.StudentDao;
import sms.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	@Transactional(readOnly = false)
	public StudentData saveStudent(StudentData studentData) {
		Student student = studentData.toStudent();
		Student dbStudent = studentDao.save(student);

		return new StudentData(dbStudent);
	}

	@Transactional(readOnly = true)
	public StudentData retrieveStudentById(Long studentId) {
		Student student = findStudentById(studentId);
		return new StudentData(student);
	}

	private Student findStudentById(Long studentId) {
		return studentDao.findById(studentId)
				.orElseThrow(() -> new NoSuchElementException("Student with ID=" + studentId + " was not found"));
	}

	@Transactional(readOnly = true)
	public List<StudentData> retrieveAllStudents() {
	    List<Student> studentEntities = studentDao.findAll();
	    List<StudentData> studentDtos = new LinkedList<>();

	    studentEntities.sort(Comparator.comparing(Student::getLastName));

	    for (Student student : studentEntities) {
	    	StudentData studentData = new StudentData(student);
	        studentDtos.add(studentData);
	    }

	    return studentDtos;
	}


	@Transactional(readOnly = false)
	public void deleteStudent(Long studentId) {
		Student student = findStudentById(studentId);
		studentDao.delete(student);
	}

}
