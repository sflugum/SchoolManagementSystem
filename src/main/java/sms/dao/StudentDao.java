package sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sms.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
