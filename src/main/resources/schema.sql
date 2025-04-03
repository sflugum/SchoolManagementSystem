DROP TABLE IF EXISTS enrollment;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS instructor;
DROP TABLE IF EXISTS student;

CREATE TABLE student (
  student_id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(40) NOT NULL,
  address VARCHAR(256) NOT NULL,
  email VARCHAR(40),
  phone VARCHAR(20) NOT NULL,
  birthdate DATE NOT NULL,
  PRIMARY KEY(student_id)
);

CREATE TABLE instructor (
  instructor_id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(20) NOT NULL,
  last_name VARCHAR(40) NOT NULL,
  email VARCHAR(40) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  PRIMARY KEY(instructor_id)
);

CREATE TABLE course (
  course_id BIGINT NOT NULL AUTO_INCREMENT,
  instructor_id BIGINT,
  course_title VARCHAR(256) NOT NULL,
  course_code VARCHAR(20) NOT NULL,
  credits DECIMAL(5,2) NOT NULL,
  description TEXT,
  PRIMARY KEY(course_id), 
  FOREIGN KEY(instructor_id) REFERENCES instructor (instructor_id) ON DELETE CASCADE
);

CREATE TABLE enrollment (
  enrollment_id BIGINT NOT NULL AUTO_INCREMENT,
  student_id BIGINT NOT NULL,
  course_id BIGINT NOT NULL,
  enrollment_date DATE NOT NULL,
  grade CHAR(1),
  PRIMARY KEY(enrollment_id),
  FOREIGN KEY(student_id) REFERENCES student (student_id) ON DELETE CASCADE,
  FOREIGN KEY(course_id) REFERENCES course (course_id) ON DELETE CASCADE
);