package lk.harshana.app.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lk.harshana.app.model.Student;
import lk.harshana.app.repository.StudentRepository;
import lk.harshana.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	@Cacheable(value = "studentsCache", key = "#id", unless = "#result==null")
	public Student getStudent(Integer id) {
		return studentRepository.findById(id).get();
	}

	@Override
	@Cacheable(value = "studentsCache", key = "#firstName", unless = "#result==null")
	public List<Student> getByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	@Override
	@Cacheable(value = "studentsCache", key = "#lastName", unless = "#result==null")
	public Student getByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	@Override
	@Cacheable(value = "studentsCache", key = "#email", unless = "#result==null")
	public Student getByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	@CacheEvict(value = "studentsCache", key = "#id")
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
	@CachePut(value="studentsCache", key = "#id")
	public Student updateStudent(int id,Student student) {
		try {
			Student studentById = studentRepository.findById(id).get();
			if(studentById != null) {
				student.setStudentId(id);
				return studentRepository.save(student);
			}
			return null;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found", e);
		}
	}

	@Override
	public List<Student> getAllStudent() {
		
		return StreamSupport.stream(studentRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

}
