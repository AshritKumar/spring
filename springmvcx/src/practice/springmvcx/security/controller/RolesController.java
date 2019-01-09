package practice.springmvcx.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RolesController {
	
	@GetMapping("/adminAction")
	public String adminController() {
		return "adminPage";
	}
	

	@GetMapping("/empAction")
	public String employeeController() {
		return "EmployeePage";
	}
	
	@GetMapping("/managerAction")
	public String employeeAndManagerController() {
		return "ManagerPage";
	}
	
	

}
