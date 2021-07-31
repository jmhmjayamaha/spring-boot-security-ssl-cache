package lk.harshana.app.repository;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.app.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
