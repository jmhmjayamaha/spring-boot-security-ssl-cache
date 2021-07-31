package lk.harshana.app.service;

import java.util.List;

import lk.harshana.app.model.Student;

public interface StudentService {

	Student getStudent(Integer id);
	
	List<Student> getByFirstName(String firstName);
	
	Student getByLastName(String lastName);
	
	Student getByEmail(String email);
	
	boolean deleteStudent(int id);
	
	void addStudent(Student student);
	
	Student updateStudent(int id,Student student);
	
	List<Student> getAllStudent();
}
