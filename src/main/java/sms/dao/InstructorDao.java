package sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sms.entity.Instructor;

public interface InstructorDao extends JpaRepository<Instructor, Long> {

}
