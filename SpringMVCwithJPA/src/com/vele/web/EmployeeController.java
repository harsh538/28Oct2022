package com.vele.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vele.businessbean.Employeebean;
import com.vele.service1.EmployeeService;

@Controller
@SessionAttributes({ "empbj", "empobj2" })
public class EmployeeController {
	@Autowired
	private EmployeeService serve;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		binder.registerCustomEditor(Date.class, "DOJ", new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value = "/loadAddEmployee", method = RequestMethod.GET)
	public ModelAndView loadAddEmployee(Employeebean employeebean) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreateEmployee");
		modelAndView.addObject("empobj", new Employeebean());
		return modelAndView;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("empobj") Employeebean employeebean) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Integer i = serve.addEmployee(employeebean);
		modelAndView.setViewName("CreateEmployeeSuccess");
		modelAndView.addObject("msg", "Welcome: " + employeebean.getName());
		return modelAndView;
	}

	@RequestMapping(value = "/loadDetails", method = RequestMethod.GET)
	public ModelAndView LoadDetails() {
		List<Employeebean> list = new ArrayList<Employeebean>();
		ModelAndView modelAndView = new ModelAndView();
		try {
			list = serve.getEmployeeDetails();
			for (Employeebean employeebean : list) {
				System.out.println(employeebean.getId() + " " + employeebean.getName());
			}
			modelAndView.setViewName("Getdetails");
			modelAndView.addObject("emplist", list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/loadDetailsByid", method = RequestMethod.GET)
	public ModelAndView loadGetDetailsByid() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GetDetailsByid");
		modelAndView.addObject("empobj", new Employeebean());
		return modelAndView;
	}

	@RequestMapping(value = "/loadDetailsByid2",method=RequestMethod.POST)
	public ModelAndView getDetailsById(@ModelAttribute("empobj") Employeebean employeebean) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Employeebean eb = new Employeebean();
		try {
		eb = serve.getEmployeeById(employeebean.getId());
		}
		catch (Exception e) {
			modelAndView.setViewName("GetDetailsByid");
			modelAndView.addObject("msg","Employee Not found");
			return modelAndView;
		}
		modelAndView.setViewName("GetDetailsByid");
		modelAndView.addObject("empobj2", eb);
		return modelAndView;
	}

}
