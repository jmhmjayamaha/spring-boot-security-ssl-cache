package lk.harshana.app.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.app.dto.StudentDTO;
import lk.harshana.app.model.Student;
import lk.harshana.app.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") Integer id) {
		return studentService.getStudent(id);
	}
	
	@GetMapping("/findByFirstName")
	@ResponseStatus(value=HttpStatus.FOUND)
	public List<Student> getStudentByFirstName(@RequestParam("firstName") String firstName) {
		return studentService.getByFirstName(firstName);
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Student> getAllStudents() {
		return studentService.getAllStudent();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteStudent(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(value= HttpStatus.OK)
	public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
}
