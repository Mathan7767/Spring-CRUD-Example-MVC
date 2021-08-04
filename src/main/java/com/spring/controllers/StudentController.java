package com.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.StudentDao;
import com.spring.pojo.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao dao;

	@RequestMapping("/addStudent")
	public String addStudent(Model m) {
		Student student=new Student();
		m.addAttribute("command",student);

		return "addStudent";
	}

	@RequestMapping(path="/saveStudent",method = RequestMethod.POST) 
	public String saveStudent(@ModelAttribute("student") Student student) {
		dao.saveStudent(student);
		return "redirect:/viewStudent";
	}

	@RequestMapping(path="/viewStudent")
	public String getStudents(Model m) {
		List<Student> list=dao.getStudents();
		m.addAttribute("studentList", list);
		return "viewStudents";
	}

	@RequestMapping(path="/edit/{id}")
	public String editStudentById(@PathVariable int id,Model m) {
		Student student=dao.getStudentById(id);
		m.addAttribute("command", student);
		return "editStudent";	  
	}

	@RequestMapping(path="/updateStudent",method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student) {
		dao.updateStudent(student);
		return "redirect:/viewStudent";
	}
	@RequestMapping(path="/delete/{id}")
	public String deleteStudentById(@PathVariable int id) {
		dao.deleteStudentById(id);
		return "redirect:/viewStudent";
	}
}
