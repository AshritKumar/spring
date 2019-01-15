package practice.springRest.restc;

import java.util.List;

import javax.annotation.PostConstruct;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practice.springRest.entity.Student;
import practice.springRest.exception.StudentErrorResponse;
import practice.springRest.exception.StudentNotfoundexception;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void addStudents() {
		students = new ArrayList<>();
		students.add(new Student("Ashrit", "Kumar"));
		students.add(new Student("Rajesh","Raju"));
	}
	
	@RequestMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@RequestMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if(studentId > students.size())
			throw new StudentNotfoundexception("Student Not found with id "+studentId);
		return students.get(studentId);
		
	}
	

}
