package lk.harshana.app.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import lk.harshana.app.model.Student;

public interface StudentService {

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	Student getStudent(Integer id);
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	List<Student> getByFirstName(String firstName);
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	Student getByLastName(String lastName);
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	Student getByEmail(String email);
	
	@Secured({"ROLE_ADMIN"})
	boolean deleteStudent(int id);
	
	@Secured({"ROLE_ADMIN"})
	void addStudent(Student student);
	
	@Secured({"ROLE_ADMIN"})
	Student updateStudent(int id,Student student);
	
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	List<Student> getAllStudent();
}
