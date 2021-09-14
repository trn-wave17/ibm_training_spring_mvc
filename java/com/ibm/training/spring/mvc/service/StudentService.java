package com.ibm.training.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.spring.mvc.dao.StudentDao;
import com.ibm.training.spring.mvc.domain.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	public List<Student> getAllStudents(){
		return dao.getAllStudents();
	}
	
	public Student getStudent(int id){
		return dao.getStudent(id);
	}
	
	public void persist(Student student){
		dao.persist(student);
	}
	
	public void updateStudent(int id){
		dao.updateStudent(id);
	}
	
	public void deleteStudent(int id){
		dao.deleteStudent(id);
	}

}
