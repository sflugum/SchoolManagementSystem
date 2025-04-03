package sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sms.entity.Enrollment;

public interface EnrollmentDao extends JpaRepository<Enrollment, Long> {

}
