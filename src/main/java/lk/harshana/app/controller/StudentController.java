package lk.harshana.app.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudent();
	}
}
