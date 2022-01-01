package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.entity.Student;

@Component
public class StudentDao {
	
	@Autowired
	EntityManager entityManager;
	
    public List<Student> getStudentList(String sqlString,int pageSize,int page) {		
    	return entityManager.createQuery(sqlString,Student.class).setMaxResults(pageSize).setFirstResult((page-1) * pageSize).getResultList();
	}
    
    public List<Object> getStudentPerformanceList(StudentDTO student) {	
    	var sqlString = "select" + 
    			"	count(distinct sm.student_id) as student_count," + 
    			"	CASE" + 
    			"		when 750 < sm.total_marks_obtained then '75-100'" + 
    			"		when 500 < sm.total_marks_obtained <= 750 then '50-75'" + 
    			"		when 250 < sm.total_marks_obtained <= 500 then '25-50'" + 
    			"		when 0 <= sm.total_marks_obtained <= 250 then '0-25'" + 
    			"	END as category" + 
    			" from" + 
    			"	semester_master sm" + 
    			" inner join student_master sm2 on" + 
    			"	sm2.id = sm.student_id  and sm2.branch_code = '" + student.getBranchCode() + "'"+
    			" where" + 
    			"	sm.semester =" + student.getSemester() +""+
    			"	group by category";
    	return entityManager.createNativeQuery(sqlString).getResultList();
	}

}
