package com.example.demo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojos.EmployeePojo;
import com.example.demo.services.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
	public String register(Model model) {
		model.addAttribute("obj",new EmployeePojo());
		return "register";
	}
	@PostMapping("")
	public String list(@ModelAttribute EmployeePojo employeePojo, Model model) {
		employeeService.create(employeePojo);
		
		return "redirect:/emp/list";
	}
	@GetMapping("/list")
	public String list(Model model) {
		Collection<EmployeePojo> employees=this.employeeService.getAllEmp();
		/* System.out.println(emp.getId());
		 * System.out.println(emp.getName());
		 * System.out.println(emp.getEmail());
		 * System.out.println(emp.getPassword());
		 * )))
		 * */
		model.addAttribute("employees", employees);
		return "list";
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id")Long id) {
		this.employeeService.deleteEmp(id);
		return"redirect:/emp/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") Long id) {
		EmployeePojo obj=this.employeeService.getEmpById(id);
		model.addAttribute("obj",obj);
		return "edit";
	}
	@PostMapping("/edit/{id}")
	public String editdetails(@PathVariable("id")Long id,@ModelAttribute EmployeePojo employeePojo ) {
		this.employeeService.updateEmp(id, employeePojo);
		return"redirect:/emp/list";
	}

}
