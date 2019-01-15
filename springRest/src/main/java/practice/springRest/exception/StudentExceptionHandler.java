package practice.springRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Specialization of @Component for classes that declare @ExceptionHandler, @InitBinder, or @ModelAttribute methods to be shared acrossmultiple @Controller classes.
 */
// for handling the exceptions, uses AOP
@ControllerAdvice
public class StudentExceptionHandler {

	// we can handle the exceptions
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotfoundexception stnEx) {
		StudentErrorResponse str = new StudentErrorResponse(stnEx.getMessage(), HttpStatus.NOT_FOUND.value(), System.currentTimeMillis());
		return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
	
	} 
	
	// generic exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericStudentException(Exception stnEx) {
		StudentErrorResponse str = new StudentErrorResponse(stnEx.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis());
		return new ResponseEntity<>(str, HttpStatus.BAD_REQUEST);
	}
}
