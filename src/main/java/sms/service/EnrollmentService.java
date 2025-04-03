package sms.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sms.controller.model.EnrollmentData;
import sms.dao.EnrollmentDao;
import sms.entity.Enrollment;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentDao enrollmentDao;

	@Transactional(readOnly = false)
	public EnrollmentData saveEnrollment(EnrollmentData enrollmentData) {
		Enrollment enrollment = enrollmentData.toEnrollment();
		Enrollment dbEnrollment = enrollmentDao.save(enrollment);

		return new EnrollmentData(dbEnrollment);
	}

	@Transactional(readOnly = true)
	public EnrollmentData retrieveEnrollmentById(Long enrollmentId) {
		Enrollment enrollment = findEnrollmentById(enrollmentId);
		return new EnrollmentData(enrollment);
	}

	private Enrollment findEnrollmentById(Long enrollmentId) {
		return enrollmentDao.findById(enrollmentId)
				.orElseThrow(() -> new NoSuchElementException("Enrollment with ID=" + enrollmentId + " was not found"));
	}

	@Transactional(readOnly = true)
	public List<EnrollmentData> retrieveAllEnrollments() {
	    List<Enrollment> enrollmentEntities = enrollmentDao.findAll();
	    List<EnrollmentData> enrollmentDtos = new LinkedList<>();

	    enrollmentEntities.sort(Comparator.comparing(Enrollment::getEnrollmentDate).reversed());

	    for (Enrollment enrollment : enrollmentEntities) {
	        EnrollmentData enrollmentData = new EnrollmentData(enrollment);
	        enrollmentDtos.add(enrollmentData);
	    }

	    return enrollmentDtos;
	}


	@Transactional(readOnly = false)
	public void deleteEnrollment(Long enrollmentId) {
		Enrollment enrollment = findEnrollmentById(enrollmentId);
		enrollmentDao.delete(enrollment);
	}

}
