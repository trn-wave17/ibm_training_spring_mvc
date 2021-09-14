package com.ibm.training.spring.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ibm.training.spring.mvc.domain.Student;
import com.ibm.training.spring.mvc.service.AddService;
import com.ibm.training.spring.mvc.service.StudentService;

@Controller
public class AppController {
	
	@Autowired
	public AddService addService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Gson gson;
	
	/*@RequestMapping(value= "/add", method = RequestMethod.GET)
	public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {
		
		int result = i+j;
		
		ModelAndView model = new ModelAndView();
		model.setViewName("add.jsp");
		model.addObject("result", result);
		
		return model;
	}*/
	
	
	@RequestMapping(value= "/add", method = RequestMethod.GET)
	public String add(Model modelMap, @RequestParam("num1") int i, @RequestParam("num2") int j) {
		
		modelMap.addAttribute("result", addService.add(i, j));
		//return "add.ftl";
		return "add";
		
	}
	
	@RequestMapping(value= "/subtract", method = RequestMethod.POST)
	public ModelAndView subtract(HttpServletRequest request, HttpServletResponse response) {
		
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		
		int result = i-j;
		
		ModelAndView model = new ModelAndView();
		model.setViewName("subtract");
		model.addObject("result", result);
		
		return model;
	}
	
	
	@RequestMapping("/showAddEmployeePage")
	public String showAddEmployeePage(Model model) {
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
	public String addEmployeeData(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "addEmployeeError";
		}
		model.addAttribute("employee", new Employee());
		return "addEmployee";
	}
	
	@RequestMapping("/showAddStudentPage")
	public String showAddStudentPage(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}
	
	@RequestMapping(value="/addStudent", method = RequestMethod.POST)
	public String addStudentData(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "addStudentError";
		}
		studentService.persist(student);
		model.addAttribute("student", new Student());
		return "addStudent";
	}
	
	@RequestMapping(value="/students", method = RequestMethod.GET)
	@ResponseBody
	public String getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return gson.toJson(students, ArrayList.class);
	}
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getStudentById(@PathVariable("id") int id) {
		Student student = studentService.getStudent(id);
		return gson.toJson(student, Student.class);
	}
	
	@RequestMapping(value="/updateStudent/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateRecord(@PathVariable("id") int id) {
		studentService.updateStudent(id);
		return "Updated successfully";
	}
	
	@RequestMapping(value="/deleteStudent/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteRecord(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return "Deleted successfully";
	}
	
	/*
	 * @RequestMapping("/employees")
	 * 
	 * @ResponseBody private String getEmployees(){ List<Employee> employees = new
	 * ArrayList<>(); employees.add(new Employee("1","Ankit", "Ankit@gmail.com"));
	 * employees.add(new Employee("1","Ankit", "Ankit@gmail.com"));
	 * employees.add(new Employee("1","Ankit", "Ankit@gmail.com")); Gson gson = new
	 * Gson(); return gson.toJson(employees, ArrayList.class); }
	 * 
	 * 
	 * @RequestMapping("/addEmployeePage") private String getAddEmployeePage(Model
	 * model){ model.addAttribute("employee", new Employee()); return "addEmployee";
	 * }
	 * 
	 * @RequestMapping("/addEmployee") private String addEmployee(Model
	 * model, @Valid Employee employee, BindingResult bindingResult){
	 * if(bindingResult.hasErrors()) { model.addAttribute("errors",
	 * bindingResult.getAllErrors()); } System.out.println(employee);
	 * 
	 * return "addEmployee"; }
	 */

}
