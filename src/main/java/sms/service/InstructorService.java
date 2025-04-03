package sms.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sms.controller.model.InstructorData;
import sms.dao.InstructorDao;
import sms.entity.Instructor;

@Service
public class InstructorService {
	@Autowired
	private InstructorDao instructorDao;
	
	@Transactional(readOnly = true)
	public InstructorData retrieveInstructorById(Long instructorId) {
		Instructor instructor = findInstructorById(instructorId);
		return new InstructorData(instructor);
	}

	private Instructor findInstructorById(Long instructorId) {
		return instructorDao.findById(instructorId)
				.orElseThrow(() -> new NoSuchElementException("Instructor with ID=" + instructorId + " was not found"));
	}

}
