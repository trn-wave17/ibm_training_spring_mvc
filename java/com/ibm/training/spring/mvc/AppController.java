package com.ibm.training.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.training.spring.mvc.service.AddService;

@Controller
public class AppController {
	
	@Autowired
	public AddService addService;
	
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

}
