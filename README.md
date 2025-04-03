#📚 **School Management System**

##📓 **Overview**

The School Management System is a Java-based backend application that manages students, instructors, courses, and enrollments. The system provides CRUD operations for the course entity and ensures structured relationships using Spring Boot, Spring Data JPA, and Maven.

---

##🔥 **Features**

- Course Management: Add, update, delete, and view course information and instructor assignments.

- Student Management: Retrieve student details.

- Instructor Management: Retrieve instructors and their assigned courses.

- Enrollment System: Students courses and grades are recorded.

- RESTful APIs: Provides structured endpoints for seamless integration.

---

##🖥️ **Technologies Used**

- Java 17

- Spring Boot

- Spring Data JPA

- Hibernate

- Maven

- MySQL

- ARC 

---

##📋 **API Endpoints**

📙 **Course Endpoints**

- GET /courses - List all courses

- POST /courses - Add a new course

- PUT /courses/{id} - Update a course

- DELETE /courses/{id}

🧑‍💻 **Student Endpoint**

- GET /students/{id} - Retrieve a student by ID

🧑‍🏫 **Instructor Endpoint**

- GET /instructors - Retrieve all instructors

📝 **Enrollment Endpoint**

- GET /students/{id}/enrollments - View student enrollments

---

##▶️ **How to Run the Project**

  ✅ **Prerequisites**

- Install Java 17+

- Install Maven

- Set up a MySQL Database (or use H2 for testing)

🗒️ **Steps**

1. Clone the repository:

    git clone https://github.com/sflugum/SchoolManagementSystem.git
    cd SchoolManagementSystem

2. Configure database in application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/sch_mgmt
    spring.datasource.username=sch_mgmt
    spring.datasource.password=sch_mgmt

3. Build and run the application:

    mvn spring-boot:run

    Access the API via Postman or ARC at http://localhost:8080

---

##🔮 **Future Enhancements**

- Implement additional CRUD operations for students, instructors, and enrollments

- Add unit and integration testing using JUnit & Mockito

---

Developed by Silas Flugum ⚜️    
Contact: https://github.com/sflugum

