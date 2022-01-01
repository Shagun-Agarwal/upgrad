package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentDao studentDao;
	
	public Student getStudentDetail(Long id) {
		var student = studentRepository.findById(id);
		return student.isPresent()?student.get() : null;
	}
	
	public List<Student> getStudentList(StudentDTO student) {
	
		String sql ="Select s from Student s where 1=1 ";

		StringBuilder sqlString = new StringBuilder(sql);
		if(student.getStudentId()!=null) {
			sqlString.append(" and s.id="+student.getStudentId() +" ");
		}
		
		if(student.getSemester()!=null) {
			sqlString.append(" and s.curentSemester="+student.getSemester() +" ");
		}
		
		if(student.getAdmissionYear()!=null) {
			sqlString.append(" and s.admissionYear="+student.getAdmissionYear() +" ");
		}
		
		if(student.getBranchCode()!=null) {
			sqlString.append(" and s.branchCode='"+student.getBranchCode() +"' ");
		}
		
		if(student.getCourse()!=null) {
			sqlString.append(" and s.course='"+student.getCourse() +"' ");
		}
		
		var studentList =  studentDao.getStudentList(sqlString.toString(),student.getPageSize(),student.getPage());
		var newList = studentList.stream().map(obj->{
			var object = new Student();
				object.setId(obj.getId());
				
				if(obj.getCode()!=null) {
					object.setCode(obj.getCode());
				}
				
				if(obj.getCurentSemester()!=null) {
					object.setCurentSemester(obj.getCurentSemester());
				}
		
				if(obj.getFirstName()!=null) {
					object.setFirstName(obj.getFirstName());
				}
				
				if(obj.getLastName()!=null) {
					object.setLastName(obj.getLastName());
				}
				
				if(obj.getAdmissionYear()!=null) {
					object.setAdmissionYear(obj.getAdmissionYear());
				}
				

				if(obj.getCourse()!=null) {
					object.setCourse(obj.getCourse());
				}
				
				if(obj.getEmail()!=null) {
					object.setEmail(obj.getEmail());
				}
			
				if(obj.getBranchCode()!=null) {
					object.setBranchCode(obj.getBranchCode());
				}
				
				if(obj.getMobile()!=null) {
					object.setMobile(obj.getMobile());
				}
				return object;
		}).collect(Collectors.toList());
		return newList;
	}
	
	public Object getStudentPerformanceList(StudentDTO student) {
		
		return studentDao.getStudentPerformanceList(student);
	}

}
