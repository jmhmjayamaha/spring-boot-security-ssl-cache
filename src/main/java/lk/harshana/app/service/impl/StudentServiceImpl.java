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
	public List<Student> getByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	@Override
	public Student getByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	@Override
	public Student getByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	public boolean deleteStudent(int id) {
		Student student = studentRepository.findById(id).get();
		if(student != null) {
			studentRepository.delete(student);
			return true;
		}
		return false;
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public Student updateStudent(int id,Student student) {
		Student studentById = studentRepository.findById(id).get();
		if(studentById != null) {
			student.setStudentId(id);
			return studentRepository.save(student);
		}
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		
		return StreamSupport.stream(studentRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

}
