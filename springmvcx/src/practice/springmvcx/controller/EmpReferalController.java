package practice.springmvcx.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import practice.springmvcx.bean.Employee;

@Controller
@RequestMapping("/emp")
public class EmpReferalController {
	
	@RequestMapping("/referEmp")
	
	public String referalForm(Model model) {
		System.out.println("In employee referal");
		Employee e = new Employee();
		System.out.println(e.getAllLanguages());
		model.addAttribute("AllLanguages", e.getAllLanguages());
		return "empReferal";
	}
	
	/*
	 * will add the returned obj to model with specified key.
	 * Methods with this annotation will be called prior to methods with @RequestMapping annotation
	 */
	@ModelAttribute("employee") 
	public Employee addEmpToModel() {
		System.out.println("Inside add to model ....");
		Employee emp = new Employee();
		return emp;
	}
	
	/**
	 * @ModelAttribute will inject the model attribute employee into the emp argument.
	 * The Model object emp injected will contain the data which is submitted through form
	 * When form is submitted, the data is saved into the model bean( employee) by calling setters
	 */
	@RequestMapping("/processReferal")
	public String referEmployee(@ModelAttribute("employee") Employee emp) {
		System.out.println(emp.getFirstName());
		return "referStatus";
	}
	


}
