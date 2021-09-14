package com.ibm.training.spring.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.training.spring.mvc.domain.Student;

@Repository
@Transactional
public class StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Student> getAllStudents(){
		Session session = this.sessionFactory.getCurrentSession();
		//return List.of(session.get(Student.class, 1));
		return session.createQuery("from Student").list();
	}
	
	public Student getStudent(int id){
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}
	
	public void persist(Student student){
		Session session = this.sessionFactory.getCurrentSession();
		session.save(student);
	}
	
	public void updateStudent(int id){
		Session session = this.sessionFactory.getCurrentSession();
		Student student= session.load(Student.class, id);
		student.setTotalSpentInBooks(200);
		session.saveOrUpdate(student);
	}
	
	
	public void deleteStudent(int id){
		Session session = this.sessionFactory.getCurrentSession();
		Student student= session.load(Student.class, id);
		session.delete(student);
	}

}
