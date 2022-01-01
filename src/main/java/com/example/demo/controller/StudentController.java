package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Student> getStudentDetail(@PathVariable(value="id") Long id){
		return ResponseEntity.ok().body(studentService.getStudentDetail(id));
		
	}
	
	@GetMapping(value="/search")
	public ResponseEntity<List<Student>> getStudentList(@RequestBody final StudentDTO student){
		return ResponseEntity.ok().body(studentService.getStudentList(student));
		
	}
	
	@GetMapping(value="/performance")
	public ResponseEntity<Object> getStudentPerformanceList(@RequestBody final StudentDTO student){
		return ResponseEntity.ok().body(studentService.getStudentPerformanceList(student));
		
	}

}
