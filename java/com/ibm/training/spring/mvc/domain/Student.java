package com.ibm.training.spring.mvc.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//java persistence api implementation by hibernate framework
//sring data jpa - wrapper over existing jpa
@Entity
@javax.persistence.Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "gender")
	private String gender;
	@Column(name = "amount_spent")
	private int totalSpentInBooks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTotalSpentInBooks() {
		return totalSpentInBooks;
	}
	public void setTotalSpentInBooks(int totalSpentInBooks) {
		this.totalSpentInBooks = totalSpentInBooks;
	}
	public Student(int id, String firstName, String lastName, String email, String gender, int totalSpentInBooks) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.totalSpentInBooks = totalSpentInBooks;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
