package lk.harshana.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.app.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	List<Student> findByFirstName(String firstName);
	Student findByLastName(String lastName);
	Student findByEmail(String email);
}
