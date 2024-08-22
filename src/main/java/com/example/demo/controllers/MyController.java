package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.EmployeePojo;
@Controller
//@RestController
public class MyController {
	String name="raj";
	
	//@RequestMapping("/")
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("uname", name);
		return "home";
	}
//	@GetMapping("/emp/add")
//	public String register(Model model) {
//		model.addAttribute("obj",new EmployeePojo());
//		return "register";
//	}
//	@PostMapping("/emp/add")
//	public String list(@ModelAttribute EmployeePojo employeePojo, Model model) {
//		System.out.println(employeePojo);
//		model.addAttribute("obj", employeePojo);
//		return "list";
//	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
//	//@GetMapping("/first")
//	@RequestMapping("/first")
//	public String first() {
//		return "hello world";
//	}
//	//@GetMapping("/second")
//	public String second() {
//		return "second page";
//	}

}
