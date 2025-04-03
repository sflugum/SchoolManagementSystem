package sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import sms.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
