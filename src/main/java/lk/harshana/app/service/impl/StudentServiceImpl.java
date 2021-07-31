package lk.harshana.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.app.model.Student;
import lk.harshana.app.repository.StudentRepository;
import lk.harshana.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(Integer id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student getByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		
		return StreamSupport.stream(studentRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

}
