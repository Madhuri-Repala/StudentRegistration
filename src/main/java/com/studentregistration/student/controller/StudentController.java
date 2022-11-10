package com.studentregistration.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentregistration.student.model.Student;
import com.studentregistration.student.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentrepo;
	
	@RequestMapping("/")
	public String register() {
		return "register";
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudents(){
		return studentrepo.findAll();
	}
	
	@PostMapping("/register")
	public String validateStudent(ModelMap model,@RequestParam String firstname,@RequestParam String lastname,
			@RequestParam String address,@RequestParam String email,@RequestParam String password,@RequestParam String mobile) {
		
		List<Student> list=this.getAllStudents();
		String error="";
		model.put("errormsg",error);
		model.put("studentlist",list);
		for(Student stu:list) {
			if(stu.getEmail().equals(email) && stu.getMobile().equals(mobile)) {
				 error="Student Already exists with same Email and Mobile !!";
				 model.put("errormsg",error);
				 return "register";
			}
			else if(stu.getEmail().equals(email)) {
				error="Studnet Already exists with same Email!!";
				model.put("errormsg",error);
				return "register";
			}
			else if(stu.getMobile().equals(mobile)) {
				error="Studnet Already exists with same Mobile !!";
				model.put("errormsg",error);
				return "register";
			}
				
		}
		error="Registration Successfull !!";
		model.put("errormsg",error);
		Student s=new Student(firstname,lastname,address,email,password,mobile);
		studentrepo.save(s);
		model.put("stu",s);
		model.put("studentlist",list);
		
		return "register";
	}
	
}
