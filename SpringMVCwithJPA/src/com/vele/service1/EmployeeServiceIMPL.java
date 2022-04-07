package com.vele.service1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vele.businessbean.Employeebean;
import com.vele.dao.EmployeeDAO;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	private EmployeeDAO employeedao;

	@Override
	public Integer addEmployee(Employeebean employeebean) throws Exception {
		return employeedao.addEmployee(employeebean);
	}

	@Override
	public Employeebean getEmployeeById(int id) throws Exception {
		Employeebean emp = employeedao.getEmployeeById(id);
		if(emp==null) {
			throw new Exception("invalid Id");
		}
		return emp;
	}

	@Override
	public List<Employeebean> getEmployeeDetails() throws Exception {
		return employeedao.getEmployeeDetails();
	}

}
